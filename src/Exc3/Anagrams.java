package Exc3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagrams {

    private final List<String> list = new ArrayList<>();

    public Anagrams(String adress){

        BufferedReader plik;

        try {
            plik = new BufferedReader (new FileReader(adress));


            for(String tekst = plik.readLine(); tekst!=null;tekst = plik.readLine()) {
                String[] temp = tekst.split(" ");

                Collections.addAll(list, temp);

            }
        } catch (NumberFormatException | IOException e1) {
            e1.printStackTrace();
        }
    }

    public List<List<String>> getSortedByAnQty() {
        List<String> temp = new ArrayList<>(this.list);

        List<List<String>> finalList = new ArrayList<>();

        for(int i = 0; i<temp.size(); i++) {
            if(!temp.get(i).equals("taken")) {
                List<String> part = new ArrayList<>();
                part.add(temp.get(i));

                char[] tab1 = temp.get(i).toCharArray();
                Arrays.sort(tab1);

                for(int j = temp.size()-1; j>i; j--) {
                    char[] tab2	= temp.get(j).toCharArray();
                    Arrays.sort(tab2);

                    if(Arrays.equals(tab1, tab2)){
                        part.add(temp.get(j));
                        temp.set(j, "taken");
                    }
                }
                finalList.add(part);
            }
        }


        return finalList;
    }



    public String getAnagramsFor(String tekst) {


        List<String> temp = new ArrayList<>(this.list);
        List<String> finalList = new ArrayList<>();

        char[] master = tekst.toCharArray();
        Arrays.sort(master);

        for (String s : temp) {
            char[] tab2 = s.toCharArray();
            Arrays.sort(tab2);

            if (Arrays.equals(master, tab2) && !s.equals(tekst)) {
                finalList.add(s);
            }
        }

        return tekst+": "+finalList;
    }

    public String toString() {
        return list.toString();
    }

}
