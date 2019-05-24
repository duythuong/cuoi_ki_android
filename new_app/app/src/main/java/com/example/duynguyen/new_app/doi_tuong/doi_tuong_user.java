package com.example.duynguyen.new_app.doi_tuong;

public class doi_tuong_user {
    private String id_use;
    private String name;
    private String email;
    private String image;

    public doi_tuong_user(String id_use, String name, String email, String image) {
        this.id_use = id_use;
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public String getId_use() {
        return id_use;
    }

    public void setId_use(String id_use) {
        this.id_use = id_use;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
