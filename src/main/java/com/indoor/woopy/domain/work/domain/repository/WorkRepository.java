package com.indoor.woopy.domain.work.domain.repository;

import com.indoor.woopy.domain.work.domain.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {
}
