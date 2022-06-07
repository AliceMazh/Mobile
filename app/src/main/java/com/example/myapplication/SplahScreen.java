package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.model.Test;

import java.util.ArrayList;
import java.util.List;

/*
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.*;
*/


public class SplahScreen extends AppCompatActivity {

    private GetTestRequest as;
    static AppDatabase db;
    List<Integer> deb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Создание преподавателя
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
      Ast a=new Ast();
      a.execute(this);
    */
        as =new GetTestRequest();
        as.execute(this);
    }

    public void CallMainAndDie(List<Test> l)//
    {
            Intent intent = new Intent(this, TestList.class);
            intent.putExtra("list", (ArrayList) l);
            startActivity(intent);
            finish();
    }
    @Override
    public void onBackPressed() {
        as.cancel(true);
        super.onBackPressed();
    }
}
