package com.varchar6.petcast.domain.notice.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_notice")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Column(name = "updated_at", nullable = false)
    private String updatedAt;

    @Column(name = "active_yn", nullable = false)
    private boolean activeYn;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "view", nullable = false)
    private int view;

    @Column(name = "member_notice_id")
    private int memberNoticeId;

    @Column(name = "top_fix", nullable = false)
    private boolean topFix;
}
