package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertTestForm extends AppCompatActivity {//

    static String input_name;
    private InsertTestRequest as;
    ArrayList<Test> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        list= (ArrayList<Test>) getIntent().getExtras().getSerializable("list");
    }

    public void add_str(View view)//
    {
        EditText et=(EditText)findViewById(R.id.name);
        if(et.getText()!=null) {
            input_name = et.getText().toString();
            as=new InsertTestRequest();
            as.execute(this);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Tedit is Empty!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void finisher(List<Test> list)
    {
        Intent intent=new Intent(this, TestList.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if(as!=null)
            as.cancel(true);
        Intent intent=new Intent(this, TestList.class);
        intent.putExtra("list",(ArrayList)list);
        startActivity(intent);
        finish();
    }
}
