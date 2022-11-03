package com.indoor.woopy.domain.registeration.domain.repository;

import com.indoor.woopy.domain.registeration.domain.Registeration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterationRepository extends CrudRepository<Registeration, Long> {
}
