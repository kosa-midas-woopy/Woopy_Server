package com.indoor.woopy.domain.auth.service;

import com.indoor.woopy.domain.auth.exception.PasswordMismatchException;
import com.indoor.woopy.domain.auth.presentation.dto.request.UserSignInRequest;
import com.indoor.woopy.domain.auth.presentation.dto.response.UserTokenResponse;
import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.domain.user.domain.repository.UserRepository;
import com.indoor.woopy.global.exception.UserNotFoundException;
import com.indoor.woopy.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {


    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserTokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .refreshToken(refreshToken)
                .build();
    }
}
