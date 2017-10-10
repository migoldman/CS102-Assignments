package spell;

import java.io.*;
import java.util.StringTokenizer;

public class Spell {

    private static Dictionary dictionary;
    private static FileReader fileReader;
    private static FileWriter fileWriter;
    private static PrintWriter printWriter;
    private static BufferedReader bufferedFileReader;
    private static BufferedReader bufferedKeyboardReader;
    
    public static void main(String args[]) throws IOException {
        initializeStreams(args);
        dictionary = new Dictionary();
        processDocument();
        finalizeSteams();
    }
    
    private static void initializeStreams(String[] args) throws IOException {
        File file = new File(args[0]);
        fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
    }
    
    private static void finalizeSteams() throws IOException {  
        fileReader.close();
        fileWriter.close();
    }    
    
    private static void processDocument() throws IOException {        
    }
}
