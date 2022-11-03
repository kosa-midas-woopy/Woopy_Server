package com.indoor.woopy.domain.work.domain;

import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.global.entity.BaseEntity;
import com.indoor.woopy.global.enums.WorkStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_work")
public class Work extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private WorkStatus status;

    @Column
    private String startWorkTIme;

    @Column
    private String endWorkTime;


    @Column
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Work(Long id, String startWorkTIme, WorkStatus status, String endWorkTime, String date, User user) {
        this.id = id;
        this.startWorkTIme = startWorkTIme;
        this.status = status;
        this.endWorkTime = endWorkTime;
        this.date = date;
        this.user = user;
    }

    public void updateUser(User user) {
        this.user = user;
    }
}
