package editorapplication;

import acm.io.*;
import utilities.*;

public class Editor {

    private List<String> text;
    private int current;
    private IOConsole console;

    Editor(IOConsole console) {
        this.console = console;
        text = new ListDL<String>();
        current = 0;
    }

    public void up() {
        if (current > 0) {
            current--;
        } else {
            console.println("Cannot move up.");
        }
    }

    public void down() {
        if (current < text.size()) {
            current++;
        } else {
            console.println("Cannot move down.");
        }
    }

    public void insert(String newText) {
        text.insert(newText, current);
        current++;
    }

    public void delete() {
        if (current < text.size()) {
            text.delete(current);
        } else {
            console.println("No line to delete.");
        }

    }

    public void printCurrent() {

        if (current < text.size()) {
            console.println(text.elementAt(current));
        } else {
            console.println("No line to print.");
        }
    }

    public void printAll() {
        for (int i = 0; i < text.size(); i++) {
            if (i == current) {
                console.print("> ");
            } else {
                console.print("  ");
            }
            console.println(text.elementAt(i));
        }
        if (current == text.size()) {
            console.println("> ");
        }
    }
}