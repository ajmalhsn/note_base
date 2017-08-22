package com.example.ajmal.project1;

/**
 * Created by ajmal on 21-01-2017.
 */

import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class User {

    public String term;
    public String definition;
    public  String category;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String term, String definition,String category) {
        this.term = term;
        this.definition = definition;
        this.category = category;

    }

}