package aplicacao.servicos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Paypal implements ServicoDePagamentoOnline {
private final BigDecimal porcentagemTaxa = new BigDecimal("0.02").setScale(2, RoundingMode.HALF_EVEN);
private final BigDecimal porcentagemJurosMensais = new BigDecimal("0.01").setScale(2, RoundingMode.HALF_EVEN);

    @Override
    public BigDecimal calcularTaxaDePagamento(BigDecimal valorDoPagamento) {
        return valorDoPagamento.multiply(porcentagemTaxa).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal calcularJurosMensais(BigDecimal valorDoPagamento, Integer quantidadeDeMeses) {
        return valorDoPagamento.multiply(porcentagemJurosMensais).multiply(new BigDecimal(quantidadeDeMeses)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
