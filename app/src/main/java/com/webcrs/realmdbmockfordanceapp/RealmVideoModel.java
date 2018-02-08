package com.webcrs.realmdbmockfordanceapp;

import io.realm.RealmObject;

/**
 * Created by test on 08/02/18.
 */

public class RealmVideoModel extends RealmObject {

   public String  data;
   public int data_id;

    public int getData_id() {
        return data_id;
    }

    public void setData_id(int data_id) {
        this.data_id = data_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
