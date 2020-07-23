package aplicacao.servicos;

import java.math.BigDecimal;

public interface ServicoDePagamentoOnline {
    public BigDecimal calcularJurosMensais(BigDecimal valorDoPagamento, Integer quantidadeDeMeses);
    public BigDecimal calcularTaxaDePagamento(BigDecimal valorDoPagamento);

}
