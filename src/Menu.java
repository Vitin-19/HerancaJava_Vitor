package src;

import java.util.ArrayList;
import java.util.Scanner;
import src.models.Funcionario;

public class Menu {

    Scanner scan = new Scanner(System.in);
    Menu_Metodos metodo = new Menu_Metodos();

    public ArrayList<Funcionario> menu(ArrayList<Funcionario> funcionarios) {
        do {
            System.out.println("____MENU____");
            System.out.println("1- Cadastrar funcionário");
            System.out.println("2- Visualizar dados de funcionário");
            System.out.println("3- Executar função de funcionário");
            System.out.println("4- Sair");
            System.out.println("Digite sua operação Ex: 1,2,3...");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    metodo.cadastrarFuncionario(funcionarios);
                    break;
                case 2:
                    metodo.visualizarFuncionario(funcionarios);
                    break;
                case 3:
                    metodo.executarFuncaoDeFuncionario(funcionarios);
                    break;
                case 4:
                    System.out.println("Saindo... ");
                    //Bloco try catch para fazer um delay de 2 segundos antes de parar a execução do programa
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException erro) {
                        erro.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            if (opcao == 4) {
                break;
            }
        } while (true);
        return funcionarios;
    }

}
