package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.User;

public class Ast extends AsyncTask<SplahScreen,Void,Void> {

    @Override
    protected Void doInBackground(SplahScreen... splasches) {
        //Keys[] k =JsonLoader.getData();
        SplahScreen m = splasches[0];
        AppDatabase db=AppDatabase.getDatabace(m);
        User user=new User();
        user.setLogin("Login");
        user.setPassword("123456");
        user.setName("Vasya");
        user.setPremission(5);
        db.getUserDao().insertALL(user);
        return null;
    }
}
