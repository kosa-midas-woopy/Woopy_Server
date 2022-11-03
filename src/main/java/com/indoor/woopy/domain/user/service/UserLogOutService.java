package com.indoor.woopy.domain.user.service;

import com.indoor.woopy.domain.auth.domain.RefreshToken;
import com.indoor.woopy.domain.auth.domain.repository.RefreshTokenRepository;
import com.indoor.woopy.domain.auth.exception.RefreshTokenNotFoundException;
import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserLogOutService {


    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(user.getEmail())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}
