package com.varchar6.petcast.domain.notice.command.application.service;

import com.varchar6.petcast.domain.notice.command.application.dto.request.NoticeUpdateRequestDTO;
import com.varchar6.petcast.domain.notice.command.application.dto.request.NoticeWriteRequestDTO;
import com.varchar6.petcast.domain.notice.command.application.dto.response.NoticeResponseDTO;

import java.util.List;


public interface NoticeService {
    List<NoticeResponseDTO> findAllNoticeList();

    NoticeResponseDTO createNotice(NoticeWriteRequestDTO noticeWriteRequestDTO);
    NoticeResponseDTO updateNotice(NoticeUpdateRequestDTO noticeUpdateRequestDTO);
    void deleteNotice(int noticeId);
}
