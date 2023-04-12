package pt.amane.condominium_fee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Temporal;
import javax.persistence.*;


@Entity
public class Titulo {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descricao;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @org.springframework.format.annotation.NumberFormat(pattern = "#.##0.00")
    private BigDecimal valor;
    @javax.persistence.Enumerated(EnumType.STRING)
    private StatusTitulo status;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public java.util.Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(java.util.Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public java.math.BigDecimal getValor() {
        return valor;
    }

    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }

    public StatusTitulo getStatus() {
        return status;
    }

    public void setStatus(StatusTitulo status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Titulo)) return false;
        Titulo titulo = (Titulo) o;
        return java.util.Objects.equals(codigo, titulo.codigo) && java.util.Objects.equals(descricao, titulo.descricao) && java.util.Objects.equals(dataVencimento, titulo.dataVencimento) && java.util.Objects.equals(valor, titulo.valor) && status == titulo.status;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(codigo, descricao, dataVencimento, valor, status);
    }
}
