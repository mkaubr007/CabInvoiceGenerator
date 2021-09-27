package com.biz.invoice;

import com.biz.invoice.service.service.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    @Test
    public final void GivenDistanceAndTimeShouldReturnTotalFare()
    {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        //calculating fare
        double fare = invoiceGenerator.CalculateFare(distance, time);
        Assert.assertEquals(25.0,fare,0.0);
    }
}
