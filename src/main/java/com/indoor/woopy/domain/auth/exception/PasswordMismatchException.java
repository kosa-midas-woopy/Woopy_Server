package com.indoor.woopy.domain.auth.exception;

import com.indoor.woopy.global.error.exception.GlobalErrorCode;
import com.indoor.woopy.global.error.exception.WoopyException;

public class PasswordMismatchException extends WoopyException{

    public static final WoopyException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(GlobalErrorCode.PASSWORD_MISMATCH);
    }
}
