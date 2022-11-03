package com.indoor.woopy.domain.user.presentation;

import com.indoor.woopy.domain.user.presentation.dto.request.UpdateUserRequest;
import com.indoor.woopy.domain.auth.presentation.dto.response.UserTokenResponse;
import com.indoor.woopy.domain.user.presentation.dto.request.UserSignUpRequest;
import com.indoor.woopy.domain.user.service.UpdateUserService;
import com.indoor.woopy.domain.user.service.UserLogOutService;
import com.indoor.woopy.domain.user.service.UserSignUpService;
import com.indoor.woopy.domain.user.service.UserWithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserLogOutService userLogOutService;
    private final UserWithdrawalService userWithdrawalService;
    private final UpdateUserService updateUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserTokenResponse userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        return userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        userLogOutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/leave")
    public void leave() {
        userWithdrawalService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/")
    public void updateUser(UpdateUserRequest request) {
        updateUserService.execute(request);
    }
}
