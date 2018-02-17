package com.example.alex.gitreference;

/**
 * Created by Alex on 2/16/2018.
 */

public class Command {

    private String command;
    private String example;
    private String explanation;

    public Command() {}

    public void setCommand(String command) {this.command = command;}
    public String getCommand() {return command;}

    public void setExample(String example) {this.example = example;}
    public String getExample() {return example;}

    public void setExplanation(String explanation) {this.explanation = explanation;}
    public String getExplanation() {return explanation;}
}
