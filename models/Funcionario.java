package models;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private double salario;
    private String departamento;
    public ArrayList<Array> pontos = new ArrayList<Array>();

    public Funcionario(String nome, double salario, String departamento){
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
        System.out.println("Nome: " + this.nome);
        System.out.println("Salario: " + this.salario);
        System.out.println("Nome: " + this.nome);
    }

    public void baterPonto(){
        LocalTime tempo = LocalTime.now();
        DateTimeFormatter modeloTempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String ponto = tempo.format(modeloTempo);
        int tamanhoArray = pontos.size();

        if(pontos.get(tamanhoArray - 1)[1].equals("entrada")){

        } 
    }
}
