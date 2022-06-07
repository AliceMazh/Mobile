package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestInsertOnEmptyTestForm extends AppCompatActivity {//дает добавить вопрос тесту

    @Override
    protected void onCreate(Bundle savedInstanceState) {//показ кнопка добавления вопроса у теста
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        if(Model.user!=null) {
            if (Model.user.getPremission() > 0) {
                Button btnk = (Button) findViewById(R.id.addbtn);
                btnk.setVisibility(View.VISIBLE);
            }
        }
    }

    public void add_str(View view)//
    {
        Intent intent = new Intent(this, QuestInsertForm.class);
        startActivity(intent);
        finish();
    }

}
