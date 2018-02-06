package models;

public class Movie {
    private String theaterName, theaterId;

    public Movie(String theaterName, String theaterId) {
        this.theaterName = theaterName;
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }


}