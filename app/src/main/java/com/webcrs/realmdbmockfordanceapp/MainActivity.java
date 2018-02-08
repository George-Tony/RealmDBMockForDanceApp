package com.webcrs.realmdbmockfordanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button save;
    TextView display;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        save = findViewById(R.id.save);
        display = findViewById(R.id.display);
        save.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == save){
            writeToDb();
            showData();
        }

    }

    public void showData(){
        RealmResults<RealmVideoModel> realmVideoModels = realm.where(RealmVideoModel.class).
                equalTo("data_id",1).findAll();
        realm.beginTransaction();
        for(RealmVideoModel realmVideoModel : realmVideoModels){
            display.setText(realmVideoModel.getData());
        }


    }

    public void writeToDb(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                RealmVideoModel realmVideoModel = realm.createObject(RealmVideoModel.class);
                realmVideoModel.setData("this is how I'm !!");
                realmVideoModel.setData_id(1);

            }

        }, new Realm.Transaction.OnSuccess(){

            @Override
            public void onSuccess() {
                // transaction was success

                Log.e("Database", "data inserted successfully");

            }
        }, new Realm.Transaction.OnError(){
            @Override
            public void onError(Throwable error) {
                // transaction stopped with an error
                Log.e("Database error", error.getLocalizedMessage());

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
