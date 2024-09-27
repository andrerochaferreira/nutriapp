package com.example.nutri_app;

public class Student {
    private int id;
    private String name;
    private String rm;
    private String meal_choice;
    private String created_at;
    private String updated_at;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRm() { return rm; }
    public void setRm(String rm) { this.rm = rm; }

    public String getMeal_choice() { return meal_choice; }
    public void setMeal_choice(String meal_choice) { this.meal_choice = meal_choice; }

    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }
}