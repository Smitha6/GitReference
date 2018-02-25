package com.example.alex.gitreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alex on 2/16/2018.
 */

public class CommandAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<GitReference> mDataSource;

    public CommandAdapter(Context context, ArrayList<GitReference> commands)
    {
        mContext = context;
        mDataSource = commands;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }
    @Override
    public int getCount() {return mDataSource.size();}

    @Override
    public Object getItem(int i) {return mDataSource.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        View rowView = mInflater.inflate(R.layout.list_3_items, viewGroup, false);

        TextView commandView = rowView.findViewById(R.id.text1);
        TextView commandExampleView = rowView.findViewById(R.id.text2);
        TextView commandExplanationView = rowView.findViewById(R.id.text3);

        GitReference command = (GitReference) getItem(position);
        commandView.setText(command.getCommand());
        commandExampleView.setText(command.getExample());
        commandExplanationView.setText(command.getExplanation());

        return rowView;
    }
}