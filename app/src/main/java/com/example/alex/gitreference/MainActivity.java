package com.example.alex.gitreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Command command;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView.findViewById(R.id.listView);

        command = new Command();
        command.setCommand("clone");
        //command.setExample("git clone ssh://user@domain.com/repo.git");
        command.setExplanation("Clone an existing repository");



    }
}
