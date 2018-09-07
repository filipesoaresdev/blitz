/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.geral;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jonny
 */
@Entity
@Table(name = "veiculos")
public class Veiculo implements Serializable {

    @Column(name = "codVeiculo", columnDefinition = "int")
    @Id
    private Integer id;
    @Column(name = "placa", columnDefinition = "varchar(50)")
    private String placa;
    @Column(name = "renavam", columnDefinition = "varchar(50)")
    private String renavam;
    @Column(name = "chassi", columnDefinition = "varchar(100)")
    private String chassi;
    @Column(name = "exercicio_atual", columnDefinition = "int")
    private Integer anoExercicio;
    @Column(name = "ano_fabricacao", columnDefinition = "int")
    private Integer anoFabricacao;
    @Column(name = "nome_proprietario", columnDefinition = "varchar(500)")
    private String nomeProprietario;
    @Column(name = "cpf_cnpj", columnDefinition = "varchar(50)")
    private String cpf_cnpj;
    @Column(name = "bairro_imovel_proprietario", columnDefinition = "varchar(100)")
    private String bairroProprietario;
    @Column(name = "complemento_imovel_proprietario", columnDefinition = "varchar(50)")
    private String complementoProprietario;
    @Column(name = "cep_imovel_proprietario", columnDefinition = "varchar(50)")
    private String cepProprietario;
    @Column(name = "numero_imovel_proprietario", columnDefinition = "varchar(50)")
    private String numeroImovelProprietario;
    @Column(name = "rg_proprietario", columnDefinition = "varchar(50)")
    private String rgProprietario;
    @Column(name = "nome_logradouro_proprietario", columnDefinition = "varchar(100)")
    private String logradouroProprietario;
    @Column(name = "data_ultimo_processamento", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date dataUltimoProcessamento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_municipio_proprietario", columnDefinition = "int", referencedColumnName = "idMunicipio")
    private Municipio municipioProprietario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_municipio_emplacamento", columnDefinition = "int", referencedColumnName = "idMunicipio")
    private Municipio municipioEmplacamento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cor", columnDefinition = "int", referencedColumnName = "cod")
    private Cor cor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_marca_modelo", columnDefinition = "int", referencedColumnName = "codigo")
    private MarcaModelo marcaModelo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_categoria_veiculo", columnDefinition = "int", referencedColumnName = "codigo")
    private Categoria categoria;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_especie_veiculo", columnDefinition = "int", referencedColumnName = "cod")
    private Especie especie;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_tipo_veiculo", columnDefinition = "int", referencedColumnName = "codigo")
    private TipoVeiculo tipoVeiculo;
  

    public Veiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDataUltimoProcessamento() {
        return dataUltimoProcessamento;
    }

    public void setDataUltimoProcessamento(Date dataUltimoProcessamento) {
        this.dataUltimoProcessamento = dataUltimoProcessamento;
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

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public MarcaModelo getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(MarcaModelo marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public Municipio getMunicipioProprietario() {
        return municipioProprietario;
    }

    public void setMunicipioProprietario(Municipio municipioProprietario) {
        this.municipioProprietario = municipioProprietario;
    }

    public Municipio getMunicipioEmplacamento() {
        return municipioEmplacamento;
    }

    public void setMunicipioEmplacamento(Municipio municipioEmplacamento) {
        this.municipioEmplacamento = municipioEmplacamento;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
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

    public String getLogradouroProprietario() {
        return logradouroProprietario;
    }

    public void setLogradouroProprietario(String logradouroProprietario) {
        this.logradouroProprietario = logradouroProprietario;
    }
    
    
}