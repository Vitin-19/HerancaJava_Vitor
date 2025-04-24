package src.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gerente extends Funcionario{

    public Gerente(String cpf, String dataNascimento, String nome, double salario, String departamento){
        super(cpf, dataNascimento, nome, salario, departamento, "Gerente");
    }

    @Override
    public void realizarReuniao(){
        LocalDateTime tempoAtual = LocalDateTime.now();
        DateTimeFormatter modeloTempo = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter modeloDia = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        String tempo = tempoAtual.format(modeloTempo);
        String dia = tempoAtual.format(modeloDia);

        System.out.printf("\nReunião iniciada às %s do dia %s\n",tempo,dia);
    }

    @Override
    public void mostrarDados(){
        System.out.println("Nome: " + super.getNome());
        System.out.println("CPF: "+ super.getCpf());
        System.out.println("Data de Nascimento: "+ super.getNascimento());
        System.out.printf("Salário: R$%.2f\n", super.getSalario());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Cargo: Gerente");
    }
}
