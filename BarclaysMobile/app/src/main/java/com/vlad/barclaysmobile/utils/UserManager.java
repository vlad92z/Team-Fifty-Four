package com.vlad.barclaysmobile.utils;

/**
 * Created by Vladislavs on 22/11/2014.
 * This is a singleton that contains user data
 */

import com.vlad.barclaysmobile.classes.User;

/**
 * This is the user class, which will contain all of their achievements photos, etc
 * I think this will be useful to view other people in the app
 * If it is to be used to hold data on the actual user of the application,
 * might be a good idea to make it a singleton UserManager class to ensure there is just one instance of it
 *
 * I haven't (poorly attempted) to construct this one since you might want to do the singleton thing - Ally
 *
 * Should contain:
 *  - first_name
 *  - last_name
 *  - email
 *  - profile_picture
 *  - foursquare_id (for linking them to a Foursquare user acc/id?)
 *  - uncompleted_adventures
 *  - completed_adventures
 *  - completed_tasks
 *  - achievements (gained)
 *  - score
 *  - cities_visited
 *  - landmarks_visited
 */
public class UserManager {

    private static UserManager instance;

    private User user;
    private String uId;

    protected UserManager() {

    }

    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
