package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_DEPARTURE = "fr.wcs.blablawild.MESSAGE";
    public static final String EXTRA_MESSAGE_DESTINATION = "fr.wcs.blablawild.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);



    }





        public void buttonSearch(View view) {

            //final Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
            final EditText etDeparture = (EditText) findViewById(R.id.etDeparture);
            // final String stDeparture = etDeparture.getText().toString();

            final EditText etDestination = (EditText) findViewById(R.id.etDestination);
            //final String stDestination = etDestination.getText().toString();

            final Toast buttonToast = Toast.makeText(getApplicationContext(), "Error, please fill your departure & your Destination", Toast.LENGTH_SHORT);

            String stDeparture = etDeparture.getText().toString();
            String stDestination = etDestination.getText().toString();
            Intent intent = new Intent(this, ItineraryListActivity.class);


            if (stDestination.matches("") || stDeparture.matches("") ) {

                buttonToast.show();
                //return;
            }
            else {
                String stDeparture1 = etDeparture.getText().toString();
                String stDestination1 = etDestination.getText().toString();

                intent.putExtra(EXTRA_MESSAGE_DEPARTURE, stDeparture1);
                intent.putExtra(EXTRA_MESSAGE_DESTINATION, stDestination1);

                startActivity(intent);
                //return;
            }

        }



}
