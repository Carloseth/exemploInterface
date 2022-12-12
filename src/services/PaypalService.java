package services;

import enums.TipoPagamento;

public class PaypalService implements TaxaService{
    private final double taxa = 0.03; // taxa fixa
    private final double juroMensal = 0.01; // taxa fixa

    public double getTaxa() {
        return taxa;
    }

    public double getJuroMensal() {
        return juroMensal;
    }

    @Override
    public void processaTipoPagamento(Double valor, TipoPagamento tipo) {
        if(tipo == TipoPagamento.PAYPAL){
            System.out.println("Pagamento com paypal: " + valor);
        }   
    }
}