package com.encora.starship.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HiperiumException extends RuntimeException {

    private final String errorCode;
    private final String errorMessageKey;

}
