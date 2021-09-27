package com.biz.invoice.exception;

public class CabInvoiceException extends RuntimeException
{

    public ExceptionType type;

    public CabInvoiceException(ExceptionType type, String message)
    {
        super(message);
        this.type = type;
    }
    public enum ExceptionType
    {
        INVALID_DISTANCE,
        NULL_RIDES,
        INVALID_USER_ID,
        INVALID_RIDETYPE,
        INVALID_TIME;
    }
}