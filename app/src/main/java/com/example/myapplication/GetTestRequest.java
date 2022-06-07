package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Test;

import java.util.List;

public class GetTestRequest extends AsyncTask<SplahScreen,Void, Void>
{
    @Override
    protected Void doInBackground(SplahScreen... splasches) {
        //Keys[] k =JsonLoader.getData();
        SplahScreen m=splasches[0];
        //m.CallMainAndDie(k.clone());
        SplahScreen.db=AppDatabase.getDatabace(m);
        List<Test> l= SplahScreen.db.getTestDao().getAllTest();
        if(l!=null)
            m.CallMainAndDie(l);
        else
            m.deb.add(1);
        return null;
    }

    @Override
    protected void onPostExecute(Void v)
    {

    }
}
