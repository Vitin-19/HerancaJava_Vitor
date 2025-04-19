package models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private String nome;
    private double salario;
    private String departamento;
    public ArrayList<String[]> pontos = new ArrayList<String[]>();

    public Funcionario(String nome, double salario, String departamento){
        super(nome, departamento);
        setNome(nome);
        setSalario(salario);
        setDepartamento(departamento);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }
    public double getSalario(){
        return salario;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    public String getDepartamento(){
        return departamento;
    }

    public void mostrarDados(){
        System.out.println("Nome: " + getNome());
        System.out.printf("Salario: R$ %.2f \n" + getSalario());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Cargo: Funcionário");
    }

    public void baterPonto(){
        LocalTime tempo = LocalTime.now();
        DateTimeFormatter modeloTempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String ponto = tempo.format(modeloTempo);
        int tamanhoArray = pontos.size();
        String[] ultimoPonto = pontos.get(tamanhoArray - 1);

        if(ultimoPonto[1].equals("entrada")){
            String[] novoPonto = {ponto,"saída"};
            pontos.add(novoPonto);
        }else{
            String[] novoPonto = {ponto,"entrada"};
            pontos.add(novoPonto);
        } 
    }
}
