package com.indoor.woopy.domain.work.service;

import com.indoor.woopy.domain.work.domain.Work;
import com.indoor.woopy.domain.work.domain.repository.WorkRepository;
import com.indoor.woopy.domain.work.presentation.dto.response.GoworkingResponse;
import com.indoor.woopy.global.enums.WorkStatus;
import com.indoor.woopy.global.utils.time.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class GoworkingService {

    private final WorkRepository workRepository;

    @Transactional
    public GoworkingResponse execute() {
        Work work = workRepository.save(Work.builder()
                .status(WorkStatus.WORKING)
                .build());

        return GoworkingResponse.builder()
                .status(WorkStatus.WORKING)
                .date(String.valueOf(TimeUtil.now()))
                .startWorkTime(TimeUtil.now())
                .build();
    }

}
