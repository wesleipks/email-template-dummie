package br.com.wes.emailtemplatedummie.service;

import br.com.wes.emailtemplatedummie.dto.Cliente;
import br.com.wes.emailtemplatedummie.dto.TemplateCliente;
import br.com.wes.emailtemplatedummie.util.TemplatesSamples;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Service
public class EmailService {

    private static final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

    @Value("${email.to}")
    private String to;

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail() {
        mailSender.send(criarDadosEmail());
    }

    public MimeMessagePreparator criarDadosEmail() {
        return (MimeMessage mimeMessage) -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());
            message.setSubject("Assunto Qualquer!");
            message.setText(definirConteudoTemplate(), true);
            message.setSentDate(new Date());
            message.setTo(to);
            message.setFrom("noreply@demomailtrap.com");
        };
    }

    private String definirConteudoTemplate() {
        ST st = new ST(TemplatesSamples.ANTLR_ST4_FULL_TEMPLATE, '$', '$');
//        setMapParameters(st);
        setObjectParameters(st);

        String retorno = st.render();
        LOGGER.info(retorno);
        return retorno;
    }

    private void setMapParameters(ST st) {
        Map<String, Object> param = new HashMap<>();
        param.put("date", new Date());
        param.put("nomeGestor", "fulano");
        param.put("cliente", getClientes());

        param.forEach(st::add);
    }

    private void setObjectParameters(ST st) {
        TemplateCliente templateCliente = new TemplateCliente("Fulano da Silva", getClientes());
        Map<String, Object> param = new ObjectMapper()
                .convertValue(templateCliente, new TypeReference<>() {});

        param.forEach(st::add);
    }

    private List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        var nomes = Arrays.asList("Fulano Silva", "Ciclano Souza", "Beltrano Passos");
        for (var c : nomes) {
            Cliente cliente = new Cliente();
            cliente.setNomeCliente(c);
            cliente.setDataVencimento(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            cliente.setNomeInstituicao("Instituicao Qualquer");
            cliente.setTipoOperacao("Crédito/Empréstimo/Etc.");
            cliente.setSubtipoOperacao("Pagamento de boleto");
            cliente.setValorContratacao("R$ 100,00");
            cliente.setSaldoDevedor("R$ 0,01");

            clientes.add(cliente);
        }
        return clientes;
    }
}
