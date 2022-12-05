package services;

public interface PagamentoOnlineService {
    
    double pagamentoTaxa(double quantia);
    double juro(double quantia, int mes);
    
}
