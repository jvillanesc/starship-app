package com.encora.starship.exception;

import com.encora.starship.exception.enums.BussinesErrorEnum;

public class BussinesException extends HiperiumException {

    public BussinesException(BussinesErrorEnum errorEnum) {
        super(errorEnum.getCode(), errorEnum.getMessage());
    }
}
