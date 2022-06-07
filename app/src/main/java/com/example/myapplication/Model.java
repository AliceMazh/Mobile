package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.model.Question;
import com.example.myapplication.model.Test;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;


public class Model extends BaseAdapter
{
    Context context;
    LayoutInflater inflater;
    List<Test> list;
    public static int current_position=0;
    private Test curr;
    TestList testList;

    public Test getCurr() {
        return curr;
    }

    protected QuestRequest as;
    public static User user;

    public Model(Context context,List<Test> l) {

        this.context = context;
        Sort(l);
        this.list=l;

    }

    public TestList getTestList() {
        return testList;
    }

    public void setTestList(TestList testList) {
        this.testList = testList;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        TextView name;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list, parent, false);

        name = (TextView) itemView.findViewById(R.id.txt);
        name.setText(this.list.get(position).getName());

        Button b=(Button)itemView.findViewById(R.id.btCancel);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=list.get(position);
                TestDeleteRequest as=new TestDeleteRequest();
                as.execute(Model.this);
            }
        });

        if(Model.user!=null) {
            if (Model.user.getPremission() > 0) {
                b.setVisibility(View.VISIBLE);
            }
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                current_position=list.get(position).getId();
                as=new QuestRequest();
                as.execute(Model.this);
            }
        });
        return itemView;
    }

    void Load_test(List<Question> ql)
    {
        if(ql.size()!=0) {
            Intent intent = new Intent(context, QuestForm.class);
            intent.putExtra("qlist", (ArrayList) ql);
            context.startActivity(intent);
        }
        else
            {
                Intent intent = new Intent(context, QuestInsertOnEmptyTestForm.class);
                context.startActivity(intent);
            }
    }

    void Reload_activity(List<Test> ql)
    {
        Intent intent = new Intent(context, TestList.class);
        intent.putExtra("list", (ArrayList) ql);
        context.startActivity(intent);
        this.testList.finish();
    }

    void Sort(List<Test> arr)
    {
        for(int i = arr.size()-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j).getName().compareTo(arr.get(j + 1).getName()) > 0) {
                    Test tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, tmp);
                }
            }
        }
    }
}
