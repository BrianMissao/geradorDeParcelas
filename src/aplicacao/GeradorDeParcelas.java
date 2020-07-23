package aplicacao;

import aplicacao.servicos.Paypal;
import dominio.entidades.Contrato;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GeradorDeParcelas {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private static Contrato contrato;

    public static void main(String[] args) throws ParseException {
        obterDadosDoContrato();
        Integer numeroDeParcelasDoContrato = Integer.valueOf(obterDados("Em quantas vezes este contrato será parcelado?"));
        new ProcessadorDePagamentoDeContrato(contrato).processar(new Paypal(), numeroDeParcelasDoContrato);
        System.out.println(contrato);
    }

    private static void obterDadosDoContrato() throws ParseException {
        System.out.println("Entre com os dados do contrato");
        Integer numeroDoContrato = Integer.valueOf(obterDados("Número:"));
        Date dataDoContrato = dataFormatada.parse(obterDados("Data (dd/mm/aa):"));
        BigDecimal valorTotalDoContrato = new BigDecimal(obterDados("Valor total:")).setScale(2, RoundingMode.HALF_EVEN);
        contrato = new Contrato(numeroDoContrato, dataDoContrato, valorTotalDoContrato);
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }
}
