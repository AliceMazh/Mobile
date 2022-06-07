package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;

import java.util.List;

public class QuestRequest extends AsyncTask<Model,Void,Void>//
{
    @Override
    protected Void doInBackground(Model... m) {

        //Keys[] k =JsonLoader.getData();
        Model model=m[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase databace=AppDatabase.getDatabace(model.context);
        List<Question> l=databace.getQuestionDao().getQuestionByTest(model.current_position);
        if(l!=null)
            model.Load_test(l);
        return null;
    }
}
