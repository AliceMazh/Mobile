package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestForm extends AppCompatActivity {//форма задания для препода

    List<Question> quest;
    private Question q;
    QuestDeleteRequest as;
    ViewPager pager;

    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {//лист вопросов поместили в экран
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        quest= (ArrayList<Question>) getIntent().getExtras().getSerializable("qlist");
        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new Addapter(getSupportFragmentManager(),quest));
    }

    public void OnAnsBCclick(View view)//проверка результата
    {
       // PageFragment f=(PageFragment)getSupportFragmentManager().findFragmentById(R.id.pager);

        int x=pager.getCurrentItem();
        View pgv= pager.getFocusedChild();
        EditText text=(EditText)pgv.findViewById(R.id.Teditble);
        Editable ted=text.getText();
        if(ted!=null)
        {
            String s=ted.toString().toLowerCase();
            String s1=quest.get(pager.getCurrentItem()).getAnswer();
            if (s1.equals(s))
                this.goodAnsw();
            else
                this.badAnsw();
        }
    }
    @Override
    public void onBackPressed() {//нажатие кнопки назад
       finish();
       super.onBackPressed();
    }

    public void DelQuest(View view)//удаление вопроса
    {
        this.q=quest.get(pager.getCurrentItem());
        as=new QuestDeleteRequest();
        as.execute(this);
    }

    public void RedQ(View view)//
    {
        Intent intent=new Intent(this, QuestEditForm.class);
        intent.putExtra("quest",quest.get(pager.getCurrentItem()));
        startActivity(intent);
        finish();
    }

    public void getTrueAnsw(View view)//показ результата
    {
        int x=pager.getCurrentItem();

        AlertDialog.Builder builder = new AlertDialog.Builder(QuestForm.this);
        builder.setTitle("Результат")
                .setMessage(quest.get(x).getAnswer())
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void goodAnsw()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuestForm.this);
        builder.setTitle("Результат")
                .setMessage("Верно")
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void finisher(List<Question> list)
    {
        if(list.size()!=0) {
            Intent intent = new Intent(this, QuestForm.class);
            intent.putExtra("qlist", (ArrayList) list);
            startActivity(intent);
            finish();
        }
        else
            {
                Intent intent = new Intent(this, QuestInsertOnEmptyTestForm.class);
                startActivity(intent);
                finish();
            }
    }

    public void badAnsw()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuestForm.this);
        builder.setTitle("Результат")
                .setMessage("Не Верно")
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void OnAddBCclick(View view)//при нажатие на кнопку добавить добавляет вопрос
    {
        Intent intent = new Intent(this, QuestInsertForm.class);
        startActivity(intent);
        finish();
    }
}
