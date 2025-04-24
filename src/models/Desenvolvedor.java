package src.models;

import java.util.Scanner;

public class Desenvolvedor extends Funcionario {
    private String[] linguagens;
    public Desenvolvedor(String cpf, String dataNascimento, String nome, double salario, String departamento, String[] linguagens){
        super(cpf, dataNascimento, nome, salario, departamento, "Desenvolvedor");
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
        System.out.println("CPF: "+ super.getCpf());
        System.out.println("Data de Nascimento: "+ super.getNascimento());
        System.out.printf("Salário: R$%.2f\n", super.getSalario());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Cargo: Desenvolvedor");
        System.out.println("Linguagens de programação: ");
        for(String ling : linguagens){
            System.out.println(ling);
        }
    }

    @Override
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
            
            if(numLinguagem > linguagens.length  || numLinguagem < 0){
                System.out.println("Opção inválida");
            }else{
                String linguagem = linguagens[numLinguagem - 1];
                System.out.printf("%sestá a programar em %s\n",super.getNome(),linguagem);
                break;
            }
        } while (true);
    }
}
