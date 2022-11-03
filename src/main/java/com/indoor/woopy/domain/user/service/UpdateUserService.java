package com.indoor.woopy.domain.user.service;

import com.indoor.woopy.domain.user.presentation.dto.request.UpdateUserRequest;
import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateUserRequest request) {
        User user = userFacade.getCurrentUser();
        user.updateUser(request);
    }
}
