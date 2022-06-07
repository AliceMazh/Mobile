package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.model.Test;

import java.util.List;

public class SearchModel extends Model {

    public SearchModel(Context context, List<Test> l) {
       super(context,l);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
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

        View itemView = inflater.inflate(R.layout.list_search, parent, false);

        name = (TextView) itemView.findViewById(R.id.stxt);
        name.setText(this.list.get(position).getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                current_position=list.get(position).getId();
                as = new QuestRequest();
                as.execute(SearchModel.this);
            }
        });
        return itemView;
    }
}
