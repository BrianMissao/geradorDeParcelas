package aplicacao;

import aplicacao.servicos.ServicoDePagamentoOnline;
import dominio.entidades.Contrato;
import dominio.entidades.Parcela;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

public class ProcessadorDePagamentoDeContrato {
    private Contrato contrato;

    public ProcessadorDePagamentoDeContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public void processar(ServicoDePagamentoOnline servicoDePagamentoOnline, Integer quantidadeDeParcelas) {
        BigDecimal valorBaseDaParcela = contrato.getValor().divide(new BigDecimal(quantidadeDeParcelas)).setScale(2, RoundingMode.HALF_EVEN);
        for (Integer numeroDaParcela = 1; numeroDaParcela <= quantidadeDeParcelas; numeroDaParcela++) {
            BigDecimal valorTotalDaParcela = valorBaseDaParcela.add(servicoDePagamentoOnline.calcularTaxaDePagamento(valorBaseDaParcela));
            valorTotalDaParcela = valorTotalDaParcela.add(servicoDePagamentoOnline.calcularJurosMensais(valorTotalDaParcela, numeroDaParcela));
            Date dataDeVencimentoDaParcela = programarDataDeVencimentoDaParcela(contrato.getData(), numeroDaParcela);
            contrato.adicionarParcela(new Parcela(numeroDaParcela, dataDeVencimentoDaParcela, valorTotalDaParcela));
        }
    }

    private Date programarDataDeVencimentoDaParcela(Date dataDaParcela, int numeroDaParcela) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataDaParcela);
        calendar.add(Calendar.MONTH, numeroDaParcela);
        return calendar.getTime();
    }
}
