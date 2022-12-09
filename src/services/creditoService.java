package services;

import enums.TipoPagamento;

public class creditoService implements PagamentoOnlineService {
    private final double taxa = 0.5;
    private final double juroMensal = 0.8;

    public double getTaxa() { // interface pagamentoOnline 
        return taxa;
    }

    public double getJuroMensal() { // interface pagamentoOnline
        return juroMensal;
    }

     // Verifica se o tipo do pagamento é o credito (enums)
    @Override
    public double pagamentoContrato(Double valor, TipoPagamento tipo) {
        if(tipo == TipoPagamento.CREDITO ){
            System.out.println("Pagamento com credito " + valor);
        }
        return 0;
        
    }

}
