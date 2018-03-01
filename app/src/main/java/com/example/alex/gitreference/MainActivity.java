package com.example.alex.gitreference;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ImageButton plusButton;
    ArrayList<GitReference> commands = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusButton = findViewById(R.id.plusButton);
        listView = findViewById(R.id.listView);



        try {
            InputStream inputStream = getApplicationContext().getAssets().open("gitReference.json");
            commands = JsonUtils.populateGitReferences(JsonUtils.parseJsonToString(inputStream));
            inputStream.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        CommandAdapter adapter = new CommandAdapter(this, commands);
        listView.setAdapter(adapter);


        //when plus is pressed
        plusButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                popUpEditText();
            }
        });

    }


    private void popUpEditText()
    {
        AlertDialog.Builder popupBox = new AlertDialog.Builder(this); //makes alert dialog
        popupBox.setTitle("Add Command");  //sets title

        final EditText commandInput = new EditText(this);  //makes edit text
        commandInput.setHint("Command");

        final EditText exampleInput = new EditText(this);
        exampleInput.setHint("Example");

        final EditText explanationInput = new EditText(this);
        explanationInput.setHint("Explanation");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(commandInput);
        layout.addView(exampleInput);
        layout.addView(explanationInput);

        //sets up the buttons
        popupBox.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if add it clicked create new command object with new info
                GitReference newCommand = new GitReference();
                newCommand.setCommand(commandInput.getText().toString());
                newCommand.setExample(exampleInput.getText().toString());
                newCommand.setExplanation(explanationInput.getText().toString());
                commands.add(newCommand);

                //add new command to .json file
                JsonUtils.append(getApplicationContext(),"gitReference.json","TEST");

            }
        });
        popupBox.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        popupBox.setView(layout);
        popupBox.show();
    }





}
