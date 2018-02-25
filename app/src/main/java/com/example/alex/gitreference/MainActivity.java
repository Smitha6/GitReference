package com.example.alex.gitreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    GitReference command;
    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayList<GitReference> commands = new ArrayList<>();

        /*
        try {
            InputStream inputStream = getApplicationContext().getAssets().open("gitReference.json");
            commands = JsonUtils.populateGitReferences(JsonUtils.parseJsonToString(inputStream));
        }
        catch(Exception e) {
            System.out.println(e);
        }

        */
        command = new GitReference();
        command.setCommand("command 1");
        command.setExample("example 1");
        commands.add(command);




        CommandAdapter adapter = new CommandAdapter(this, commands);
        listView.setAdapter(adapter);


    }
}
