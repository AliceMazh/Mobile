package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestInsertForm extends AppCompatActivity {//форма для вставки вопроса

    private String qquest;
    private String qansw;

    public String getQquest() {
        return qquest;
    }

    public void setQquest(String qquest) {
        this.qquest = qquest;
    }

    public String getQansw() {
        return qansw;
    }

    public void setQansw(String qansw) {
        this.qansw = qansw;
    }

    QuestInsertRequest as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//отрисовка экрана
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }

    public void add_quest(View view)//добавление нового вопроса
    {
        EditText etq=(EditText)findViewById(R.id.qname);
        EditText eta=(EditText)findViewById(R.id.aname);
        if((etq.getText()!=null)&&(eta.getText()!=null))
        {
            qquest= etq.getText().toString();
            qansw=eta.getText().toString().toLowerCase().trim();
            as=new QuestInsertRequest();
            as.execute(this);

        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Tedit is Empty!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void finisher(List<Question> list)
    {
        Intent intent = new Intent(this, QuestForm.class);
        intent.putExtra("qlist", (ArrayList)list);
        startActivity(intent);
        finish();
    }
}
