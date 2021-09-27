package com.biz.invoice;

import com.biz.invoice.model.InvoiceSummary;
import com.biz.invoice.model.Ride;
import com.biz.invoice.service.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    @Test
    public final void GivenDistanceAndTimeShouldReturnTotalFare()
    {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.CalculateFare(distance, time);
        Assert.assertEquals(25.0,fare,0.0);
    }
    @Test
    public final void GivenMultipleRidesShouldReturnInvoiceSummary()
    {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides =
                {
                        new Ride(2.0, 5),
                        new Ride(0.1, 1)
                };

        InvoiceSummary invoiceSummary = invoiceGenerator.CalculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(invoiceSummary,expectedSummary);
    }
    @Test
    public final void GivenMultipleRidesShouldReturnInvoiceSummaryWithAverageFare()
    {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides =
                {
                        new Ride(2.0, 5),
                        new Ride(0.1, 1)
                };
        InvoiceSummary invoiceSummary = invoiceGenerator.CalculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(invoiceSummary,expectedSummary);
    }
    @Test
    public final void GivenRidesForDifferentUsersShouldReturnInvoiceSummary()
    {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides =
                {
                        new Ride(2.0, 5),
                        new Ride(0.1, 1)
                };
        String userId = "001";
        invoiceGenerator.AddRides(userId, rides);
        String userIdForSecondUser = "002";
        Ride[] ridesForSecondUser =
                {
                        new Ride(3.0, 10),
                        new Ride(1.0, 2)
                };
        invoiceGenerator.AddRides(userIdForSecondUser, ridesForSecondUser);
        InvoiceSummary invoiceSummary = invoiceGenerator.GetInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(invoiceSummary,expectedSummary);
    }
}
