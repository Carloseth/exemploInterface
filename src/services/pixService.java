package services;

import enums.TipoPagamento;

public class pixService implements PagamentoOnlineService {
    private final double taxa = 0.1; // taxa fixa
    private final double juroMensal = 0.02; // taxa fixa


    public double getTaxa() {
        return taxa;
    }
    
    public double getJuroMensal() {
        return juroMensal;
    }

    @Override
    public double pagamentoContrato(Double valor, TipoPagamento tipo) {
        if(tipo == TipoPagamento.PIX){
            System.out.println("Pagamento com pix: " + valor);
        }
        
        return 0;
    }
}
