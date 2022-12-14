package com.indoor.woopy.domain.auth.presentation.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserSignInRequest {

    @NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Email
    private String email;

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
            "<=>?@＼^_`{|}~]{8,60}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되고 8자 이상이어야 합니다.")
    private String password;

}

