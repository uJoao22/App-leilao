package br.com.selecao.locadora.entity;

import br.com.selecao.locadora.entity.listener.LoteListener;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lote")
@EntityListeners({LoteListener.class})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SequenceGenerator(name = "seq_lote", sequenceName = "seq_lote", allocationSize = 1)
public class Lote implements Serializable {

  @Id
  @EqualsAndHashCode.Include
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_lote")
  private Long id;

  @Column(name = "numero_lote")
  private Integer numeroLote;

  @NonNull
  @Column(name = "descricao", length = 60, nullable = false)
  private String descricao;

  @NonNull
  @Column(name = "quantidade", nullable = false)
  private Double quantidade;

  @Column(name = "valor_inicial")
  private Double valorInicial;

  @NonNull
  @Column(name = "unidade", length = 128, nullable = false)
  private String unidade;

  @NonNull
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_leilao", referencedColumnName = "id", nullable = false)
  private Leilao leilao;

  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;
}
