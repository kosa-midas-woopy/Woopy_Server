package com.indoor.woopy.global.exception;

import com.indoor.woopy.global.error.exception.GlobalErrorCode;
import com.indoor.woopy.global.error.exception.WoopyException;

public class AlreadyUserExistException extends WoopyException {

    public static final WoopyException EXCEPTION =
            new AlreadyUserExistException();

    private AlreadyUserExistException() {
        super(GlobalErrorCode.ALREADY_USER_EXIST);
    }
}
