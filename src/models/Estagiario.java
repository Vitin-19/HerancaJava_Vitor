package src.models;

import java.util.Scanner;

public class Estagiario extends Funcionario {
    public Estagiario(String cpf, String dataNascimento ,String nome, double salario, String departamento){
        super(cpf, dataNascimento, nome, salario, departamento, "Estagiario");
    }

    @Override
    public void mostrarDados(){
        System.out.println("Nome: " + super.getNome());
        System.out.println("CPF: "+ super.getCpf());
        System.out.println("Data de Nascimento: "+ super.getNascimento());
        System.out.printf("Salário: R$%.2f\n", super.getSalario());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Cargo: Estagiário");
    }

    @Override
    public void fazerTarefa(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome da tarefa: ");
        String tarefa = scan.nextLine();
        System.out.println("Digite uma descrição: ");
        String descricao = scan.nextLine();
        System.out.printf("\n%s está a fazer: %s\n", getNome(),tarefa);
        System.out.println("Descrição: ");
        System.out.println(descricao);
    }

}
