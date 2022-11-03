package com.indoor.woopy.domain.user.service;

import com.indoor.woopy.domain.auth.presentation.dto.response.UserTokenResponse;
import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.domain.user.domain.repository.UserRepository;
import com.indoor.woopy.domain.user.facade.UserFacade;
import com.indoor.woopy.domain.user.presentation.dto.request.UserSignUpRequest;
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
public class UserSignUpService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserTokenResponse execute(UserSignUpRequest request) {
        userFacade.checkUserExists(request.getEmail());

        User user = userRepository.save(User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .companyName(request.getCompanyName())
                .department(request.getDepartment())
                .position(request.getPosition())
                .role(UserRole.USER)
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(ZonedDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }
}
