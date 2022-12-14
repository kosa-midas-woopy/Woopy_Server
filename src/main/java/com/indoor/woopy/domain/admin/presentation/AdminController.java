package com.indoor.woopy.domain.admin.presentation;

import com.indoor.woopy.domain.admin.presentation.dto.request.AdminSignInRequest;
import com.indoor.woopy.domain.admin.presentation.dto.request.AdminSignUpRequest;
import com.indoor.woopy.domain.admin.presentation.dto.request.AdminToUserUpdateRequest;
import com.indoor.woopy.domain.admin.presentation.dto.response.AdminTokenResponse;
import com.indoor.woopy.domain.admin.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final AdminSignUpService adminSignUpService;
    private final AdminSignInService adminSignInService;
    private final AdminLogOutService adminLogOutService;
    private final AdminWithdrawalService adminWithdrawalService;
    private final AdminToUserUpdateService adminToUserUpdateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AdminTokenResponse adminSignUp(@RequestBody @Valid AdminSignUpRequest request) {
        return adminSignUpService.execute(request);
    }

    @PostMapping("/token")
    public AdminTokenResponse adminSignIn(@RequestBody @Valid AdminSignInRequest request) {
        return adminSignInService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        adminLogOutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/leave")
    public void leave() {
        adminWithdrawalService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/updateUser/{email}")
    public void setAdminToUserUpdate(@RequestBody @Valid AdminToUserUpdateRequest request) {
        adminToUserUpdateService.execute(request);
    }
}
