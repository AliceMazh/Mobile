package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Test;

import java.util.List;

public class InsertTestRequest extends AsyncTask<InsertTestForm,Void, Void> {//запрос на добавления теста
    protected Void doInBackground(InsertTestForm... splasches) {

        //Keys[] k =JsonLoader.getData();
        InsertTestForm m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        Test test=new Test();
        test.setName(InsertTestForm.input_name);
        db.getTestDao().insertAll(test);
        List<Test> l= SplahScreen.db.getTestDao().getAllTest();
        m.finisher(l);
        return null;
    }
}
