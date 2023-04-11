package pt.amane.condominium_fee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.math.BigDecimal;


@Entity
public class Titulo {

   @Id
   @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long codigo;
    private String descricao;
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimento;
    private BigDecimal valor;
    @javax.persistence.Enumerated(javax.persistence.EnumType.STRING)
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

    public pt.amane.condominium_fee.model.StatusTitulo getStatus() {
        return status;
    }

    public void setStatus(pt.amane.condominium_fee.model.StatusTitulo status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pt.amane.condominium_fee.model.Titulo)) return false;
        pt.amane.condominium_fee.model.Titulo titulo = (pt.amane.condominium_fee.model.Titulo) o;
        return java.util.Objects.equals(codigo, titulo.codigo) && java.util.Objects.equals(descricao, titulo.descricao) && java.util.Objects.equals(dataVencimento, titulo.dataVencimento) && java.util.Objects.equals(valor, titulo.valor) && status == titulo.status;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(codigo, descricao, dataVencimento, valor, status);
    }
}
