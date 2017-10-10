package spell;

import java.io.*;


public class Dictionary {
    
    String[] wordTable;
    String[] reducedWordTable;
    
    public Dictionary() throws IOException {
        this("dictionary.txt");
    }

    public Dictionary(String filename) throws IOException {
        File file = new File("dictionary.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int length = Integer.parseInt(bufferedReader.readLine());
        wordTable = new String[length];
        reducedWordTable = new String[length];
        for (int i = 0; i < length; i++) {
            String word = bufferedReader.readLine();
            wordTable[i] = word;
            String reducedWord = reduce(word);
            reducedWordTable[i] = reducedWord;
        }
    }
    
    private static final String VOWELS = "aeiou";

    private static boolean isVowel(char c) {
        return !(VOWELS.indexOf(c) == -1);
    }

    public static String reduce(String word) {
        StringBuffer reducedWord = new StringBuffer();

        word = word.toLowerCase();

        if (isVowel(word.charAt(0))) {
            reducedWord.append('!');
        }

        for (int index = 0; index < word.length(); index++) {
            char currentChar = word.charAt(index);
            if (!isVowel(currentChar)
                    && ((index + 1 == word.length()) || (currentChar != word.charAt(index + 1)))) {
                reducedWord.append(currentChar);
            }
        }
        return new String(reducedWord);
    }
    

    public String similarWords(String word) {
        String reducedWord = reduce(word);
        String answer = "";
        for (int i=0; i<wordTable.length; i++) {
            if (reducedWord.equals(reducedWordTable[i])) {
                answer += " ";
                answer += wordTable[i];
            }
        }
        return answer;
    }
    
    public boolean contains(String word) {
        return contains(word, 0, wordTable.length);
    }     
    
    public boolean contains(String word, int begin, int end) {
        int mid;
        boolean check = false;
        int temp;
        if (begin == end) {
            check = false;
        } else {
            mid = (begin + end)/2;
            temp = word.compareTo(wordTable[mid]);
            if(temp ==0)
            {
                check = true;
            } else if (temp < 0) {
                contains(word, begin, mid);
            }
            else {
                contains(word, mid+1, end);
            }               
        }
        return check;
    }    
}

