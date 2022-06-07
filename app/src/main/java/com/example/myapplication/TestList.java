package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.model.Test;

import java.util.ArrayList;


public class TestList extends AppCompatActivity {//лист тестов

    ListView listview;
    Model model;
    ArrayList<Test> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//инициализация кнопок
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lister);
        list= (ArrayList<Test>) getIntent().getExtras().getSerializable("list");
        //Log.e("info",list.get(0).getName());
        listview = (ListView) findViewById(R.id.listview);
        model =new Model(this,list);
        model.setTestList(this);
        if(Model.user!=null) {
            if (Model.user.getPremission() > 0) {
                Button btnk = (Button) findViewById(R.id.btOk);
                Button btnc = (Button) findViewById(R.id.btCancel);
                Button btnlog=(Button) findViewById(R.id.btlog) ;
                btnk.setVisibility(View.VISIBLE);
                btnlog.setVisibility(View.INVISIBLE);
            }
        }
        listview.setAdapter(model);
    }

    public void login(View view)
    {
        Intent intent=new Intent(this, AutoHookForm.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }

    public void InsData(View view)//добавить тест
    {
        Intent intent=new Intent(this, InsertTestForm.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }

    public void DeleteData(View view)//удалить тест
    {
        finish();
    }

    public void Search(View view)
    {
        Intent intent=new Intent(this, SearchForm.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}