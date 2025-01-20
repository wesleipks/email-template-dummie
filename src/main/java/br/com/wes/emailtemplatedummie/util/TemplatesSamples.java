package br.com.wes.emailtemplatedummie.util;

@SuppressWarnings("unused")
public class TemplatesSamples {

    private TemplatesSamples() {
        super();
    }

    public static final String ANTLR_ST4_TEMPLATE_LISTA = "$lista:{x | [$x$]}; separator=\"<br/> \"$";

    public static final String ANTLR_ST4_FULL_TEMPLATE = "<p>Prezado(a) $nomeGestor$,</p> " +
            "<p>Espero que esteja bem.</p> " +
            "<p>Identificamos que alguns clientes sob sua gest&atilde;o possuem opera&ccedil;&otilde;es de cr&eacute;dito que est&atilde;o pr&oacute;ximas do vencimento em outras institui&ccedil;&otilde;es financeiras. Esse &eacute; um momento oportuno para abord&aacute;-los, com o objetivo de oferecer condi&ccedil;&otilde;es competitivas e atra&iacute;-los para realizar suas opera&ccedil;&otilde;es conosco.</p> " +
            "<p>Segue abaixo a lista dos clientes e as respectivas informa&ccedil;&otilde;es sobre as opera&ccedil;&otilde;es:</p> " +
            "<p></p> " +
            "$clientes:{c |  " +
            "<p>$i$. Cliente: $c.nomeCliente$</p> " +
            "<p>Opera&ccedil;&atilde;o: $c.tipoOperacao$</p> " +
            "<p>Subtipo Opera&ccedil;&atilde;o: $c.subtipoOperacao$</p> " +
            "<p>Valor Contratado da Opera&ccedil;&atilde;o: $c.valorContratacao$</p> " +
            "<p>Saldo Devedor da Opera&ccedil;&atilde;o: $c.saldoDevedor$</p> " +
            "<p>Institui&ccedil;&atilde;o: $c.nomeInstituicao$</p> " +
            "<p>Data de Vencimento: $c.dataVencimento$</p> " +
            "}; separator=\"<p></p> \"$ " +
            "<p></p> " +
            "<p>Este &eacute; um excelente momento para contato, oferecendo taxas mais competitivas, pacotes de benef&iacute;cios ou outros incentivos que possam ser vantajosos para os clientes em compara&ccedil;&atilde;o com as condi&ccedil;&otilde;es oferecidas pela outra institui&ccedil;&atilde;o.</p> " +
            "<p></p> " +
            "<p>Mais informa&ccedil;&otilde;es sobre as opera&ccedil;&otilde;es de cr&eacute;dito em outras institui&ccedil;&otilde;es banc&aacute;rias est&atilde;o dispon&iacute;veis no Vis&atilde;o Open Finance: https://s643-portal-negocios.prd.ocp.capgv.intra.bnb/</p> " +
            "<p></p> " +
            "<p>Por favor, fique &agrave; vontade para solicitar suporte adicional ou informa&ccedil;&otilde;es complementares para facilitar essas negocia&ccedil;&otilde;es para equipe do Open Finance.</p> " +
            "<p></p> " +
            "<p>Atenciosamente,</p> " +
            "<p>Projeto Open Finance Banco do Nordeste</p>" +
            "<p>$date$</p>";

}
