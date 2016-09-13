package com.example.amaresh.newoffers.models;

/**
 * Created by Amaresh on 8/28/2016.
 */
public class ViewResponse {

    private Offer[] Offers;

    public Offer[] getOffers ()
    {
        return Offers;
    }

    public void setOffers (Offer[] offers)
    {
        this.Offers = offers;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Untitled_Form = "+Offers.toString()+"]";
    }
}
