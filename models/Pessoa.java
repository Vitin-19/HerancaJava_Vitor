package models;

public class Pessoa {
    private String cpf;
    private String dataNascimento;

    public Pessoa(String cpf, String dataNascimento){
        setCpf(cpf);
        setNascimento(dataNascimento);
    }

    // Métodos get
    public String getCpf(){
        return this.cpf;
    }
    public String getNascimento(){
        return this.dataNascimento;
    }

    // Métodos Set
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setNascimento(String nascimento){
        this.dataNascimento = nascimento;
    }
}
