package services;

import java.time.LocalDate;

import entities.Contrato;
import entities.Parcela;

public class contratoService{

    private PagamentoOnlineService onlinePaymentServices;
   
    public contratoService(PagamentoOnlineService onlinePaymentServices) {
        this.onlinePaymentServices = onlinePaymentServices;
    }

    public void processaContrato(Contrato contrato, int mes){

        for (int i = 1; i <= mes; i++) {
            LocalDate dataDevida = contrato.getDate().plusMonths(i);

            double parcelaBasica = contrato.getvalorTotal() / mes;
            double juro = onlinePaymentServices.juro(parcelaBasica, i);
            double taxa = onlinePaymentServices.pagamentoTaxa(parcelaBasica + juro);

            double parcela = parcelaBasica + juro + taxa;

            contrato.getParcela().add(new Parcela(dataDevida, parcela));
        }

    }
}