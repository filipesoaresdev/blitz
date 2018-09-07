package br.gov.pi.detran.ouvidoria.modelo.controleacesso;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Index;

/**
 *
 * @author ayslan
 */
@Entity
public class AcessoSistema implements Serializable {

    @Id
    @SequenceGenerator(name = "AcessoSistema", allocationSize = 1, sequenceName = "acessosistema_id_seq")
    @GeneratedValue(generator = "AcessoSistema")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Size(max = 150)
    private String ip;

    @Size(max = 250)
    private String userAgent;

    @Index(name = "idx_acesso_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
