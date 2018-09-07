/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.local;

import br.gov.pi.detran.blitz.enums.Autuador;
import br.gov.pi.detran.blitz.enums.Procedimento;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jonny
 */
@Entity
public class AutoBlitz implements Serializable {
    @Id
    @SequenceGenerator(name = "AutoBlitz", allocationSize = 1, sequenceName = "autoblitz_id_seq")
    @GeneratedValue(generator = "AutoBlitz")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private Autuador autuador;
    private String codOrgaoAutuador;
    private Long numAuto;
    private String letraNumAuto;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    private VeiculoBlitz veiculoBlitz;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private VeiculoExternoBlitz veiculoExternoBlitz;
    
    //Dados Condutor
    private String nomeCondutor;
    private String logradouroCondutor;
    private String numeroCondutor;
    private String bairroCondutor;
    private String complemento;
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoBlitz estadoCondutor;
    private String municipioCondutor;
    private String numeroCNHCondutor;
    private String cepCondutor;
    private String rgCondutor;
    private String orgaoExpedidorCondutor;
    private String ufCondutor;
    private String cpfCnpjCondutor;
    
    //Local Infracao
    @NotBlank
    private String localInfracao;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInfracao;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private MunicipioBlitz municipioInfracao;
    
    //Dados da Autuação
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private InfracaoBlitz infracaoBlitz;
    private String medicao;
    private String limiteLegalPermitido;
    private String valorConsiderado;
    private String tipoMedicao;
    private String equipamentoMedicao;
    private String observacoes;
    
    @NotNull
    private Procedimento procedimentoAdotado;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario agente;
    private String assinaturaCondutor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    public Autuador getAutuador() {
        return autuador;
    }

    public void setAutuador(Autuador autuador) {
        this.autuador = autuador;
    }

    public String getCodOrgaoAutuador() {
        return codOrgaoAutuador;
    }

    public void setCodOrgaoAutuador(String codOrgaoAutuador) {
        this.codOrgaoAutuador = codOrgaoAutuador;
    }

    public Long getNumAuto() {
        return numAuto;
    }

    public void setNumAuto(Long numAuto) {
        this.numAuto = numAuto;
    }


    public VeiculoBlitz getVeiculoBlitz() {
        return veiculoBlitz;
    }

    public void setVeiculoBlitz(VeiculoBlitz veiculoBlitz) {
        this.veiculoBlitz = veiculoBlitz;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    public String getLogradouroCondutor() {
        return logradouroCondutor;
    }

    public void setLogradouroCondutor(String logradouroCondutor) {
        this.logradouroCondutor = logradouroCondutor;
    }

    public String getNumeroCondutor() {
        return numeroCondutor;
    }

    public void setNumeroCondutor(String numeroCondutor) {
        this.numeroCondutor = numeroCondutor;
    }

    public String getBairroCondutor() {
        return bairroCondutor;
    }

    public void setBairroCondutor(String bairroCondutor) {
        this.bairroCondutor = bairroCondutor;
    }

    public EstadoBlitz getEstadoCondutor() {
        return estadoCondutor;
    }

    public void setEstadoCondutor(EstadoBlitz estadoCondutor) {
        this.estadoCondutor = estadoCondutor;
    }

    public String getMunicipioCondutor() {
        return municipioCondutor;
    }

    public void setMunicipioCondutor(String municipioCondutor) {
        this.municipioCondutor = municipioCondutor;
    }


    public String getNumeroCNHCondutor() {
        return numeroCNHCondutor;
    }

    public void setNumeroCNHCondutor(String numeroCNHCondutor) {
        this.numeroCNHCondutor = numeroCNHCondutor;
    }

    public String getCepCondutor() {
        return cepCondutor;
    }

    public void setCepCondutor(String cepCondutor) {
        this.cepCondutor = cepCondutor;
    }

    public String getRgCondutor() {
        return rgCondutor;
    }

    public void setRgCondutor(String rgCondutor) {
        this.rgCondutor = rgCondutor;
    }

    public String getOrgaoExpedidorCondutor() {
        return orgaoExpedidorCondutor;
    }

    public void setOrgaoExpedidorCondutor(String orgaoExpedidorCondutor) {
        this.orgaoExpedidorCondutor = orgaoExpedidorCondutor;
    }

    public String getUfCondutor() {
        return ufCondutor;
    }

    public void setUfCondutor(String ufCondutor) {
        this.ufCondutor = ufCondutor;
    }

    public String getCpfCnpjCondutor() {
        return cpfCnpjCondutor;
    }

    public void setCpfCnpjCondutor(String cpfCnpjCondutor) {
        this.cpfCnpjCondutor = cpfCnpjCondutor;
    }

    public String getAssinaturaCondutor() {
        return assinaturaCondutor;
    }

    public void setAssinaturaCondutor(String assinaturaCondutor) {
        this.assinaturaCondutor = assinaturaCondutor;
    }

    public String getLocalInfracao() {
        return localInfracao;
    }

    public void setLocalInfracao(String localInfracao) {
        this.localInfracao = localInfracao;
    }

    public Date getDataInfracao() {
        return dataInfracao;
    }

    public void setDataInfracao(Date dataInfracao) {
        this.dataInfracao = dataInfracao;
    }

    public MunicipioBlitz getMunicipioInfracao() {
        return municipioInfracao;
    }

    public void setMunicipioInfracao(MunicipioBlitz municipioInfracao) {
        this.municipioInfracao = municipioInfracao;
    }

    public InfracaoBlitz getInfracaoBlitz() {
        return infracaoBlitz;
    }

    public void setInfracaoBlitz(InfracaoBlitz infracaoBlitz) {
        this.infracaoBlitz = infracaoBlitz;
    }

    public String getMedicao() {
        return medicao;
    }

    public void setMedicao(String medicao) {
        this.medicao = medicao;
    }

    public String getLimiteLegalPermitido() {
        return limiteLegalPermitido;
    }

    public void setLimiteLegalPermitido(String limiteLegalPermitido) {
        this.limiteLegalPermitido = limiteLegalPermitido;
    }

    public String getValorConsiderado() {
        return valorConsiderado;
    }

    public void setValorConsiderado(String valorConsiderado) {
        this.valorConsiderado = valorConsiderado;
    }

    public String getTipoMedicao() {
        return tipoMedicao;
    }

    public void setTipoMedicao(String tipoMedicao) {
        this.tipoMedicao = tipoMedicao;
    }

    public String getEquipamentoMedicao() {
        return equipamentoMedicao;
    }

    public void setEquipamentoMedicao(String equipamentoMedicao) {
        this.equipamentoMedicao = equipamentoMedicao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Procedimento getProcedimentoAdotado() {
        return procedimentoAdotado;
    }

    public void setProcedimentoAdotado(Procedimento procedimentoAdotado) {
        this.procedimentoAdotado = procedimentoAdotado;
    }


    public Usuario getAgente() {
        return agente;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }

    public VeiculoExternoBlitz getVeiculoExternoBlitz() {
        return veiculoExternoBlitz;
    }

    public void setVeiculoExternoBlitz(VeiculoExternoBlitz veiculoExternoBlitz) {
        this.veiculoExternoBlitz = veiculoExternoBlitz;
    }

    public String getLetraNumAuto() {
        return letraNumAuto;
    }

    public void setLetraNumAuto(String letraNumAuto) {
        this.letraNumAuto = letraNumAuto;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AutoBlitz other = (AutoBlitz) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    

    
}