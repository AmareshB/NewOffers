package com.example.amaresh.newoffers;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Amaresh on 6/18/2017.
 */
public class DateDifference {
    public String dateDiff (String timeStamp) {
        //String timeStamp = "28-May-2016 12:15:35";33429254081
        String difference = "";
        try {//28-May-2016 12:15:35
            //SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss_yyyy.MM.dd");
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            Date date1 = new Date();
            Date date2 = df.parse(timeStamp);
            long diff = date1.getTime() - date2.getTime();
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            System.out.println(days);
            System.out.println(hours);
            System.out.println(minutes);
            System.out.println(seconds);
            if(days > 0){
                difference += days + " days";
                System.out.println(days);
            } else if(hours > 0 ) {
                difference += hours + " hours";
                System.out.println(hours);
            } else if(minutes > 0){
                difference += minutes + " minutes";
                System.out.println(minutes);
            } else if(seconds > 0 ) {
                difference += seconds + " sec";
                System.out.println(seconds);
            }
            difference += " ago";
            System.out.println(difference);
            Log.e("TEST Date diff" , date1.getTime() + " - " + date2.getTime() + " - " + diff);
        } catch (ParseException e) {
            Log.e("Date difference", "Exception", e);
        }
        return difference;
    }
}
