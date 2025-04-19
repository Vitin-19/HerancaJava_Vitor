package models;

public class Estagiario extends Funcionario {
    public Estagiario(String nome, double salario, String departamento){
        super(nome, salario, departamento);
    }

    @Override
    public void mostrarDados(){
        System.out.println("Nome: " + super.getNome());
        System.out.printf("Salário: R$%.2f", super.getSalario());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Cargo: Estagiário");
    }

    public void fazerTarefa(String Tarefa, String descricao){
        System.out.printf("%s está a fazer uma tarefa: ",super.getNome());
        System.out.println(Tarefa);
        System.out.println("Descrição: \n" + descricao);
    }

    public void fazerTarefa(String Tarefa){
        System.out.printf("%s está a fazer uma tarefa: ",super.getNome());
        System.out.println(Tarefa);
    }
}
