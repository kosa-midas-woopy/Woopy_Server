package com.indoor.woopy.domain.admin.service;

import com.indoor.woopy.domain.admin.presentation.dto.request.AdminToUserUpdateRequest;
import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AdminToUserUpdateService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(AdminToUserUpdateRequest request) {
        User user = userFacade.getCurrentUser();
        user.updateUserByAdmin(request);
    }
}
