package services;

public class PaypalService implements PagamentoOnlineService{
    private static final double taxa = 0.02; // taxa fixa
    private static final double juroMensal = 0.01; // taxa fixa

    @Override
    public double pagamentoTaxa(double quantia) {
        return quantia * taxa;
    }

    @Override
    public double juro(double quantia, int mes) {
        return quantia * juroMensal * mes;
    }
    
}