package com.example.duynguyen.new_app.doi_tuong;

public class doi_tuong_book_foods {
    private String id_book;
    private String id;
    private String locad;
    private String image;
    private String date;

    public doi_tuong_book_foods(String id_book, String id, String date) {
        this.id_book = id_book;
        this.id = id;
        this.date = date;
    }

    public String getId_book() {
        return id_book;
    }

    public void setId_book(String id_book) {
        this.id_book = id_book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
