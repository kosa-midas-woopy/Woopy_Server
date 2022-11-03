package com.indoor.woopy.domain.auth.presentation;

import com.indoor.woopy.domain.auth.presentation.dto.request.UserSignInRequest;
import com.indoor.woopy.domain.auth.presentation.dto.response.UserTokenResponse;
import com.indoor.woopy.domain.auth.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserSignInService userSignInService;

    @PostMapping("/token")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }
}
