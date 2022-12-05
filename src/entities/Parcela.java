package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
    private static DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate date; // data de vencimento
    private Double quantia;

    public Parcela(LocalDate date, Double quantia) {
        this.date = date;
        this.quantia = quantia;
    }
    public LocalDate getDate() {
        return date;
    }
    public Double getQuantia() {
        return quantia;
    }

    @Override
    public String toString(){
        return date.format(patternDate) + " - " + String.format("%.2f", getQuantia()) ;
    }
}