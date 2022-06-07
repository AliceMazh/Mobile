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

public class QuestEditForm extends AppCompatActivity {//форма редактирования вопроса

    private String qquest;
    private String qansw;
    private Question curr_q;
    QuestUpdateRequest as;

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

    public Question getCurr_q() {
        return curr_q;
    }

    public void setCurr_q(Question curr_q) {
        this.curr_q = curr_q;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {//инициировать все переменные для создания вопроса
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        curr_q=(Question) getIntent().getExtras().getSerializable("quest");
        EditText etq=(EditText)findViewById(R.id.qname);
        EditText eta=(EditText)findViewById(R.id.aname);
        etq.setText(curr_q.getQuest());
        eta.setText(curr_q.getAnswer());
    }

    public void add_questa(View view)//добавление вопроса
    {
        EditText etq=(EditText)findViewById(R.id.qname);
        EditText eta=(EditText)findViewById(R.id.aname);
        if((etq.getText()!=null)&&(eta.getText()!=null))
        {
            qquest= etq.getText().toString();
            qansw=eta.getText().toString().toLowerCase().trim();
            as=new QuestUpdateRequest();
            as.execute(this);
        }
        else {//проверка на пустоту
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Tedit is Empty!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void finisher(List<Question> list)//закончить
    {
        Intent intent = new Intent(this, QuestForm.class);
        intent.putExtra("qlist", (ArrayList)list);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
