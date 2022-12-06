package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import services.contratoService;
import services.creditoService;
import services.pixService;
import services.PaypalService;

public class Program {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
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

        System.out.println("Qual metodo de pagamento? ");
        
       
            System.out.println("Opcao 1: Cartao de credito ");
            System.out.println("------------------------------------------");
            System.out.println("Opcao 2: paypal");
            System.out.println("------------------------------------------");
            System.out.println("Opcao 3: pix");
            String resposta = sc.next();

            
               System.out.println("Opcao indisponivel, tente novamente");
        
               switch (resposta) {
                case "1":
                contratoService service = new contratoService(new creditoService());
                service.processaContrato(contrato, numeroParcelas);
                    break;

                case "2":
                service = new contratoService(new PaypalService());
                service.processaContrato(contrato, numeroParcelas);
                    break;

                case "3":
                service = new contratoService(new pixService());
                service.processaContrato(contrato, numeroParcelas);
                default:
                System.out.println("Opção indisponível");
                //Falta fazer retornar para o inicio, caso seja indisponivel
               }
        
        sc.close();      
    }
}