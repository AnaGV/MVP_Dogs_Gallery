package com.dogapi.something;

import android.app.Application;
import android.content.Context;

/**
 * Created by ana on 20-10-17.
 */

public class DogApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static DogApp getContext(Context context){
        return (DogApp) context.getApplicationContext();
    }
}
