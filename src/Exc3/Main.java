package Exc3;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String allWords = "allwords.txt";
        Anagrams an = new Anagrams(allWords);

        // getSortedByAnQty() - method which groups anagram words from source file into single Lists
        for (List<String> wlist : an.getSortedByAnQty()) {
            System.out.println(wlist);
        }
        System.out.println("************************");
        Scanner scan = new Scanner(new File("wordsToFind.txt"));

        // getAnagramsFor)() - method wich search for anagrams of words from a given file in Anagram list given earlier
        while (scan.hasNext()) {
            System.out.println(an.getAnagramsFor(scan.next()));
        }
        scan.close();
    }
}
