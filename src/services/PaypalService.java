package services;

public class PaypalService implements PagamentoOnlineService{
    private final double taxa = 0.4; // taxa fixa
    private final double juroMensal = 0.5; // taxa fixa


    public double getTaxa() {
        return taxa;
    }

    public double getJuroMensal() {
        return juroMensal;
    }
}