package com.example.duynguyen.new_app.doi_tuong;

public class doi_tuong_sale_foods {
    private double id;
    private String name;
    private String image;
    private String title;
    private double price;
    private double evaluate;

    public doi_tuong_sale_foods(double id, String name, String image, String title, double price, double evaluate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.title = title;
        this.price = price;
        this.evaluate = evaluate;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(double evaluate) {
        this.evaluate = evaluate;
    }
}
