package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;

import enums.TipoPagamento;
import services.PagamentoOnlineService;
import services.PaypalService;
import services.contratoService;
import services.creditoService;
import services.pixService;

public class Program { 
    static TipoPagamento tipo;
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<PagamentoOnlineService> pagamentoOnlineList = Arrays
        .asList(new PaypalService(), new creditoService(), new pixService());
        DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("numero: ");
        int numeroContrato = sc.nextInt();

        System.out.print("data: ");
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
            if("1".equals(resposta)){
                tipo = TipoPagamento.CREDITO;
            }
            else if("2".equals(resposta)){
                tipo = TipoPagamento.PAYPAL;
            }
            else if("3".equals(resposta)){
                tipo = TipoPagamento.PIX;
            }
            else{
                System.out.println("Opcao invalida");
            }
            
            pagamentoOnlineList.forEach(tipoPagamento -> tipoPagamento.pagamentoContrato(valorTotal, tipo));
            
            
            //    for (Parcela parcela : contrato.getParcela()) {
            //         System.out.println(parcela);
            //    }
        sc.close();      
    }
}