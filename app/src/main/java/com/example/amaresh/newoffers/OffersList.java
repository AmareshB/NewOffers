package com.example.amaresh.newoffers;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amaresh on 7/14/2016.
 */
public class OffersList extends ListFragment implements OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public  static final String URL_JSON = "https://creator.zoho.com/api/json/offer-pickup/view/Untitled_Form_View?authtoken=fe7d268a333df01f180f0c4dd0c5aa92&scope=creatorapi&zc_ownername=629325995&raw=true";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // recylcerview
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    public TextView sectionLabelTextView;

    //SwipeRefreshLayout
    private SwipeRefreshLayout mswipeRefreshLayout;



    public OffersList(){
        //Empty Constructor
    }

    public static OffersList newInstance(String param1, String param2) {
        OffersList offersList = new OffersList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        offersList.setArguments(args);
        return offersList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offerslist, container, false);
        //MOvies RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.offersListView);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();

        //SwipeREfreshLayout
        view = swipeToRefresh(view);

        //sectionlabel textview
        sectionLabelTextView = (TextView) view.findViewById(R.id.section_label);

        //Download Data starts
        sendRequest();
        //Download Data Ends

        //Click event for recycler view items
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String[] menuArray = getResources().getStringArray(R.array.SampleOffers);
                Toast.makeText(getActivity(), "Clicked Item : " + movieList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Log.i("new click listener", String.valueOf(movieList.get(position).getTitle()));
            }
        }));

        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.SampleOffers, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        */
        //Movies Recyclerview

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] menuArray = getResources().getStringArray(R.array.SampleOffers);
        Toast.makeText(getActivity(), "Item: " + menuArray[position], Toast.LENGTH_SHORT).show();
    }


    public View swipeToRefresh(View view){
        mswipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });

        return view;
    }

    void refreshItems() {
        // Load items
        mAdapter = new MoviesAdapter(movieList);

        // Load complete
        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        mAdapter.notifyDataSetChanged();

        // Stop refresh animation
        mswipeRefreshLayout.setRefreshing(false);
    }


    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure121", "005");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2017");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awak", "Action", "208");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

//Download Data

    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(URL_JSON,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // showJSON(response);
                        Log.i("DownloadData",response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);

    }




}