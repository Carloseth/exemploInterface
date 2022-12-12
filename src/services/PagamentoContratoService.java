package services;

import java.time.LocalDate;
import entities.Contrato;
import entities.Parcela;

public class PagamentoContratoService{
    private TaxaService taxa;
   
    public PagamentoContratoService(TaxaService Taxa) {
        this.taxa = Taxa;
    }

    public void pagamentoContrato(Contrato contrato, int mes){

        for (int i = 1; i <= mes; i++) {
            //Itera os meses
            LocalDate dataDevida = contrato.getDate().plusMonths(i);

            double parcelaSimples = contrato.getvalorTotal() / mes;

            double juro = taxa.juro(parcelaSimples, i);
            double parcelaAposCalculos = parcelaSimples + juro + taxa.taxa(parcelaSimples );

            //Adiciona a parcela na lista de parcelas na classe Parcela
            contrato.getParcela().add(new Parcela(dataDevida, parcelaAposCalculos));
        }
    }
}