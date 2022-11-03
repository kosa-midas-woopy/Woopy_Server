package com.indoor.woopy.domain.user.service;

import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.domain.user.domain.repository.UserRepository;
import com.indoor.woopy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserWithdrawalService {

    private UserFacade userFacade;
    private UserRepository userRepository;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        userRepository.delete(user);

    }
}
