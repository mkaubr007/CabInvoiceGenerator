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
}
