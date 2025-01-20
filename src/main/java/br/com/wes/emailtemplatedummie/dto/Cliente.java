package br.com.wes.emailtemplatedummie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {

    @JsonProperty("nomeCliente")
    private String nomeCliente;
    @JsonProperty("tipoOperacao")
    private String tipoOperacao;
    @JsonProperty("subtipoOperacao")
    private String subtipoOperacao;
    @JsonProperty("valorContratacao")
    private String valorContratacao;
    @JsonProperty("saldoDevedor")
    private String saldoDevedor;
    @JsonProperty("nomeInstituicao")
    private String nomeInstituicao;
    @JsonProperty("dataVencimento")
    private String dataVencimento;

    public Cliente() {
        super();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getSubtipoOperacao() {
        return subtipoOperacao;
    }

    public void setSubtipoOperacao(String subtipoOperacao) {
        this.subtipoOperacao = subtipoOperacao;
    }

    public String getValorContratacao() {
        return valorContratacao;
    }

    public void setValorContratacao(String valorContratacao) {
        this.valorContratacao = valorContratacao;
    }

    public String getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(String saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
