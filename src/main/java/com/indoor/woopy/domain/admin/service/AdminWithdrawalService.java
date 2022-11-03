package com.indoor.woopy.domain.admin.service;

import com.indoor.woopy.domain.admin.domain.Admin;
import com.indoor.woopy.domain.admin.domain.repository.AdminRepository;
import com.indoor.woopy.domain.admin.facade.AdminFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AdminWithdrawalService {

    private AdminFacade adminFacade;
    private AdminRepository adminRepository;

    @Transactional
    public void execute() {
        Admin admin = adminFacade.getCurrentUser();

        adminRepository.delete(admin);

    }
}
