package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import services.ContractService;
import services.PaypalService;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("numero: ");
        int numb = sc.nextInt();

        System.out.print("data: ");
        LocalDate date = LocalDate.parse(sc.next(), patternDate);
        
        System.out.print("valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contrato contract = new Contrato(numb, date, totalValue);

        System.out.println("Entre com o numero de parcelas");
        int n = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());
               
        service.processContract(contract, n);

        System.out.println("Parcelas: ");
        for (Parcela installment : contract.getParcela()) {
            System.out.println(installment);

        }

       sc.close();
    }
}
