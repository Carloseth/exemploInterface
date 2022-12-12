package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import enums.TipoPagamento;
import services.TaxaService;
import services.PaypalService;
import services.PagamentoContratoService;
import services.CreditoService;
import services.PixService;


public class Main { 
    static TipoPagamento tipo;
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        PagamentoContratoService service;
        
        //Lista de pagamentos paypal, credito e pix
        List<TaxaService> pagamentoOnlineList = Arrays
        .asList(new PaypalService(), new CreditoService(), new PixService());

        //Formatacao de data
        DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Insira os dados do contrato: ");
        System.out.print("numero: ");
        int numeroContrato = sc.nextInt();

        System.out.print("data: ");
        //Lê a data e faz o parse para o formato definido no patternDate
        LocalDate date = LocalDate.parse(sc.next(), patternDate);
        
        System.out.print("valor do contrato: ");
        double valorTotal = sc.nextDouble();

        Contrato contrato = new Contrato(numeroContrato, date, valorTotal);

        System.out.println("Entre com o numero de parcelas");
        int numeroParcelas = sc.nextInt();

        System.out.println();
        System.out.println();
        System.out.println("Qual metodo de pagamento? ");
        
            System.out.println("Opcao 1: Cartao de credito ");
            System.out.println("------------------------------------------");
            System.out.println("Opcao 2: paypal");
            System.out.println("------------------------------------------");
            System.out.println("Opcao 3: pix");

            String resposta = sc.next();
            // Verifica se a resposta equivale à opção solicitada
            if("1".equals(resposta)){
                tipo = TipoPagamento.CREDITO;
                //Recebe a opcao de pagamento como parametro para o pagamento do contrato
                service = new PagamentoContratoService(new CreditoService());
                service.pagamentoContrato(contrato, numeroParcelas);
            }
            else if("2".equals(resposta)){
                tipo = TipoPagamento.PAYPAL;
                service = new PagamentoContratoService(new PaypalService());
                service.pagamentoContrato(contrato, numeroParcelas);
            }
            else if("3".equals(resposta)){
                tipo = TipoPagamento.PIX;
                service = new PagamentoContratoService(new PixService());
                service.pagamentoContrato(contrato, numeroParcelas);
            }
            else{
                System.out.println("Opcao invalida");
            }
            
            // Imprime o tipo de pagamento com seu valor
            pagamentoOnlineList.forEach(tipoPagamento -> tipoPagamento.processaTipoPagamento(valorTotal, tipo));  
            
            // Imprime as parcelas
            for (Parcela parcela : contrato.getParcela()) {
                    System.out.println(parcela);
               }

        sc.close();      
    }
}