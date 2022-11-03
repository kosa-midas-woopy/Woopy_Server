package com.indoor.woopy.global.exception;

import com.indoor.woopy.global.error.exception.GlobalErrorCode;
import com.indoor.woopy.global.error.exception.WoopyException;

public class ExpiredJwtException extends WoopyException {

    public static final WoopyException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(GlobalErrorCode.EXPIRED_JWT);
    }
}
