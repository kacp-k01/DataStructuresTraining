package Exc3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Anagrams {


    private List<String> list = new ArrayList<>();
    private List<char[]> listTest;


    public Anagrams(String adress){

        BufferedReader plik = null;

        try {
            plik = new BufferedReader (new FileReader(adress));


            for(String tekst = plik.readLine(); tekst!=null;tekst = plik.readLine()) {
                String[] temp = tekst.split(" ");

                for(String t : temp) {
                    list.add(t);
                }

            }
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    public List<List<String>> getSortedByAnQty() {
        List<String> temp = new ArrayList<>();
        temp.addAll(this.list);

        List<List<String>> finalList = new ArrayList<List<String>>();

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


        List<String> temp = new ArrayList<>();
        temp.addAll(this.list);
        List<String> finalList = new ArrayList<>();

        char[] master = tekst.toCharArray();
        Arrays.sort(master);

        for(int i = 0; i<temp.size(); i++) {
            char[] tab2	= temp.get(i).toCharArray();
            Arrays.sort(tab2);

            if(Arrays.equals(master, tab2)&&!temp.get(i).equals(tekst)){
                finalList.add(temp.get(i));
            }

        }



        return tekst+": "+finalList;
    }

    public String toString() {
        return list.toString();
    }

}
