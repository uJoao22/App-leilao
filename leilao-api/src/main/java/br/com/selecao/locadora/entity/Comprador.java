package br.com.selecao.locadora.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comprador")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Comprador implements Serializable {

  @EmbeddedId
  private CompradorId id;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_empresa", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
  private Empresa empresa;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_leilao", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
  private Leilao leilao;

  @Data
  @Embeddable
  @NoArgsConstructor
  @AllArgsConstructor
  public static class CompradorId implements Serializable {

    @NonNull
    @Column(name = "id_empresa", nullable = false)
    private Long idEmpresa;

    @NonNull
    @Column(name = "id_leilao", nullable = false)
    private Long idLeilao;
  }
}