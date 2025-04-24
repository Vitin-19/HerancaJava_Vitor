package src;

import java.util.ArrayList;
import java.util.Scanner;
import src.models.Desenvolvedor;
import src.models.Estagiario;
import src.models.Funcionario;
import src.models.Gerente;

public class Menu_Metodos {
    Scanner scan = new Scanner(System.in);
    public ArrayList<Funcionario> cadastrarFuncionario(ArrayList<Funcionario> funcionarios) {
        try {
            System.out.println("Digite o nome do funcionário: ");
            String nome = scan.nextLine();
            System.out.println("Digite a data de nascimento do funcionário: dd/mm/aaaa");
            String dataNascimento = scan.nextLine();
            if ((dataNascimento + "").length() != 10 || !verificaData(dataNascimento) ) {
                System.out.println("Data inválida");
                return funcionarios;
            }
            scan.nextLine();
            System.out.println("Digite o cpf do funcionário: (Ex: 999.999.999-99)");
            String cpf = scan.nextLine().trim();
            if (cpf.length() != 14 || !verificaCpf(cpf)) {
                System.out.println("CPF inválido\nErro ao cadastrar usuário");
                return funcionarios;
            }
            System.out.println("Digite o salário do funcionário: ");
            double salario = scan.nextDouble();
            scan.nextLine();
            System.out.println("Digite o departamento do funcionário: ");
            String departamento = scan.nextLine();
            System.out.println("Digite o cargo do funcionário: (Ex:1,2,3...) \n1- Gerente\n2- Estagiario\n3- Desenvolvedor\n4- Outro\nOutro- Cancelar\n");
            int cargo = scan.nextInt();
            scan.nextLine();
            switch (cargo) {
                case 1:
                    if(!verificaDados(cpf, dataNascimento, nome, salario, departamento, "Gerente")){
                        System.out.println("Operação cancelada");
                        return funcionarios;
                    }
                    Funcionario novoGerente = new Gerente(cpf, dataNascimento, nome, salario, departamento);
                    funcionarios.add(novoGerente);
                    break;
                case 2:
                    if(!verificaDados(cpf, dataNascimento, nome, salario, departamento, "Estagiário")){
                        System.out.println("Operação cancelada");
                        return funcionarios;
                    }
                    Funcionario novoEstagiario = new Estagiario(cpf, dataNascimento, nome, salario, departamento);
                    funcionarios.add(novoEstagiario);
                    break;
                case 3:
                    System.out.println("Digite as linguagens de programação que o desenvolvedor trabalha: (Ex: C,C++,Java...)");
                    String[] linguagens = scan.nextLine().split(",");
                    for(int i = 0; i < linguagens.length; i++){
                        linguagens[i] = linguagens[i].trim();
                    }

                    if(!verificaDados(cpf, dataNascimento, nome, salario, departamento, "Desenvolvedor", linguagens)){
                        System.out.println("Operação cancelada");
                        return funcionarios;
                    }

                    Funcionario novoDesenvolvedor = new Desenvolvedor(cpf, dataNascimento, nome, salario, departamento, linguagens);
                    funcionarios.add(novoDesenvolvedor);
                    break;
                case 4:
                    System.out.println("Digite o cargo: ");
                    String novoCargo = scan.nextLine();
                    Funcionario novoFuncionario = new Funcionario(cpf, dataNascimento, nome, salario, departamento, novoCargo);
                    funcionarios.add(novoFuncionario);
                    break;
                default:
                    System.out.println("Operação cancelada");
                    return funcionarios;
            }
            System.out.println("Funcionário cadastrado com sucesso");

        } catch (Exception erro) {
            System.out.println("Erro ao cadastrar funcionário");
        }
        return funcionarios;
    }

    public void visualizarFuncionario(ArrayList<Funcionario> funcionarios) {
        int i = 1;
        System.out.println("Selecione um funcionário: (Ex: 1,2,3,...)");
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("%d- %s\n", i, funcionario.getNome());
            i++;
        }

