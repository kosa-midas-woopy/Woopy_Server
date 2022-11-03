package com.indoor.woopy.global.exception;

import com.indoor.woopy.global.error.exception.GlobalErrorCode;
import com.indoor.woopy.global.error.exception.WoopyException;

public class UserNotFoundException extends WoopyException {

    public static final WoopyException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(GlobalErrorCode.USER_NOT_FOUND);
    }
}
