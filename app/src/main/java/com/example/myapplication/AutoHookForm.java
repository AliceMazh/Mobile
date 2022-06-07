package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.model.Test;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class AutoHookForm extends AppCompatActivity {//форма входа для преподавателя

    private String login;
    private String password;
    AutoHookRequest as;//создание элемента класса
    ArrayList<Test> listl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        listl= (ArrayList<Test>) getIntent().getExtras().getSerializable("list");
    }


    public void login(View view)
    {
        EditText etlog=(EditText)findViewById(R.id.login);
        EditText etpass=(EditText)findViewById(R.id.pass);
        login=etlog.getText().toString();
        password=etpass.getText().toString();
        as=new AutoHookRequest();
        as.execute(this);
    }

    public void finisher(List<User> list)
    {
        if(list.size()!=0) {
            Model.user = list.get(0);
            Intent intent=new Intent(this, TestList.class);
            intent.putExtra("list",(ArrayList)listl);
            startActivity(intent);
        }
        else
            {
                Model.user=new User();
                Model.user.setPremission(0);
                Intent intent=new Intent(this, TestList.class);
                intent.putExtra("list",(ArrayList)listl);
                startActivity(intent);

            }
        finish();
    }
}
