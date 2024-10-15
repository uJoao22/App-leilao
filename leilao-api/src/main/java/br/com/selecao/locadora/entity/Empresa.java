package br.com.selecao.locadora.entity;

import br.com.selecao.locadora.entity.listener.EmpresaListener;
import br.com.selecao.locadora.entity.listener.LoteListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
import javax.persistence.OneToOne;
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
@Table(name = "empresa")
@EntityListeners({EmpresaListener.class})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa", allocationSize = 1)
public class Empresa implements Serializable {

  @Id
  @EqualsAndHashCode.Include
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_empresa")
  private Long id;

  @NonNull
  @Column(name = "razao_social", length = 64, nullable = false)
  private String razaoSocial;

  @NonNull
  @Column(name = "cnpj", length = 32, nullable = false, unique = true)
  private String cnpj;

  @NonNull
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_endereco", referencedColumnName = "id", nullable = false)
  private Endereco endereco;

  @Column(name = "telefone", length = 32)
  private String telefone;

  @NonNull
  @Column(name = "email", length = 254, nullable = false)
  private String email;

  @Column(name = "site", length = 254)
  private String site;

  @NonNull
  @Column(name = "usuario", length = 20, nullable = false, unique = true)
  private String usuario;

  @Column(name = "senha", length = 128)
  private String senha;

  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;
}
