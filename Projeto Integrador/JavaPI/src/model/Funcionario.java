package model;
public class Funcionario {
    private int id;
    private String nome;
    private String rgf;
    private String rg;
    private String cpf;
    public Funcionario() {
    }
    public Funcionario(int id, String nome, String rgf, String rg, String cpf) {
        this.id = id;
        this.nome = nome;
        this.rgf = rgf;
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRgf() {
        return rgf;
    }

    public void setRgf(String rgf) {
        this.rgf = rgf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

