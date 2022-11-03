package com.indoor.woopy.domain.work.service;

import com.indoor.woopy.domain.work.domain.Work;
import com.indoor.woopy.domain.work.domain.repository.WorkRepository;
import com.indoor.woopy.domain.work.presentation.dto.response.LeaveworkingResponse;
import com.indoor.woopy.global.enums.WorkStatus;
import com.indoor.woopy.global.utils.time.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class LeaveworkingService {

    private final WorkRepository workRepository;

    @Transactional
    public LeaveworkingResponse execute() {
        Work work = workRepository.save(Work.builder()
                .status(WorkStatus.LEAVE_WORKING)
                .build());

        return LeaveworkingResponse.builder()
                .status(WorkStatus.LEAVE_WORKING)
                .date(String.valueOf(TimeUtil.now()))
                .endWorkTime(TimeUtil.now())
                .build();
    }

}
