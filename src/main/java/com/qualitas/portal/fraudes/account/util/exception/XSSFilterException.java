package com.qualitas.portal.fraudes.account.util.exception;

public class XSSFilterException extends RuntimeException {
    public XSSFilterException(String message, Throwable cause) {
        super(message, cause);
    }
}
