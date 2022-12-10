package services;

import enums.TipoPagamento;

public class CreditoService implements PagamentoOnlineService {
    private final double taxa = 0.5;
    private final double juroMensal = 0.03;

    public double getTaxa() { // interface pagamentoOnline 
        return taxa;
    }

    public double getJuroMensal() { // interface pagamentoOnline
        return juroMensal;
    }

     // Verifica se o tipo do pagamento é o credito (enums)
    @Override
    public void processaTipoPagamento(Double valor, TipoPagamento tipo) {
        if(tipo == TipoPagamento.CREDITO ){
            System.out.println("Pagamento com credito " + valor);
        }
        
        
    }

}