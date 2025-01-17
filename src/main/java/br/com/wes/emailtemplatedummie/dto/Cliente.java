package br.com.wes.emailtemplatedummie.dto;

public class Cliente {

    private String nomeCliente;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nomeCliente = nome;
        this.cpf = cpf;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nomeCliente + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
