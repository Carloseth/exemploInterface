package services;

import enums.TipoPagamento;

public interface PagamentoOnlineService {

    double getTaxa();
    double getJuroMensal();

    default double pagamentoTaxa(double quantia ) {
        return quantia * getTaxa();
    }

    default double juro(double quantia, int mes){
        return quantia * getJuroMensal() * mes;
    }

    abstract double pagamentoContrato(Double valor, TipoPagamento tipo);

    
}