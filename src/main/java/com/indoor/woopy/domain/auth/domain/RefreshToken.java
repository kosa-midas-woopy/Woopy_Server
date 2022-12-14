package com.indoor.woopy.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_refreshToken")
public class RefreshToken {

    @Id
    private String email;

    @NotNull
    private String token;

    @NotNull
    private Long timeToLive;

    @Builder
    public RefreshToken(String email, String token, Long timeToLive) {
        this.email = email;
        this.token = token;
        this.timeToLive = timeToLive;
    }

    public RefreshToken updateToken(String token, Long timeToLive) {
        this.token = token;
        this.timeToLive = timeToLive;
        return this;
    }

}
