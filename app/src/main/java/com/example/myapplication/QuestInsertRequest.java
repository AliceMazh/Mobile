package com.example.myapplication;

import android.os.AsyncTask;

import com.example.myapplication.model.Question;

import java.util.List;

public class QuestInsertRequest extends AsyncTask<QuestInsertForm,Void, Void> {//запрос на добавление вопроса

    protected Void doInBackground(QuestInsertForm... splasches) {

        //Keys[] k =JsonLoader.getData();
        QuestInsertForm m = splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db = AppDatabase.getDatabace(m);
        Question question=new Question();
        question.setQuest(m.getQquest());
        question.setAnswer(m.getQansw());
        question.setTestId(Model.current_position);
        db.getQuestionDao().insertAll(question);
        List<Question> l= SplahScreen.db.getQuestionDao().getQuestionByTest(Model.current_position);
        m.finisher(l);
        return null;
    }
}
