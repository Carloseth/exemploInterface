package services;

import enums.TipoPagamento;

public class PixService  implements TaxaService {
    private final double taxa = 0.1; // taxa fixa
    private final double juroMensal = 0.02; // taxa fixa
    
    public PixService() {
    }

    public double getTaxa() {
        return taxa;
    }
    
    public double getJuroMensal() {
        return juroMensal;
    }

    @Override
    public void processaTipoPagamento(Double valor, TipoPagamento tipo) {
        if(tipo == TipoPagamento.PIX){
            System.out.println("Pagamento com pix: " + valor);
        }
    }
}