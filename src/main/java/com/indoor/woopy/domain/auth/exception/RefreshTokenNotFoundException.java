package com.indoor.woopy.domain.auth.exception;

import com.indoor.woopy.global.error.exception.GlobalErrorCode;
import com.indoor.woopy.global.error.exception.WoopyException;

public class RefreshTokenNotFoundException extends WoopyException {

    public static final WoopyException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(GlobalErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
