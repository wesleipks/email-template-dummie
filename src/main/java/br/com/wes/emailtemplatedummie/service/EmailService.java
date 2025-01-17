package br.com.wes.emailtemplatedummie.service;

import br.com.wes.emailtemplatedummie.dto.Cliente;
import br.com.wes.emailtemplatedummie.util.TemplatesSamples;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;

import java.nio.charset.StandardCharsets;
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
        Map<String, Object> param = new HashMap<>();
        param.put("date", new Date());
        param.put("nomeGestor", "fulano");
        param.put("cliente", getClientes());

        ST st = new ST(TemplatesSamples.FULL_TEMPLATE, '$', '$');
        param.forEach(st::add);

        String retorno = st.render();
        LOGGER.info(retorno);
        return retorno;
    }

    private List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Fulano", "00011122285"));
        clientes.add(new Cliente("Ciclano", "11122233396"));
        clientes.add(new Cliente("Beltrano", "2222333444"));
        return clientes;
    }
}
