package services;

public class pixService implements PagamentoOnlineService {
    private final double taxa = 0.1; // taxa fixa
    private final double juroMensal = 0.02; // taxa fixa


    public double getTaxa() {
        return taxa;
    }
    
    public double getJuroMensal() {
        return juroMensal;
    }
}
