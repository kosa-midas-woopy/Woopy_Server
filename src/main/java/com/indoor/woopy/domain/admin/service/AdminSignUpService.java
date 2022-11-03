package com.indoor.woopy.domain.admin.service;

import com.indoor.woopy.domain.admin.domain.Admin;
import com.indoor.woopy.domain.admin.domain.repository.AdminRepository;
import com.indoor.woopy.domain.admin.facade.AdminFacade;
import com.indoor.woopy.domain.admin.presentation.dto.request.AdminSignUpRequest;
import com.indoor.woopy.domain.admin.presentation.dto.response.AdminTokenResponse;
import com.indoor.woopy.domain.auth.presentation.dto.response.UserTokenResponse;
import com.indoor.woopy.global.enums.UserRole;
import com.indoor.woopy.global.property.jwt.JwtProperties;
import com.indoor.woopy.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class AdminSignUpService {

    private final AdminFacade adminFacade;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public AdminTokenResponse execute(AdminSignUpRequest request) {
        adminFacade.checkAdminExists(request.getEmail());

        Admin admin = adminRepository.save(Admin.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .companyName(request.getCompanyName())
                .role(UserRole.ADMIN)
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(admin.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(admin.getEmail());

        return AdminTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(ZonedDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }
}
