package com.biz.invoice.model;

import com.biz.invoice.exception.CabInvoiceException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RideRepository
{
    private HashMap<String, ArrayList<Ride>> userRides = null;

    public RideRepository()
    {
        this.userRides = new HashMap<String, ArrayList<Ride>>();
    }


    public final void AddRide(String userId, Ride[] rides)
    {
        boolean rideList = this.userRides.containsKey(userId);
        try
        {
            if (!rideList)
            {
                ArrayList<Ride> list = new ArrayList<Ride>();
                list.addAll(Arrays.asList(rides));
                this.userRides.put(userId, list);
            }
        }
        catch (java.lang.Exception e)
        {
            throw new CabInvoiceException(CabInvoiceException.ExceptionType.NULL_RIDES, "Rides are null");
        }
    }


    public final Ride[] GetRides(String userId)
    {
        try
        {
            return this.userRides.get(userId).toArray(new Ride[0]);
        }
        catch (CabInvoiceException e)
        {
            throw new CabInvoiceException(CabInvoiceException.ExceptionType.INVALID_USER_ID, "Invalid User id");
        }
    }
}


