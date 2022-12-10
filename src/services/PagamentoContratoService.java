package services;

import java.time.LocalDate;

import entities.Contrato;
import entities.Parcela;

public class PagamentoContratoService{

    private PagamentoOnlineService pagamentoOnline;
   
    public PagamentoContratoService(PagamentoOnlineService pagamentoOnline) {
        this.pagamentoOnline = pagamentoOnline;
    }

    public void pagamentoContrato(Contrato contrato, int mes){

        for (int i = 1; i <= mes; i++) {
            LocalDate dataDevida = contrato.getDate().plusMonths(i);

            double parcelaBasica = contrato.getvalorTotal() / mes;

            double juro = pagamentoOnline.juro(parcelaBasica, i);
            double taxa = pagamentoOnline.taxa(parcelaBasica + juro);
            double parcela = parcelaBasica + juro + taxa;

            contrato.getParcela().add(new Parcela(dataDevida, parcela));
        }
    }
}