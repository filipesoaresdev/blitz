/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.local;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author filipe
 */
@Entity
@Table(name = "veiculo")
public class VeiculoBlitz implements Serializable {

    @Id
    private Long id;
    private String chassi;
    private String placa;
    private String renavam;
    private Integer anoExercicio;
    private Integer anoFabricacao;
    private String ufPlaca;
    @ManyToOne(fetch = FetchType.LAZY)
    private MunicipioBlitz municipioBlitz;
    @ManyToOne(fetch = FetchType.LAZY)
    private MunicipioBlitz municipioProprietario;
    @ManyToOne(fetch = FetchType.LAZY)
    private CorBlitz cor;
    @ManyToOne(fetch = FetchType.LAZY)
    private MarcaModeloBlitz marcaModelo;
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaBlitz categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    private EspecieBlitz especie;
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoVeiculoBlitz tipoVeiculoBlitz;
    
//Endereco
    private String nomeProprietario;
    private String cpf;
    private String bairroProprietario;
    private String complementoProprietario;
    private String cepProprietario;
    private String numeroImovelProprietario;
    private String rgProprietario;
    private String logradouroProprietario;
    
    public VeiculoBlitz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUfPlaca() {
        return ufPlaca;
    }

    public void setUfPlaca(String ufPlaca) {
        this.ufPlaca = ufPlaca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getAnoExercicio() {
        return anoExercicio;
    }

    public void setAnoExercicio(Integer anoExercicio) {
        this.anoExercicio = anoExercicio;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public MunicipioBlitz getMunicipioBlitz() {
        return municipioBlitz;
    }

    public void setMunicipioBlitz(MunicipioBlitz municipioBlitz) {
        this.municipioBlitz = municipioBlitz;
    }

    public CorBlitz getCor() {
        return cor;
    }

    public void setCor(CorBlitz cor) {
        this.cor = cor;
    }

    public MarcaModeloBlitz getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(MarcaModeloBlitz marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public CategoriaBlitz getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBlitz categoria) {
        this.categoria = categoria;
    }

    public EspecieBlitz getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieBlitz especie) {
        this.especie = especie;
    }

    public TipoVeiculoBlitz getTipoVeiculoBlitz() {
        return tipoVeiculoBlitz;
    }

    public void setTipoVeiculoBlitz(TipoVeiculoBlitz tipoVeiculoBlitz) {
        this.tipoVeiculoBlitz = tipoVeiculoBlitz;
    }

    public String getBairroProprietario() {
        return bairroProprietario;
    }

    public void setBairroProprietario(String bairroProprietario) {
        this.bairroProprietario = bairroProprietario;
    }

    public String getComplementoProprietario() {
        return complementoProprietario;
    }

    public void setComplementoProprietario(String complementoProprietario) {
        this.complementoProprietario = complementoProprietario;
    }

    public String getCepProprietario() {
        return cepProprietario;
    }

    public void setCepProprietario(String cepProprietario) {
        this.cepProprietario = cepProprietario;
    }

    public String getNumeroImovelProprietario() {
        return numeroImovelProprietario;
    }

    public void setNumeroImovelProprietario(String numeroImovelProprietario) {
        this.numeroImovelProprietario = numeroImovelProprietario;
    }

    public String getRgProprietario() {
        return rgProprietario;
    }

    public void setRgProprietario(String rgProprietario) {
        this.rgProprietario = rgProprietario;
    }

    public MunicipioBlitz getMunicipioProprietario() {
        return municipioProprietario;
    }

    public void setMunicipioProprietario(MunicipioBlitz municipioProprietario) {
        this.municipioProprietario = municipioProprietario;
    }

    public String getLogradouroProprietario() {
        return logradouroProprietario;
    }

    public void setLogradouroProprietario(String logradouroProprietario) {
        this.logradouroProprietario = logradouroProprietario;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final VeiculoBlitz other = (VeiculoBlitz) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}