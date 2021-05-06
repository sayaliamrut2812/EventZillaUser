package com.example.eventzillauser;

public class product {
    private int id;
    private String title;
    private String time;
    private String date;
    private String venue;
    private int image;

    public product(int id, String title, String time, String date, String venue, int image) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.date = date;
        this.venue = venue;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public int getImage() {
        return image;
    }
}

