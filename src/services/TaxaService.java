package services;

import enums.TipoPagamento;

/*      Uma interface, é um grupo de métodos relacionados com corpos vazios, 
*       Que irá "obrigar" a implementação desses métodos nas classes que implementam a interface.
*/

public interface TaxaService {

    //  Metodo definido na interface que irá ser implementado nas classes que a implementam
    double getTaxa();
    double getJuroMensal();

    /*  Metodo default é herdado pelas classes que implementam a interface,
        Dessa forma, a interface pode fornecer comportamento (além de apenas especificar contratos)
    */
    default double taxa(double quantia ) {
        return quantia * getTaxa();
    }

    default double juro(double quantia, int mes){
        return quantia * getJuroMensal() * mes;
    }

    void processaTipoPagamento(Double valor, TipoPagamento tipo);

}