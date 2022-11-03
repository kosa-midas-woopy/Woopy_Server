package com.indoor.woopy.domain.work.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.indoor.woopy.global.enums.WorkStatus;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Getter
@Builder
public class LeaveworkingResponse {

    @NotBlank
    private final WorkStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final String date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final ZonedDateTime endWorkTime;

}
