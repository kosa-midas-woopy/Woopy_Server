package com.indoor.woopy.domain.admin.exception;

import com.indoor.woopy.global.error.exception.GlobalErrorCode;
import com.indoor.woopy.global.error.exception.WoopyException;

public class AlreadyAdminExistException extends WoopyException {


    public static final WoopyException EXCEPTION =
            new AlreadyAdminExistException();

    private AlreadyAdminExistException() {
        super(GlobalErrorCode.ALREADY_ADMIN_EXIST);
    }
}
