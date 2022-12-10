package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
    
    private Integer numeroContrato;
    private LocalDate date;
    private Double valorTotal;

    //Lista de parcelas
    List<Parcela> Parcela = new ArrayList<>();

    public Contrato(Integer numeroContrato, LocalDate date, Double valorTotal) {
        this.numeroContrato = numeroContrato;
        this.date = date;
        this.valorTotal = valorTotal;
    }    
    
    public Integer getnumeroContrato() {
        return numeroContrato;
    }
    public LocalDate getDate() {
        return date;
    }
    public Double getvalorTotal() {
        return valorTotal;
    }

    public List<Parcela> getParcela() {
        return Parcela;
    }

}