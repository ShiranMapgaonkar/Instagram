package com.example.instagram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("rAdHPkTh8OJQovYmymDFmJ1B36rYDO9KIaSOsCQa")
                .clientKey("zsjHKHvdIJZlN77IMoMC6Cjr5Z2qNzbnMavO3qbD")
                .server("https://parseapi.back4app.com/")
                .build()
        );

        }

    }