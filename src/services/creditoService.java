package services;

public class creditoService implements PagamentoOnlineService {
    private final double taxa = 0.5;
    private final double juroMensal = 0.8;

    public double getTaxa() { // interface pagamentoOnline 
        return taxa;
    }

    public double getJuroMensal() { // interface pagamentoOnline
        return juroMensal;
    }

}
