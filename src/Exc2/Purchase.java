package Exc2;

public class Purchase {
    final private String kod;
    final private Integer id;
    final private String NazwiskoImie;
    final private String  nazwa_towaru;
    final private double cena;
    final private double zakupiona_ilosc;
    final private Double kosztZakupu ;


    public Purchase(String kod, int id, String NazwiskoImie, String  nazwa_towaru, double cena, double zakupiona_ilosc, double kosztZakupu ) {
        this.kod=kod;
        this.id=id;
        this.NazwiskoImie=NazwiskoImie;
        this.nazwa_towaru=nazwa_towaru;
        this.cena=cena;
        this.zakupiona_ilosc=zakupiona_ilosc;
        this.kosztZakupu=kosztZakupu;

    }


    @Override
    public String toString() {
        return kod+";"+NazwiskoImie+";"+nazwa_towaru+";"+cena+";"+zakupiona_ilosc;
    }

    public String getNazwiskoImie() {
        return NazwiskoImie;
    }

    public Integer getId() {
        return id;
    }

    public String getKod() {
        return kod;
    }

    public Double getkosztZakupu () {
        return kosztZakupu;
    }


}
