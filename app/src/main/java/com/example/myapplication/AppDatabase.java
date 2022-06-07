package com.example.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;
import com.example.myapplication.model.User;
import com.example.myapplication.modelInterface.QuestionDao;
import com.example.myapplication.modelInterface.TestDao;
import com.example.myapplication.modelInterface.UserDao;

@Database(entities = {User.class, Test.class, Question.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    public abstract TestDao getTestDao();
    public abstract QuestionDao getQuestionDao();
    private static AppDatabase db;

    public static AppDatabase getDatabace(Context context)//создание бд
    {
        if(db==null)
        {
            db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "databace")
                    .build();
        }
        return db;
    }
}
