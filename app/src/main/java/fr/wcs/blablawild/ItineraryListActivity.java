package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItineraryListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent intent = getIntent();

        SearchModel searchModel = intent.getExtras().getParcelable("searchModel");
        String stDeparture = searchModel.getDeparture();
        String stDestination = searchModel.getDestination();
        String stDate = searchModel.getDate();
        //String stDeparture = intent.getStringExtra(ItinerarySearchActivity.EXTRA_MESSAGE_DEPARTURE);
       // String stDestination = intent.getStringExtra(ItinerarySearchActivity.EXTRA_MESSAGE_DESTINATION);
        String title = stDeparture + " >> " + stDestination;
        Toast.makeText(this, stDate, Toast.LENGTH_SHORT).show();
        this.setTitle(title);


//        ListView listTrip = findViewById(R.id.list_trip);
//        ArrayList<TripModel> results = new ArrayList<>();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
//
//        try {
//            results.add(new TripModel("Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
//            results.add(new TripModel("Stan", "Marsh", sdf.parse("21/02/2017-16:00"), 20));
//            results.add(new TripModel("Kenny", "Broflovski", sdf.parse("21/02/2017-16:30"), 16));
//            results.add(new TripModel("Kyle", "McCormick", sdf.parse("21/02/2017-17:00"), 40));
//            results.add(new TripModel("Wendy", "Testaburger", sdf.parse("21/02/2017-17:30"), 20));
//        } catch (ParseException e) {
//        }
//
//        TripAdapter adapter = new TripAdapter(this, results);
//        listTrip.setAdapter(adapter);
        RecyclerView listItineraries = findViewById(R.id.list_itineraries);
// TODO : préciser le type de layout de la liste
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listItineraries.setLayoutManager(layoutManager);

        final ArrayList<ItineraryModel> itineraryModels = new ArrayList<>();
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Eric Cartman", new Date(), 15));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Stan Marsh", new Date(), 20));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kenny Broflovski", new Date(), 12));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kyle McCormick", new Date(), 18));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Wendy Testaburger", new Date(), 16));

// TODO : afficher la liste d'itinéraires avec un adapter

        final ItineraryRecyclerAdapter adapter = new ItineraryRecyclerAdapter(itineraryModels);
        listItineraries.setAdapter(adapter);
        listItineraries.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), listItineraries, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ItineraryModel itinerary = itineraryModels.get(position);
                Toast.makeText(getApplicationContext(), itinerary.getDriver() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }


}
