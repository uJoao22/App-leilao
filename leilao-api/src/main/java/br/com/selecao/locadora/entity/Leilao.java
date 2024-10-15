package br.com.selecao.locadora.entity;

import br.com.selecao.locadora.entity.listener.LeilaoListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Transient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leilao")
@EntityListeners({LeilaoListener.class})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SequenceGenerator(name = "seq_leilao", sequenceName = "seq_leilao", allocationSize = 1)
public class Leilao implements Serializable {

  @Id
  @EqualsAndHashCode.Include
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_leilao")
  private Long id;

  @Column(name = "codigo")
  private Integer codigo;

  @NonNull
  @Column(name = "descricao", length = 60, nullable = false)
  private String descricao;

  @NonNull
  @Column(name = "vendedor", nullable = false)
  private Integer vendedor;

  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "inicio_previsto", nullable = false)
  private Date inicioPrevisto;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;

  @JsonManagedReference
  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "leilao")
  private List<Lote> lotes;

  @Transient
  public double getValorTotal() {
    if (lotes == null || lotes.isEmpty())
      return 0;

    return lotes.stream().mapToDouble(l -> l.getValorInicial() * l.getQuantidade()).sum();
  }
}
