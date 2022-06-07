package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.model.Test;

import java.util.ArrayList;

public class SearchForm extends AppCompatActivity {//поиск теста

    ArrayList<Test> list;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        list= (ArrayList<Test>) getIntent().getExtras().getSerializable("list");
    }

    public void Search(View view)//поиск
    {
        EditText editText=(EditText)findViewById(R.id.sname);
        String s=editText.getText().toString();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getName().equals(s))
            {
                ArrayList<Test> RList=new ArrayList<>();
                RList.add(list.get(i));
                change(RList);
            }
        }
    }

    public void change(ArrayList<Test> l)
    {
        this.setContentView(R.layout.lister_search);
        listview=(ListView)findViewById(R.id.listviewsearch);
        SearchModel model=new SearchModel(this,l);
        listview.setAdapter(model);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this, TestList.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
