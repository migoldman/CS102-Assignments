package editorapplication;

import acm.program.*;
import utilities.*;

public class EditorApplication extends ConsoleProgram {

    public void run() {
        Editor editor = new Editor(getConsole());
        println("Line Editor Program");
        do {
            print("Command: ");
            String command = readLine().trim().toUpperCase();
            if (command.equals("UP")) {
                editor.up();
            } else if (command.equals("DOWN")) {
                editor.down();
            } else if (command.equals("INSERT")) {
                editor.insert(readLine("Insert: "));
            } else if (command.equals("DELETE")) {
                editor.delete();
            } else if (command.equals("ALL")) {
                editor.printAll();
            } else if (command.equals("CURRENT")) {
                editor.printCurrent();
            } else if (command.equals("QUIT")) {
                System.exit(0);
            }
        } while (true);

    }


    public static void main(String[] args) {
        new EditorApplication().start();
    }
}
