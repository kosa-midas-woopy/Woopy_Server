package com.indoor.woopy.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class WoopyException extends RuntimeException {

    private final GlobalErrorCode globalErrorCode;
}
