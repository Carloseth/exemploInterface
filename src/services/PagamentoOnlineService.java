package services;

import enums.TipoPagamento;

public interface PagamentoOnlineService {

    double getTaxa();
    double getJuroMensal();

    default double taxa(double quantia ) {
        return quantia * getTaxa();
    }

    default double juro(double quantia, int mes){
        return quantia * getJuroMensal() * mes;
    }

    void processaTipoPagamento(Double valor, TipoPagamento tipo);

}