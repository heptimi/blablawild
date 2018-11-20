package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);
        Intent intent = getIntent();
        String stDeparture = intent.getStringExtra(ItinerarySearchActivity.EXTRA_MESSAGE_DEPARTURE);
        String stDestination = intent.getStringExtra(ItinerarySearchActivity.EXTRA_MESSAGE_DESTINATION);
        String title = stDeparture + " >> " + stDestination;

        this.setTitle(title);

    }


}