        int funcionarioSelecionado = scan.nextInt() - 1;
        scan.nextLine();
        funcionarios.get(funcionarioSelecionado).mostrarDados();
    }

    public void executarFuncaoDeFuncionario(ArrayList<Funcionario> funcionarios) {
        int i = 1;
        System.out.println("Selecione um funcionário: (Ex: 1,2,3,...)");
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("%d- %s\n", i, funcionario.getNome());
            i++;
        }
        int indexFuncionarioSelecionado = scan.nextInt() - 1;
        scan.nextLine();

        if (funcionarios.get(indexFuncionarioSelecionado).getCargo().equals("Gerente")) {
            System.out.println("1- Bater Ponto");
            System.out.println("2- Realizar reunião");
            System.out.println("Digite sua opção: (Ex: 1,2,...)");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    funcionarios.get(indexFuncionarioSelecionado).baterPonto();
                    break;
                case 2:
                    funcionarios.get(indexFuncionarioSelecionado).realizarReuniao();
                    break;
                default:
                    System.out.println("Operação cancelada");
                break;
            }
        } else if (funcionarios.get(indexFuncionarioSelecionado).getCargo().equals("Desenvolvedor")) {
            System.out.println("1- Bater Ponto");
            System.out.println("2- Programar");
            System.out.println("Digite sua opção: (Ex: 1,2,...)");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    funcionarios.get(indexFuncionarioSelecionado).baterPonto();
                    break;
                case 2:
                    funcionarios.get(indexFuncionarioSelecionado).programar();
                    break;
                default:
                    System.out.println("Operação cancelada");
                break;
            }
        } else if (funcionarios.get(indexFuncionarioSelecionado).getCargo().equals("Estagiario")) {
            System.out.println("1- Bater Ponto");
            System.out.println("2- Fazer Tarefa");
            System.out.println("Digite sua opção: (Ex: 1,2,...)");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    funcionarios.get(indexFuncionarioSelecionado).baterPonto();
                    break;
                case 2:
                    funcionarios.get(indexFuncionarioSelecionado).fazerTarefa();
                    break;
                default:
                    System.out.println("Operação cancelada");
                    break;
            }
        } else {
            System.out.println("1- Bater Ponto");
            int opcao = scan.nextInt();
            scan.nextLine();
            if (opcao == 1) {
                funcionarios.get(indexFuncionarioSelecionado).baterPonto();
            } else {
                System.out.println("Operação cancelada");
            }
        }
    }
    public boolean verificaCpf(String cpf){
        // 999.999.999-99
        try {
            String[] cpfDividido = cpf.split("\\.");
            if(cpfDividido[0].length() == 3 && cpfDividido[1].length() == 3){
                String[] cpfUltimoIndex = cpfDividido[2].split("-");
                if(cpfUltimoIndex[0].length() == 3 && cpfUltimoIndex[1].length() == 2){
                    return true;
                }else{
                    return false;
                }           
            }else{
                return false;
            }
            
        } catch (Exception erro) {
            return false;
        }
    }

    public boolean verificaData(String data){
        // dd/mm/aaaa
        String[] dataDividida = data.split("/");
        if(dataDividida[0].length() == 2 && dataDividida[1].length() == 2 && dataDividida[2].length() == 4 ){
            int[] numerosDaData = new int[3];
            int valorData;

            for(int i = 0; i < dataDividida.length; i++){
                try{
                    valorData = Integer.parseInt(dataDividida[i]);
                } catch (Exception error) {
                    return false;
                }
                numerosDaData[i] = valorData;
            }

            if(numerosDaData[0] > 31 || numerosDaData[0] < 0 || numerosDaData[1] > 12 || numerosDaData[1] < 1 || numerosDaData[2] > 2025){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public boolean verificaDados(String cpf, String dataNascimento, String nome, double salario,
     String departamento, String cargo){
        
        System.out.println("Os dados a seguir estão corretos: (S/N)");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: "+ cpf);
        System.out.println("Data de Nascimento: "+ dataNascimento);
        System.out.printf("Salário: R$%.2f\n", salario);
        System.out.println("Departamento: " + departamento);
        System.out.println("Cargo: "+ cargo);
        String resposta = scan.nextLine().toLowerCase();
        switch(resposta){
            case "s":
                return true;
            case "n": 
            default:
                return false;
        }
    }

    public boolean verificaDados(String cpf, String dataNascimento, String nome, double salario,
    String departamento, String cargo, String[] linguagensDeProg){

        System.out.println("Os dados a seguir estão corretos: (S/N)");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: "+ cpf);
        System.out.println("Data de Nascimento: "+ dataNascimento);
        System.out.printf("Salário: R$%.2f\n", salario);
        System.out.println("Departamento: " + departamento);
        System.out.println("Cargo: "+ cargo);
        System.out.println("Linguagens de programação: ");
        for(String linguagem : linguagensDeProg ){
            System.out.println("    - "+linguagem);
        }
        String resposta = scan.nextLine().toLowerCase();
        switch(resposta){
            case "s":
                return true;
            case "n": 
            default:
                return false;
        }
    }
}
