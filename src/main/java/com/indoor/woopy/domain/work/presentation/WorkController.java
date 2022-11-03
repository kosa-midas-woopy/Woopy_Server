package com.indoor.woopy.domain.work.presentation;

import com.indoor.woopy.domain.work.presentation.dto.response.GoworkingResponse;
import com.indoor.woopy.domain.work.presentation.dto.response.LeaveworkingResponse;
import com.indoor.woopy.domain.work.presentation.dto.response.CoculateWorkResponse;
import com.indoor.woopy.domain.work.service.GoworkingService;
import com.indoor.woopy.domain.work.service.LeaveworkingService;
import com.indoor.woopy.domain.work.service.CoculateWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/works")
@RestController
public class WorkController {

    private final GoworkingService goworkingService;
    private final LeaveworkingService leaveworkingService;
    private final CoculateWorkService coculateWorkService;

    @PostMapping("/go")
    public GoworkingResponse goworking() {
        return goworkingService.execute();
    }

    @PostMapping("/leave")
    public LeaveworkingResponse leaveworking() {
        return leaveworkingService.execute();
    }

    @GetMapping("/")
    public CoculateWorkResponse calculate() {
        return coculateWorkService.execute();
    }
}
