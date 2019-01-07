package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_DEPARTURE = "fr.wcs.blablawild.MESSAGE";
    public static final String EXTRA_MESSAGE_DESTINATION = "fr.wcs.blablawild.MESSAGE2";
   // public static final String EXTRA_PARCEL = "parcel";
    String sdfString;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final Calendar myCalendar = Calendar.getInstance();
        final EditText edittext= (EditText) findViewById(R.id.etDate);


       final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(edittext, myCalendar);
                //Si on appelle les methodes en dehors de la on create ca crashe. Donc ici on les appelle en interne
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



    }


         private void updateLabel(EditText edittext, Calendar myCalendar) {

         String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            sdfString = sdf.format(myCalendar.getTime());
            edittext.setText(sdfString);
     }



        public void buttonSearch(View view) {

        SearchModel searchModel;

            //final Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
            final EditText etDeparture = (EditText) findViewById(R.id.etDeparture);
            // final String stDeparture = etDeparture.getText().toString();

            final EditText etDestination = (EditText) findViewById(R.id.etDestination);
            //final String stDestination = etDestination.getText().toString();

            final Toast buttonToast = Toast.makeText(getApplicationContext(), getString(R.string.Toasttext), Toast.LENGTH_SHORT);

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

                searchModel = new SearchModel(stDeparture1, stDestination1, sdfString);

                //intent.putExtra(EXTRA_MESSAGE_DEPARTURE, stDeparture1);
               // intent.putExtra(EXTRA_MESSAGE_DESTINATION, stDestination1);
                intent.putExtra("searchModel", searchModel);
                startActivity(intent);
                //return;
            }

        }




}
