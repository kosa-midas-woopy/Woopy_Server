package com.indoor.woopy.domain.admin.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminToUserUpdateRequest {

    private String name;

    private String department;

    private String position;
}
