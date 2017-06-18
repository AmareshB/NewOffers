package com.example.amaresh.newoffers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Amaresh on 5/6/2017.
 */
public class OfferItemHolder extends RecyclerView.ViewHolder {

    protected ImageView thumbnailImage;
    protected TextView titleText;
    protected TextView description;
    protected TextView offertime;

    public OfferItemHolder(View itemView) {
        super(itemView);

        thumbnailImage = (ImageView) itemView.findViewById(R.id.thumbnail);
        titleText = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        offertime = (TextView) itemView.findViewById(R.id.offertime);

    }
}
