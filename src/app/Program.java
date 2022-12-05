package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import services.contratoService;
import services.PaypalService;

public class Program {
    public static void main(String[] args) {
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

        contratoService service = new contratoService(new PaypalService());
               
        service.processaContrato(contrato, numeroParcelas);

        System.out.println("Parcelas: ");
        for (Parcela parcela : contrato.getParcela()) {
            System.out.println(parcela);

        }
       sc.close();
    }
}