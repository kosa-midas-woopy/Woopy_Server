package com.indoor.woopy.domain.admin.service;

import com.indoor.woopy.domain.admin.domain.Admin;
import com.indoor.woopy.domain.admin.facade.AdminFacade;
import com.indoor.woopy.domain.auth.domain.RefreshToken;
import com.indoor.woopy.domain.auth.domain.repository.RefreshTokenRepository;
import com.indoor.woopy.domain.auth.exception.RefreshTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AdminLogOutService {

    private final AdminFacade adminFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        Admin admin = adminFacade.getCurrentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(admin.getEmail())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}
