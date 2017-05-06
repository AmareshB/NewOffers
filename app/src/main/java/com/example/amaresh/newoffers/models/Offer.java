package com.example.amaresh.newoffers.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Amaresh on 8/28/2016.
 */
public class Offer implements Parcelable{

    private String Offer_Data_Time;

    private String Offer_Image;

    private String Offer_Steps;

    private String Offer_Description;

    private String Offer_Video_Link;

    private String Offer_Title;

    private String Offer_Status;

    private String ID;

    private String Offer_Likes;

    private String Offer_Official_Link;

    private String Offer_Link;

    private String Offer_Tags;

    public Offer(){
        //Do Nothing
    }

    protected Offer(Parcel in) {
        Offer_Data_Time = in.readString();
        Offer_Image = in.readString();
        Offer_Steps = in.readString();
        Offer_Description = in.readString();
        Offer_Video_Link = in.readString();
        Offer_Title = in.readString();
        Offer_Status = in.readString();
        ID = in.readString();
        Offer_Likes = in.readString();
        Offer_Official_Link = in.readString();
        Offer_Link = in.readString();
        Offer_Tags = in.readString();
    }

    public static final Creator<Offer> CREATOR = new Creator<Offer>() {
        @Override
        public Offer createFromParcel(Parcel in) {
            return new Offer(in);
        }

        @Override
        public Offer[] newArray(int size) {
            return new Offer[size];
        }
    };

    @JsonProperty("Offer_Data_Time")
    public String getOffer_Data_Time ()
    {
        return Offer_Data_Time;
    }

    public void setOffer_Data_Time (String Offer_Data_Time)
    {
        this.Offer_Data_Time = Offer_Data_Time;
    }

    @JsonProperty("Offer_Image")
    public String getOffer_Image ()
    {
        return Offer_Image;
    }

    public void setOffer_Image (String Offer_Image)
    {
        this.Offer_Image = Offer_Image;
    }

    @JsonProperty("Offer_Steps")
    public String getOffer_Steps ()
    {
        return Offer_Steps;
    }

    public void setOffer_Steps (String Offer_Steps)
    {
        this.Offer_Steps = Offer_Steps;
    }

    @JsonProperty("Offer_Description")
    public String getOffer_Description ()
    {
        return Offer_Description;
    }

    public void setOffer_Description (String Offer_Description)
    {
        this.Offer_Description = Offer_Description;
    }

    @JsonProperty("Offer_Video_Link")
    public String getOffer_Video_Link ()
    {
        return Offer_Video_Link;
    }

    public void setOffer_Video_Link (String Offer_Video_Link)
    {
        this.Offer_Video_Link = Offer_Video_Link;
    }

    @JsonProperty("Offer_Title")
    public String getOffer_Title ()
    {
        return Offer_Title;
    }

    public void setOffer_Title (String Offer_Title)
    {
        this.Offer_Title = Offer_Title;
    }

    @JsonProperty("Offer_Status")
    public String getOffer_Status ()
    {
        return Offer_Status;
    }

    public void setOffer_Status (String Offer_Status)
    {
        this.Offer_Status = Offer_Status;
    }

    @JsonProperty("ID")
    public String getID ()
    {
        return ID;
    }

    public void setID (String ID)
    {
        this.ID = ID;
    }

    @JsonProperty("Offer_Likes")
    public String getOffer_Likes ()
    {
        return Offer_Likes;
    }

    public void setOffer_Likes (String Offer_Likes)
    {
        this.Offer_Likes = Offer_Likes;
    }

    @JsonProperty("Offer_Official_Link")
    public String getOffer_Official_Link ()
    {
        return Offer_Official_Link;
    }

    public void setOffer_Official_Link (String Offer_Official_Link)
    {
        this.Offer_Official_Link = Offer_Official_Link;
    }

    @JsonProperty("Offer_Link")
    public String getOffer_Link ()
    {
        return Offer_Link;
    }

    public void setOffer_Link (String Offer_Link)
    {
        this.Offer_Link = Offer_Link;
    }

    @JsonProperty("Offer_Tags")
    public String getOffer_Tags ()
    {
        return Offer_Tags;
    }

    public void setOffer_Tags (String Offer_Tags)
    {
        this.Offer_Tags = Offer_Tags;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Offer_Data_Time = "+Offer_Data_Time+", Offer_Image = "+Offer_Image+", Offer_Steps = "+Offer_Steps+", Offer_Description = "+Offer_Description+", Offer_Video_Link = "+Offer_Video_Link+", Offer_Title = "+Offer_Title+", Offer_Status = "+Offer_Status+", ID = "+ID+", Offer_Likes = "+Offer_Likes+", Offer_Official_Link = "+Offer_Official_Link+", Offer_Link = "+Offer_Link+", Offer_Tags = "+Offer_Tags+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Offer_Data_Time);
        dest.writeString(Offer_Image);
        dest.writeString(Offer_Steps);
        dest.writeString(Offer_Description);
        dest.writeString(Offer_Video_Link);
        dest.writeString(Offer_Title);
        dest.writeString(Offer_Status);
        dest.writeString(ID);
        dest.writeString(Offer_Likes);
        dest.writeString(Offer_Official_Link);
        dest.writeString(Offer_Link);
        dest.writeString(Offer_Tags);
    }
}
