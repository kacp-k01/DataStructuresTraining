package Exc2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Purchase {
    final private String kod;
    final private Integer id;
    final private String NazwiskoImie;
    final private String nazwa_towaru;
    final private double cena;
    final private double zakupiona_ilosc;
    final private Double kosztZakupu;

    @Override
    public String toString() {
        return kod + ";" + NazwiskoImie + ";" + nazwa_towaru + ";" + cena + ";" + zakupiona_ilosc;
    }
}
