package com.biz.invoice.service.service;

import com.biz.invoice.service.exception.CabInvoiceException;

public class InvoiceGenerator {

    private static  double MINIMUM_COST_PER_KM;
    private static  int COST_PER_TIME;
    private static double MINIMUM_FARE;

    public InvoiceGenerator() {
        this.MINIMUM_COST_PER_KM = 10;
        this.COST_PER_TIME = 1;
        this.MINIMUM_FARE = 5;
    }

    public final double CalculateFare(double distance, int time)
    {
        double totalFare = 0;
        try
        {
            totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        }
        catch (CabInvoiceException e)
        {
            if (distance <= 0)
            {
                throw new CabInvoiceException(CabInvoiceException.ExceptionType.INVALID_DISTANCE, "Invalid Distance");
            }
            if (time <= 0)
            {
                throw new CabInvoiceException(CabInvoiceException.ExceptionType.INVALID_TIME, "Invalid Time");
            }
        }
        return Math.max(totalFare, MINIMUM_FARE);
    }

}
