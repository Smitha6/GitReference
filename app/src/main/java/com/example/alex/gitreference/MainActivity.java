package com.example.alex.gitreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    GitReference command;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<GitReference> commands = new ArrayList<>();





        command = new GitReference();
        command.setCommand("clone");
        command.setExample("git clone ssh://user@domain.com/repo.git");
        command.setExplanation("Clone an existing repository");
        commands.add(command);

        command = new GitReference();
        command.setCommand("2");
        command.setExample("2");
        command.setExplanation("2");
        commands.add(command);



        CommandAdapter adapter = new CommandAdapter(this, commands);
        listView.setAdapter(adapter);


    }
}
