package com.varchar6.petcast.domain.notice.query.service;

import com.varchar6.petcast.domain.notice.query.dto.NoticeDTO;
import com.varchar6.petcast.domain.notice.query.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service(value="queryNoticeService")
public class NoticeService {
    private final NoticeMapper noticeMapper;

    @Autowired
    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public NoticeDTO getNoticeById(int memberId) {
        return noticeMapper.selectNoticeByNoticeId(memberId);
    }

    public List<NoticeDTO> getAllNotices() {
        return noticeMapper.selectAllNotice();
    }

}
