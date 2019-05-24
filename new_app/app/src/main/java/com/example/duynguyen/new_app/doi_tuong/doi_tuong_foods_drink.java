package com.example.duynguyen.new_app.doi_tuong;

public class doi_tuong_foods_drink{
    private String id;
    private String name;
    private String image;
    private String title;
    private double price;
    private double evaluate;

    public doi_tuong_foods_drink(){

    }

    public doi_tuong_foods_drink(String id, String name, String image, String title, double price, double evaluate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.title = title;
        this.price = price;
        this.evaluate = evaluate;
    }

    public doi_tuong_foods_drink(String title, String name){
        this.title = title;
        this.name = name;
    }
    public doi_tuong_foods_drink(String id, String image, String title, double price, String name) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(double evaluate) {
        this.evaluate = evaluate;
    }
}
