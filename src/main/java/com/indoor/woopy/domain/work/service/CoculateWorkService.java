package com.indoor.woopy.domain.work.service;

import com.indoor.woopy.domain.work.domain.repository.WorkRepository;
import com.indoor.woopy.domain.work.presentation.dto.response.CoculateWorkResponse;
import com.indoor.woopy.global.utils.time.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CoculateWorkService {

    private final WorkRepository workRepository;

    @Transactional
    public CoculateWorkResponse execute() {


        return CoculateWorkResponse.builder()
                .startWorkTime(String.valueOf(TimeUtil.now()))
                .endWorkTime(TimeUtil.now())
                .build();
    }
}
