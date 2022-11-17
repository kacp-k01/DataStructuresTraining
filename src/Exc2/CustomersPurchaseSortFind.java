package Exc2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomersPurchaseSortFind {

    private List<Purchase> list = new ArrayList<>();

// load class objects from a file
    public void readFile(String adress){

        BufferedReader plik = null;

        try {
            plik = new BufferedReader (new FileReader(adress));


            for(String tekst = plik.readLine(); tekst!=null;tekst = plik.readLine()) {
                String[] temp = tekst.split(";");

                String kod = temp[0];
                String[] idT = kod.split("c");
                Integer id = Integer.parseInt(idT[1]);
                String NazwiskoImie = temp[1];
                String  nazwa_towaru = temp[2];
                double cena = Double.parseDouble(temp[3]);
                Double zakupiona_ilosc = Double.parseDouble(temp[4]);
                double kosztZakupu = cena*zakupiona_ilosc;

                Purchase tempP = new Purchase(kod,id,NazwiskoImie,nazwa_towaru,cena,zakupiona_ilosc,kosztZakupu);
                list.add(tempP);


            }
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        finally {
            if(plik != null)
                try {
                    plik.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

//method for sorting by name - Nazwisko and costs - Koszty

    public void showSortedBy(String pole) {
        if(pole.equals("Nazwiska")) {

            System.out.println("Nazwiska");
            list.sort((o1, o2)-> o1.getId().compareTo(o2.getId()));
            list.sort((o1, o2)-> o1.getNazwiskoImie().compareTo(o2.getNazwiskoImie()));

            for(Purchase l :list) {
                System.out.println(l);
            }
        }

        if(pole.equals("Koszty")) {

            System.out.println("Koszty");
            list.sort((o1, o2)-> o1.getId().compareTo(o2.getId()));
            list.sort((o1, o2)-> o1.getkosztZakupu().compareTo(o2.getkosztZakupu())*-1);

            for(Purchase l :list) {
                System.out.println(l+" (koszt: "+l.getkosztZakupu()+")");
            }
        }

        System.out.println();



    }

//    method showing purchases for exact client by his id

    public void showPurchaseFor(String id) {
        System.out.println("Klient "+id);

        for(Purchase l :list) {
            if(l.getKod().equals(id)) {
                System.out.println(l);
            }
        }


        System.out.println();

    }


    @Override
    public String toString() {
        return list.toString();
    }

}