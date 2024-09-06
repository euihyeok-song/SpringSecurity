package com.varchar6.petcast.domain.notice.command.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoticeUpdateRequestDTO {
    private int id;
    private String title;
    private String description;
    private boolean topFix;
}
