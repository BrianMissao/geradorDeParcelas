package dominio.entidades;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Contrato {
    private int numero;
    private Date data;
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private BigDecimal valor;
    private List<Parcela> parcelas = new ArrayList<>();

    public Contrato(Integer numero, Date data, BigDecimal valor) {
        this.numero = numero;
        this.data = data;
        this.valor = valor;
    }

    public List<Parcela> getParcelas() {
        return Collections.unmodifiableList(parcelas);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*Dados do contrato\nNúmero: " + numero + "\nData: " + dataFormatada.format(data) + "\nValor: " + valor + "\n*Parcelas\n");
        for (Parcela parcela : parcelas) {
            stringBuilder.append(parcela+"\n");
        }
        return stringBuilder.toString();
    }

    public void adicionarParcela(Parcela parcela) {
        parcelas.add(parcela);
    }

    public Integer getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
