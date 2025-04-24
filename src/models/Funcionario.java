package src.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private String nome;
    private double salario;
    private String departamento;
    private String cargo;
    public ArrayList<String[]> pontos = new ArrayList<String[]>();

    public Funcionario(String cpf, String dataNascimento, String nome, double salario, String departamento, String cargo){
        super(cpf, dataNascimento);
        setNome(nome);
        setSalario(salario);
        setDepartamento(departamento);
        setCargo(cargo);
    }
    
    public void setNome(String nomeCompleto){
        String[] nomeSeparado = nomeCompleto.split(" ");
        StringBuilder nomeCorrigido = new StringBuilder();
        for(String nome : nomeSeparado){
            String charCorrigido = ("" + nome.charAt(0)).toUpperCase();
            String parteNome = nome.substring(1);
            nome = null;
            nome = charCorrigido + parteNome + " ";
            nomeCorrigido.append(nome);
        }
        nomeCompleto = nomeCorrigido.toString();

        this.nome = nomeCompleto;
    }
    public String getNome(){
        return nome;
    }


    public void setSalario(double salario){
        this.salario = salario;
    }
    public double getSalario(){
        return this.salario;
    }
    

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    public String getDepartamento(){
        return this.departamento;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public String getCargo(){
        return this.cargo;
    }

    public void mostrarDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: "+ super.getCpf());
        System.out.println("Data de Nascimento: "+ super.getNascimento());
        System.out.printf("Salario: R$ %.2f \n", getSalario());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Cargo: " + getCargo());
    }

    public void baterPonto(){
        if(!pontos.isEmpty()){
            LocalDateTime tempo = LocalDateTime.now();
            DateTimeFormatter modeloTempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String ponto = tempo.format(modeloTempo);
            int tamanhoArray = pontos.size();
            String[] ultimoPonto = pontos.get(tamanhoArray - 1);

            if(ultimoPonto[1].equals("entrada")){
                String[] novoPonto = {ponto,"saída"};
                pontos.add(novoPonto);
                System.out.printf("\n%s: %s\n",novoPonto[1].toUpperCase(),novoPonto[0]);
            }else{
                String[] novoPonto = {ponto,"entrada"};
                pontos.add(novoPonto);
                System.out.printf("\n%s: %s\n",novoPonto[1].toUpperCase(),novoPonto[0]);
            } 
        }else{
            LocalDateTime tempo = LocalDateTime.now();
            DateTimeFormatter modeloTempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String ponto = tempo.format(modeloTempo);
            String[] novoPonto = {ponto,"entrada"};
            pontos.add(novoPonto);
            System.out.printf("\n%s: %s\n",novoPonto[1].toUpperCase(),novoPonto[0]);
        }
    }

    public void realizarReuniao(){}
    public void fazerTarefa(){}
    public void programar(){}
}
