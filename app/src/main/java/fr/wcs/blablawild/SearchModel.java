package fr.wcs.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchModel implements Parcelable {

    String departure;
    String destination;
    String date;

    public SearchModel(String departure, String destination, String date){
        this.departure = departure;
        this.destination = destination;
        this.date= date;
    }

    protected SearchModel(Parcel in) {
        departure = in.readString();
        destination = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departure);
        dest.writeString(destination);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SearchModel> CREATOR = new Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel in) {
            return new SearchModel(in);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };

    public String getDate() {
        return date;
    }

    public String getDeparture(){
        return  departure;
    }

    public String getDestination() {
        return destination;
    }

}
