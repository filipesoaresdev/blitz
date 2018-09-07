package br.gov.pi.detran.ouvidoria.modelo.email;

/**
 *
 * @author ayslan
 */
public enum TipoAssuntoEmail {

    RECUPERACAO_SENHA("Recuperação de Senha"),
    NOVO_USUARIO_SISTEMA("Novo Usuário no Sistema"),
    ACIONAMENTO_CADASTRADO("Acionamento Cadastrado"),
    ACIONAMENTO_RESPOSTA("Acionamento Resposta");

    private TipoAssuntoEmail(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
