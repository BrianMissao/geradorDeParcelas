package dominio.entidades;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private Integer numero;
    private Date dataDeVencimento;
    private BigDecimal valorTotal;

    public Parcela(Integer numero, Date dataDeVencimento, BigDecimal valorTotal) {
        this.numero = numero;
        this.dataDeVencimento = dataDeVencimento;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return dataFormatada.format(dataDeVencimento) + " - " + valorTotal;
    }

    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Integer getNumero() {
        return numero;
    }
}
