package Exc1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T>{

    private Collection<T> kolekcja;

    //zmienna pomocnicza
    private List<T> lista = new ArrayList<>();
    List<T> listTMP;



    public XList(T... lista) {
//	opcja dla pustego konstruktora czyli lista size 0
        if(lista.length==0) {
            kolekcja = new ArrayList<>();
        }
//	opcja dla listy argumentów
        else {
            kolekcja = Arrays.asList(lista);
        }
    }

    //opcja dla kolekcji jako argumentu
    public XList(Collection<T> kol) {
        kolekcja = new ArrayList<>();
        kolekcja.addAll(kol);
    }


    //funkcja of z listy argumentów lub z pojedynczej tabeli - jeśli chcielibyśmy funckje z listy tabel, trzeba by było uwzględnić ten przypadek
    public static <T> XList<T> of(T... list) {
        XList<T> t1 = new XList(list);
        return t1;

    }

    //funkcja of z kolekcj
    public static <T> XList<T> of (Collection<T> kol) {
        XList<T> t1 = new XList(kol.toArray());
        return t1;
    }

    // wypisz znaki
    public static <T> XList<T> charsOf(T tekst) {
        Object [] charT = ((String)tekst).split("");

        XList<T> t1 = new XList();

        for(int i = 0; i<charT.length;i++) {
            t1.kolekcja.add((T) charT[i]);
        }

        return t1;
    }

    //wypisz słowa
    public static <T> XList<T> tokensOf(T tekst) {
        Object [] charT = ((String)tekst).split(" ");

        XList<T> t1 = new XList();

        for(int i = 0; i<charT.length;i++) {
            t1.kolekcja.add((T) charT[i]);
        }

        return t1;
    }

    //wypisz znaki oddzielone konkretnym znakiem
    public static <T> XList<T> tokensOf(T tekst, T sp) {
        Object [] charT = ((String)tekst).split((String)sp);

        XList<T> t1 = new XList();

        for(int i = 0; i<charT.length;i++) {
            t1.kolekcja.add((T) charT[i]);
        }

        return t1;
    }


    // z klasy XList
    public XList<T> union(XList<T> kol) {
        XList<T> unionList = new XList<>();
        unionList.kolekcja.addAll(this.kolekcja);
        unionList.kolekcja.addAll(kol.kolekcja);
        return unionList;
    }

    // z dowolnej kolekcji
    public XList<T> union(Collection<T> kol) {
        XList<T> unionList = new XList<>();
        unionList.kolekcja.addAll(this.kolekcja);
        unionList.kolekcja.addAll(kol);
        return unionList;
    }

    // z listy argumentów
    public XList<T> union(T... lista) {
        XList<T> unionList = new XList<>();
        unionList.kolekcja.addAll(this.kolekcja);
        unionList.kolekcja.addAll(Arrays.asList(lista));
        return unionList;
    }


    public XList<T> diff(XList<T> kol){

        XList<T> diff = new XList<>();
        diff.addAll(this.kolekcja);
        diff.union(kol.kolekcja);
        diff.removeAll(kol.kolekcja);


        return diff;
    }

    //funkcja diff
    public XList<T> diff(Collection<T> kol){

        XList<T> diff = new XList<>();
        diff.getKolekcja().addAll(this.kolekcja);
        diff.union(kol);
        diff.getKolekcja().removeAll(kol);

        return diff;
    }


    //funkcja unique
    public XList<T> unique(){

        XList<T> unique = new XList<>();
        unique.setKolekcja(this.kolekcja.stream().distinct().collect(Collectors.toList()));

        return unique;
    }

    // tutaj zakładam że wykonujemy to dla 3 kolekcji
    public XList<XList<T>> combine() {

        List<List<T>> listaStart = new ArrayList(this.kolekcja);
        List<List<T>> konw = new ArrayList();

        XList<XList<T>> listaEnd = new XList<>();

        for (int i = 0; i < listaStart.size(); i++) {
            if(listaStart.get(i) instanceof XList) {
                List<T> temp = new ArrayList();
                temp.addAll(((XList) listaStart.get(i)).getKolekcja());
                konw.add(temp);

            }
            else
                konw.add(listaStart.get(i));
        }




        for (int i = 0; i < konw.get(2).size(); i++) {
            for (int j = 0; j < konw.get(1).size(); j++) {
                for (int x = 0; x < konw.get(0).size(); x++) {
                    XList<T> temp = new XList<>();
                    temp.add(konw.get(0).get(x));
                    temp.add(konw.get(1).get(j));
                    temp.add(konw.get(2).get(i));
                    listaEnd.add(temp);

                }
            }
        }

        return listaEnd;

    }




    public void forEachWithIndex(BiConsumer<T, Integer> bi) {

        listTMP = new ArrayList<>();
        listTMP.addAll(this.kolekcja);

        for (int i = 0; i < listTMP.size(); i++) {
            bi.accept(listTMP.get(i), i);
        }
        this.kolekcja = lista;
    }

    @Override
    public String toString() {
        return kolekcja.toString();
    }


    @Override
    public boolean add(T x) {
        kolekcja.add(x);
        return true;
    }

    public Collection<T> getKolekcja() {
        return kolekcja;
    }

    public void setKolekcja(Collection<T> t) {
        this.kolekcja=t;
    }


    public  T set(int ind, T t) {
        lista.add(ind, t);
        return null;
    }

    public boolean remove(Object ob) {
        this.kolekcja.remove(ob);
        listTMP.remove(ob);
        return true;

    }




}
