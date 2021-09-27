package com.biz.invoice.model;

public enum RideType
{
    NORMAL,
    PREMIUM;
    public static final int SIZE =Integer.SIZE;

    public int getValue()
    {
        return this.ordinal();
    }

    public static RideType forValue(int value)
    {
        return values()[value];
    }
}
