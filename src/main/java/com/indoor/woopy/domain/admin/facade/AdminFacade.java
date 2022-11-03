package com.indoor.woopy.domain.admin.facade;

import com.indoor.woopy.domain.admin.domain.Admin;
import com.indoor.woopy.domain.admin.domain.repository.AdminRepository;
import com.indoor.woopy.domain.admin.exception.AdminNotFoundException;
import com.indoor.woopy.domain.admin.exception.AlreadyAdminExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminFacade {

    private final AdminRepository adminRepository;

    public Admin getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getAdminByEmail(email);
    }

    public Admin getAdminByEmail(String id) {
        return adminRepository.findByEmail(id)
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);
    }

    public Admin getAdminById(Long adminId) {
        return adminRepository.findById(adminId)
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);
    }

    public void checkAdminExists(String email) {
        if (adminRepository.findByEmail(email).isPresent()) {
            throw AlreadyAdminExistException.EXCEPTION;
        }
    }
}
