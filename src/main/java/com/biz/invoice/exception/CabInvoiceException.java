package com.biz.invoice.service.exception;

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
        INVALID_TIME;

    }
}