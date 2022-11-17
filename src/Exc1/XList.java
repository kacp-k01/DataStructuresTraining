package Exc1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T>{

    private Collection<T> kolekcja;

    //support variables for methods
    private List<T> lista = new ArrayList<>();
    List<T> listTMP;



    public XList(T... lista) {
//	empty constructor - list with size 0
        if(lista.length==0) {
            kolekcja = new ArrayList<>();
        }
//	constructor for argument lists
        else {
            kolekcja = Arrays.asList(lista);
        }
    }

    //constructor from collection
    public XList(Collection<T> kol) {
        kolekcja = new ArrayList<>();
        kolekcja.addAll(kol);
    }


    //funcion from list of arguments or an array
    public static <T> XList<T> of(T... list) {
        XList<T> t1 = new XList(list);
        return t1;

    }

    //function from a collection
    public static <T> XList<T> of (Collection<T> kol) {
        XList<T> t1 = new XList(kol.toArray());
        return t1;
    }

    // xlist class from chars
    public static <T> XList<T> charsOf(T tekst) {
        Object [] charT = ((String)tekst).split("");

        XList<T> t1 = new XList();

        for(int i = 0; i<charT.length;i++) {
            t1.kolekcja.add((T) charT[i]);
        }

        return t1;
    }

    //x list class from words
    public static <T> XList<T> tokensOf(T tekst) {
        Object [] charT = ((String)tekst).split(" ");

        XList<T> t1 = new XList();

        for(int i = 0; i<charT.length;i++) {
            t1.kolekcja.add((T) charT[i]);
        }

        return t1;
    }

    //xlist class for chars divided with symbol
    public static <T> XList<T> tokensOf(T tekst, T sp) {
        Object [] charT = ((String)tekst).split((String)sp);

        XList<T> t1 = new XList();

        for(int i = 0; i<charT.length;i++) {
            t1.kolekcja.add((T) charT[i]);
        }

        return t1;
    }


    // union of 2 Xlist class objects
    public XList<T> union(XList<T> kol) {
        XList<T> unionList = new XList<>();
        unionList.kolekcja.addAll(this.kolekcja);
        unionList.kolekcja.addAll(kol.kolekcja);
        return unionList;
    }

    // union of XList and any collection
    public XList<T> union(Collection<T> kol) {
        XList<T> unionList = new XList<>();
        unionList.kolekcja.addAll(this.kolekcja);
        unionList.kolekcja.addAll(kol);
        return unionList;
    }

    // union of XList and argument list
    public XList<T> union(T... lista) {
        XList<T> unionList = new XList<>();
        unionList.kolekcja.addAll(this.kolekcja);
        unionList.kolekcja.addAll(Arrays.asList(lista));
        return unionList;
    }

//difference of 2 Xlists
    public XList<T> diff(XList<T> kol){

        XList<T> diff = new XList<>();
        diff.addAll(this.kolekcja);
        diff.union(kol.kolekcja);
        diff.removeAll(kol.kolekcja);


        return diff;
    }

    //difference of Xlist and collection
    public XList<T> diff(Collection<T> kol){

        XList<T> diff = new XList<>();
        diff.getKolekcja().addAll(this.kolekcja);
        diff.union(kol);
        diff.getKolekcja().removeAll(kol);

        return diff;
    }


    //leave only unique values
    public XList<T> unique(){

        XList<T> unique = new XList<>();
        unique.setKolekcja(this.kolekcja.stream().distinct().collect(Collectors.toList()));

        return unique;
    }

    // combine 3 collections in an List of all arguments combination
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


//method to perform operation on each index of an XList collection

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
