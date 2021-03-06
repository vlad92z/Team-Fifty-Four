package com.vlad.barclaysmobile.classes;

import java.lang.String;
import java.util.ArrayList;

/**
 * This will containt all of the details, like tasks, pictures, how many people have visited it
 * We might want to reconsider what exactly goes in to this class, because if we have a link
 * to FourSquare, most of the info might already be contained there
 */
public class Landmark {
    public String name;
    public String description;
    public String type_of_venue;
    public float latitude;
    public float longitude;
    public String city;
    public ArrayList<String> tasks;
    public ArrayList<String> associatedAchievements;
    public ArrayList<Question> questions;
    public int visitor_count;
    public int background;
    public int icon;
    public String url;

    public Landmark(String url, int background, ArrayList<String> achievements, int icon, String name, String description, String type_of_venue, float latitude,
                    float longitude, String city, ArrayList<String> tasks,
                    ArrayList<Question> questions, int visitor_count) {
        this.url = url;
        this.background = background;
        this.associatedAchievements = achievements;
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.type_of_venue = type_of_venue;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.tasks = tasks;
        this.questions = questions;
        this.visitor_count = visitor_count;
    }

    public int getBackground() {
        return background;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public ArrayList<String> getAssociatedAchievements() {
        return associatedAchievements;
    }

    public void setAssociatedAchievements(ArrayList<String> associatedAchievements) {
        this.associatedAchievements = associatedAchievements;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_of_venue() {
        return type_of_venue;
    }

    public void setType_of_venue(String type_of_venue) {
        this.type_of_venue = type_of_venue;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getVisitor_count() {
        return visitor_count;
    }

    public void setVisitor_count(int visitor_count) {
        this.visitor_count = visitor_count;
    }
}
