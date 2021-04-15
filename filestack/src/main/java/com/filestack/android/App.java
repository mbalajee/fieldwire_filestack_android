package com.filestack.android;

import android.app.Application;
import com.squareup.picasso.Picasso;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // adding this here to prevent Picasso crash in Viewholder
        Picasso.setSingletonInstance(new Picasso.Builder(this).build());
    }
}
