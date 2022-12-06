package services;

public interface PagamentoOnlineService {

    double getTaxa();
    double getJuroMensal();

    default double pagamentoTaxa(double quantia ) {
        return quantia * getTaxa();
    }

    default double juro(double quantia, int mes){
        return quantia * getJuroMensal() * mes;
    }
    
}