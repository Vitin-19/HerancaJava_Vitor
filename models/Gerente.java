package models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Gerente extends Funcionario{

    public Gerente(String nome, double salario, String departamento){
        super(nome, salario, departamento);
    }

    public void realizarReuniao(){
        LocalTime tempoAtual = LocalTime.now();
        DateTimeFormatter modeloTempo = DateTimeFormatter.ofPattern("HHhmm");
        DateTimeFormatter modeloDia = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        String tempo = tempoAtual.format(modeloTempo);
        String dia = tempoAtual.format(modeloDia);

        System.out.printf("Reunião iniciada às %s do dia %s",tempo,dia);
    }

    @Override
    public void mostrarDados(){
        System.out.println("Nome: " + super.getNome());
        System.out.printf("Salário: R$%.2f", super.getSalario());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Cargo: Gerente");
    }
}
