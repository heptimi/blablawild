package fr.wcs.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.item_trip, parent, false);
        }
        // get current item to be displayed

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        // Lookup view for data population
        TextView twFNitem_trip = (TextView) convertView.findViewById(R.id.twFNitem_trip);
        TextView twLNitem_trip = (TextView) convertView.findViewById(R.id.twLNitem_trip);
        TextView twPrice_trip= (TextView) convertView.findViewById(R.id.twPrice);
        TextView twDate_trip= (TextView) convertView.findViewById(R.id.twDateHeure);


        // Populate the data into the template view using the data object
        twFNitem_trip.setText(trip.getFirstName());
        twLNitem_trip.setText(trip.getLastName());
        twPrice_trip.setText(String.valueOf(trip.getPrice())); // IMPORTANT A RELIRE
        twDate_trip.setText(sdf.format(trip.getDate())); // IMPORTANT AUSSI


        // A voir est ce mieux de corriger le format ici ou directement dans le GET

        // Return the completed view to render on screen
        return convertView;
    }
}
