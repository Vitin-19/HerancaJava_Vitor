package models;

import java.util.Scanner;

public class Desenvolvedor extends Funcionario {
    private String[] linguagens;
    public Desenvolvedor(String nome, double salario, String departamento, String[] linguagens){
        super(nome, salario, departamento);
        setLinguagem(linguagens);
    }

    public String[] getLinguagem(){
        return linguagens;
    }
    public void setLinguagem(String[] linguagens){
        this.linguagens = linguagens;
    }

    @Override
    public void mostrarDados(){
        System.out.println("Nome: " + super.getNome());
        System.out.printf("Salário: R$%.2f", super.getSalario());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Cargo: Desenvolvedor");
        System.out.println("Linguagens de programação: ");
        for(String ling : linguagens){
            System.out.println(ling);
        }
    }

    public void programar(){
        Scanner scan = new Scanner(System.in);
        do { 
            System.out.println("Selecione uma linguagem para programar Ex: 1,2,3...");
            int i = 1;
            for(String ling : linguagens){
                System.out.printf("%d- %s\n", i, ling);
                i++;
            }
            int numLinguagem = scan.nextInt();
            try{
                String linguagem = linguagens[numLinguagem];
                System.out.printf("%s está a programar em %s",super.getNome(),linguagem);
                break;
            }catch(Exception erro){
                System.out.println("Selecione uma opção válida \n");
            }
        } while (true);
        scan.close();
    }
}
