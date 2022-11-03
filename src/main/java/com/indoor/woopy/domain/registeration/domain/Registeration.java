package com.indoor.woopy.domain.registeration.domain;

import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.global.entity.BaseEntity;
import com.indoor.woopy.global.enums.ApproveStatus;
import com.indoor.woopy.global.enums.WorkType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_registeration")
public class Registeration extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private WorkType workType;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ApproveStatus approveStatus;

    @NotNull
    private String date;

    @NotNull
    private String registerationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Registeration(Long id, WorkType workType, ApproveStatus approveStatus, String date, String registerationDate, User user) {
        this.id = id;
        this.workType = workType;
        this.approveStatus = approveStatus;
        this.date = date;
        this.registerationDate = registerationDate;
        this.user = user;
    }
}
