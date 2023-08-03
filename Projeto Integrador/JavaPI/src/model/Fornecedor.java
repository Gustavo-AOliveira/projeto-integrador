package model;

public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    private String ie;
    private String endereco;
    private String cep;

    public Fornecedor() {
    }
    public Fornecedor(int id, String nome,String cnpj, String ie, String endereco, String cep) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.ie = ie;
        this.endereco = endereco;
        this.cep = cep;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getcep() {
        return cep;
    }

    public void setcep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
