package br.com.wes.emailtemplatedummie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TemplateCliente {

    @JsonProperty("nomeGestor")
    private String nomeGestor;
    @JsonProperty("clientes")
    private List<Cliente> clientes;
    @JsonProperty("date")
    private String dataHoraEnvio;

    public TemplateCliente(String nomeGestor, List<Cliente> clientes) {
        super();
        this.dataHoraEnvio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        this.nomeGestor = nomeGestor;
        this.clientes = clientes;
    }

    public String getNomeGestor() {
        return nomeGestor;
    }

    public void setNomeGestor(String nomeGestor) {
        this.nomeGestor = nomeGestor;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(String dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

}
