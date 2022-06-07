package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Question;

import java.util.List;

public class QuestDeleteRequest extends AsyncTask<QuestForm,Void, Void> {//удаление вопроса

    protected Void doInBackground(QuestForm... splasches) {

        //Keys[] k =JsonLoader.getData();
        QuestForm m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        db.getQuestionDao().Delete(m.getQ());
        List<Question> l= SplahScreen.db.getQuestionDao().getQuestionByTest(Model.current_position);
        m.finisher(l);
        return null;
    }
}