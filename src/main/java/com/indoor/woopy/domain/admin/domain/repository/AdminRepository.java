package com.indoor.woopy.domain.admin.domain.repository;

import com.indoor.woopy.domain.admin.domain.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);
}
