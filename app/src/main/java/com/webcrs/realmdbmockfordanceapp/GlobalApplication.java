package com.webcrs.realmdbmockfordanceapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by test on 08/02/18.
 */

public class GlobalApplication extends Application {

    static final String realmFileName = "DanceApp";

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().name(realmFileName).build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }

}
