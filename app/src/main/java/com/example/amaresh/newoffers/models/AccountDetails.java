package com.example.amaresh.newoffers.models;

/**
 * Created by Amaresh on 8/28/2016.
 */
public class AccountDetails {

    private String applicationLinkName;

    private String authtoken;

    private String zc_ownername;

    private String viewLinkName;

    public String getApplicationLinkName ()
    {
        return applicationLinkName;
    }

    public void setApplicationLinkName (String applicationLinkName)
    {
        this.applicationLinkName = applicationLinkName;
    }

    public String getAuthtoken ()
    {
        return authtoken;
    }

    public void setAuthtoken (String authtoken)
    {
        this.authtoken = authtoken;
    }

    public String getZc_ownername ()
    {
        return zc_ownername;
    }

    public void setZc_ownername (String zc_ownername)
    {
        this.zc_ownername = zc_ownername;
    }

    public String getViewLinkName ()
    {
        return viewLinkName;
    }

    public void setViewLinkName (String viewLinkName)
    {
        this.viewLinkName = viewLinkName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [applicationLinkName = "+applicationLinkName+", authtoken = "+authtoken+", zc_ownername = "+zc_ownername+", viewLinkName = "+viewLinkName+"]";
    }
}
