package com.varchar6.petcast.domain.notice.command.application.service;

import com.varchar6.petcast.domain.notice.command.application.dto.request.NoticeUpdateRequestDTO;
import com.varchar6.petcast.domain.notice.command.application.dto.request.NoticeWriteRequestDTO;
import com.varchar6.petcast.domain.notice.command.application.dto.response.NoticeResponseDTO;
import com.varchar6.petcast.domain.notice.command.domain.aggregate.Notice;
import com.varchar6.petcast.domain.notice.command.domain.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service(value = "commandNoticeService")
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;

    private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

    @Autowired
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<NoticeResponseDTO> findAllNoticeList() {
        return  noticeRepository.findAll().stream()
                .map(
                        notice -> {
                            NoticeResponseDTO noticeResponseDTO = new NoticeResponseDTO();

                            noticeResponseDTO.setId(notice.getId());
                            noticeResponseDTO.setTitle(notice.getTitle());
                            noticeResponseDTO.setCreatedAt(notice.getCreatedAt());
                            noticeResponseDTO.setUpdatedAt(notice.getUpdatedAt());
                            noticeResponseDTO.setActiveYn(notice.isActiveYn());
                            noticeResponseDTO.setDescription(notice.getDescription());
                            noticeResponseDTO.setView(notice.getView());
                            noticeResponseDTO.setMemberNoticeId(notice.getMemberNoticeId());
                            noticeResponseDTO.setTopFix(notice.isTopFix());
                            return noticeResponseDTO;
                        }
                ).toList();
    }

    @Transactional
    public NoticeResponseDTO createNotice(NoticeWriteRequestDTO noticeWriteRequestDTO) {
        NoticeResponseDTO noticeResponseDTO = new NoticeResponseDTO();

        Notice notice = noticeRepository.save(
                requestDTOToEntity(noticeWriteRequestDTO)
        );

        noticeResponseDTO.setId(notice.getId());
        noticeResponseDTO.setTitle(notice.getTitle());
        noticeResponseDTO.setCreatedAt(notice.getCreatedAt());
        noticeResponseDTO.setUpdatedAt(notice.getUpdatedAt());
        noticeResponseDTO.setActiveYn(notice.isActiveYn());
        noticeResponseDTO.setDescription(notice.getDescription());
        noticeResponseDTO.setView(notice.getView());
        noticeResponseDTO.setMemberNoticeId(notice.getMemberNoticeId());
        noticeResponseDTO.setTopFix(notice.isTopFix());

        return noticeResponseDTO;

    }

    @Transactional
    public NoticeResponseDTO updateNotice(NoticeUpdateRequestDTO noticeUpdateRequestDTO) {
        NoticeResponseDTO noticeResponseDTO = new NoticeResponseDTO();

        Notice foundNotice = noticeRepository.findById(noticeUpdateRequestDTO.getId())
                .orElseThrow(IllegalAccessError::new);

        foundNotice.setTitle(noticeUpdateRequestDTO.getTitle());
        foundNotice.setDescription(noticeUpdateRequestDTO.getDescription());
        foundNotice.setTopFix(noticeUpdateRequestDTO.isTopFix());
        foundNotice.setUpdatedAt(LocalDateTime.now().format(FORMATTER));

        noticeResponseDTO.setId(foundNotice.getId());
        noticeResponseDTO.setTitle(foundNotice.getTitle());
        noticeResponseDTO.setCreatedAt(foundNotice.getCreatedAt());
        noticeResponseDTO.setUpdatedAt(foundNotice.getUpdatedAt());
        noticeResponseDTO.setActiveYn(foundNotice.isActiveYn());
        noticeResponseDTO.setDescription(foundNotice.getDescription());
        noticeResponseDTO.setView(foundNotice.getView());
        noticeResponseDTO.setMemberNoticeId(foundNotice.getMemberNoticeId());
        noticeResponseDTO.setTopFix(foundNotice.isTopFix());

        return noticeResponseDTO;
    }

    @Transactional
    public void deleteNotice(int noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    private static Notice requestDTOToEntity(NoticeWriteRequestDTO noticeWriteRequestDTO) {
        return Notice.builder()
                .title(noticeWriteRequestDTO.getTitle())
                .createdAt(
                        LocalDateTime.now()
                                .format(FORMATTER)
                )
                .updatedAt(
                        LocalDateTime.now()
                                .format(FORMATTER)
                )
                .activeYn(true)
                .description(noticeWriteRequestDTO.getDescription())
                .view(0)
                .memberNoticeId(noticeWriteRequestDTO.getMemberNoticeId())
                .topFix(noticeWriteRequestDTO.isTopFix())
                .build();
    }
}
