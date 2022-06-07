package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Question;

import java.util.List;

public class QuestUpdateRequest extends AsyncTask<QuestEditForm,Void, Void> {//обновление вопроса в бд

    protected Void doInBackground(QuestEditForm... splasches) {

        //Keys[] k =JsonLoader.getData();
        QuestEditForm m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        Question q=m.getCurr_q();
        q.setQuest(m.getQquest());
        q.setAnswer(m.getQansw());
        db.getQuestionDao().Update(q);
        List<Question> l= SplahScreen.db.getQuestionDao().getQuestionByTest(Model.current_position);
        m.finisher(l);

        return null;


    }
}
