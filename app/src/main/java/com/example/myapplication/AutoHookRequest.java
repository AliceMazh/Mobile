package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.User;

import java.util.List;

public class AutoHookRequest extends AsyncTask<AutoHookForm,Void, Void> {

    protected Void doInBackground(AutoHookForm... splasches) {
        //Keys[] k =JsonLoader.getData();
        AutoHookForm m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        List<User> l= SplahScreen.db.getUserDao().getUserByLoginAndPassword(m.getLogin(),m.getPassword());
        m.finisher(l);
        return null;
    }
}
