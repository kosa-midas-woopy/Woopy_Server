package com.indoor.woopy.domain.user.domain;

import com.indoor.woopy.domain.registeration.domain.Registeration;
import com.indoor.woopy.domain.work.domain.Work;
import com.indoor.woopy.global.entity.BaseEntity;
import com.indoor.woopy.global.enums.UserRole;
import com.indoor.woopy.global.enums.WorkStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 45)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 11)
    private String name;

    @NotNull
    @Size(max = 30)
    private String companyName;

    @NotNull
    @Size(max = 20)
    private String department;

    @NotNull
    @Size(max = 30)
    private String position;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Work> works;

    @OneToMany(mappedBy = "user")
    private List<Registeration> registerations;

    @Builder
    public User(String email, String password, String name, String companyName,
                String department, String position, UserRole role, WorkStatus status) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.companyName = companyName;
        this.department = department;
        this.position = position;
        this.role = role;
    }
}
