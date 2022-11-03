package com.indoor.woopy.domain.admin.service;

import com.indoor.woopy.domain.admin.domain.Admin;
import com.indoor.woopy.domain.admin.domain.repository.AdminRepository;
import com.indoor.woopy.domain.admin.presentation.dto.request.AdminSignInRequest;
import com.indoor.woopy.domain.admin.presentation.dto.response.AdminTokenResponse;
import com.indoor.woopy.domain.auth.exception.PasswordMismatchException;
import com.indoor.woopy.global.exception.UserNotFoundException;
import com.indoor.woopy.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AdminSignInService {


    private final AdminRepository adminRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public AdminTokenResponse execute(AdminSignInRequest request) {
        Admin admin = adminRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(admin.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(admin.getEmail());

        return AdminTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .refreshToken(refreshToken)
                .build();
    }
}
