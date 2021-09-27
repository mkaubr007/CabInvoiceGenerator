package com.biz.invoice.model;

public class InvoiceSummary
{
    private int numberOfRides;
    private double totalFare;
    private double averageFare;


    public InvoiceSummary(int numberOfRides, double totalFare)
    {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = totalFare / numberOfRides;
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof InvoiceSummary))
        {
            return false;
        }
        InvoiceSummary imputedObject = (InvoiceSummary)obj;
        return this.numberOfRides == imputedObject.numberOfRides && this.totalFare == imputedObject.totalFare && this.averageFare == imputedObject.averageFare;
    }
}


