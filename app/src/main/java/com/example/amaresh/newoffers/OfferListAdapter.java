package com.example.amaresh.newoffers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amaresh.newoffers.models.Offer;

import java.util.ArrayList;

/**
 * Created by Amaresh on 5/6/2017.
 */
public class OfferListAdapter extends RecyclerView.Adapter<OfferItemHolder> {

    private ArrayList<Offer> offers;
    private Context mContext;

    public OfferListAdapter(ArrayList<Offer> offers, Context mContext) {
        this.offers = offers;
        this.mContext = mContext;
    }

    @Override
    public OfferItemHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item, null);

        OfferItemHolder offerItemHolder = new OfferItemHolder(view);

        return offerItemHolder;
    }

    @Override
    public void onBindViewHolder(OfferItemHolder holder, int position) {
        Offer offer = offers.get(position);

        //Picasso.with(mContext).load(offer.getOffer_Image()).error(R.mipmap.fk).placeholder(R.mipmap.fk).into(holder.thumbnailImage);

        holder.titleText.setText(offer.getOffer_Title());
        holder.description.setText(offer.getOffer_Description());
        holder.description2.setText(offer.getOffer_Data_Time());
//        holder.titleText.setText(offer.getOffer_Data_Time());
//        holder.titleText.setText(offer.getOffer_Status());

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public void reloadOffers(ArrayList<Offer> newOffers){
        offers.clear();
        offers.addAll(newOffers);
    }
}
