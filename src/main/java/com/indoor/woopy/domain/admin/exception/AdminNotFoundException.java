package com.indoor.woopy.domain.admin.exception;

import com.indoor.woopy.global.error.exception.GlobalErrorCode;
import com.indoor.woopy.global.error.exception.WoopyException;

public class AdminNotFoundException extends WoopyException {


    public static final WoopyException EXCEPTION =
            new AdminNotFoundException();

    private AdminNotFoundException() {
        super(GlobalErrorCode.ADMIN_NOT_FOUND);
    }
}
