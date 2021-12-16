package HuffmanProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static int[] readInt(String inputFile){
    File filename = new File(inputFile);
    String[] StringFreq = new String[26];
    int[] frequencyNumber = new int[26];

    // Read from Text and add to an array until nextLine is Null.
    try (BufferedReader in = new BufferedReader(new FileReader(filename))){
        String line = in.readLine();
        int i = 0;
        while (line != null){
            StringFreq[i] = line;
            i++;
            line = in.readLine();
        }

        int j = 0;
        for (j = 0; j < 26; j++) {
            frequencyNumber[j] = Integer.parseInt(StringFreq[j]);
        }

    }
    catch (IOException e){
        System.out.println(e);
    }
    return frequencyNumber;
}

    public static char[] readChar(String inputFile){
        char[] charList = new char[26];
        File filename = new File(inputFile);
        int i = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            String line = in.readLine();
            while (line != null){
                try{
                    char c = line.charAt(0);
                    charList[i] = c;
                    i++;
                    line = in.readLine();
                }
                catch (NullPointerException e){
                }
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
        return charList;
    }
}
