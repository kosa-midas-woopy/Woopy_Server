package com.indoor.woopy.domain.user.facade;

import com.indoor.woopy.domain.user.domain.User;
import com.indoor.woopy.domain.user.domain.repository.UserRepository;
import com.indoor.woopy.domain.user.exception.AlreadyUserExistException;
import com.indoor.woopy.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    public User getUserByEmail(String id) {
        return userRepository.findByEmail(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkUserExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw AlreadyUserExistException.EXCEPTION;
        }
    }
}
