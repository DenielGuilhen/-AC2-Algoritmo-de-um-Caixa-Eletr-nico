package banco;

import java.util.Locale;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao;
        float saldo = 1000, deposito = 0, saque, sair;
        String CPF, senha = "";

        do {
            System.out.println(" BEM VINDO ");
            System.out.print("Digite seu CPF: ");
            CPF = sc.next();
            if (CPF.equals("123.456.789-00")) {
                senha = "";
                for (int i = 0; i < 3 && !senha.equals("01020304"); i++) {
                    System.out.print("Digite sua senha: ");
                    senha = sc.next();
                }

                if (senha.equals("01020304")) {
                    System.out.println("Escolha a operação: \n 1 - Saldo \n 2 - Deposito \n 3 - Saque \n 0 - Sair");
                    opcao = sc.nextInt();
                    while (opcao != 0) {
                        switch (opcao) {
                            case 1:
                                System.out.printf("Saldo: R$ %.2f\n", saldo);
                                break;
                            case 2:
                                System.out.print("Valor do deposito: R$ ");
                                deposito = sc.nextFloat();
                                saldo = saldo + deposito;
                                System.out.printf("Deposito: R$ %.2f\n", deposito);
                                System.out.printf("Saldo: R$ %.2f\n", saldo);
                                break;
                            case 3:
                                System.out.print("Valor do saque: R$ ");
                                saque = sc.nextFloat();
                                if (saque > saldo) {
                                    System.out.println("Valor invalido.");
                                } else {
                                    saldo = saldo - saque;
                                    System.out.printf("Saque: R$ %.2f\n", saque);
                                    System.out.printf("Saldo: R$ %.2f\n", saldo);
                                }
                                break;
                        }
                        System.out.println("Escolha a operação: \n 1 - Saldo \n 2 - Deposito \n 3 - Saque \n 0 - Sair");
                        opcao = sc.nextInt();
                    }

                } else {
                    System.out.println("Senha invalida.");
                }

            } else {
                System.out.println("CPF invalido.");
            }
        } while (CPF.equals("123.456.789-00") && senha.equals("01020304"));
    }

}
