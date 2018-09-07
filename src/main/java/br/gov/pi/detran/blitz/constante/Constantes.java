package br.gov.pi.detran.blitz.constante;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author Ayslan
 */
public class Constantes {
    
    public static final Whitelist DEFAULT_WHITE_LIST;

    static {
        DEFAULT_WHITE_LIST = Whitelist.relaxed().addAttributes(":all", "style", "class", "href", "src");
        //hack para deixar acessar a url reativa para as imagens
        try {
            Field field = Whitelist.class.getDeclaredField("protocols");
            field.setAccessible(true);
            field.set(DEFAULT_WHITE_LIST, new HashMap());
        } catch (Exception ex) {
            Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static final String PERSISTENCE_UNIT_NAME_DETRANPI = "detranpiPU";
    public static final String PERSISTENCE_UNIT_NAME_BLITZ = "blitzPU";
    /**
     * Tipo para String sem tamanho definido.
     * Postgres: text
     * Oracle: clob
     * MySQL: longtext
     */
    public static final String TIPO_TEXTO_BANCO = "text";
    public static final int MINUTOS_VALIDADE_RECUPERACAO_SENHA = 30;
    public static final int TAMANHO_MAXIMO_ACIONAMENTO = 1000;

    
    /**
     * tamanho em MB
     */
    public static final Integer TAMANHO_ANEXO = 10;
    public static final String TIPO_ARQUIVOS_PERMITIDOS_ANEXO = "pdf,png,jpeg,doc,docx,txt,xls,xlsx";
    
    
    //SINCRONIZACAO VEICULOS
    public static final Integer QUANTIDADE_VEICULOS_CONSULTA = 25000;
    public static final Integer QUANTIDADE_VEICULOS_POR_THREAD = 5000;
    public static final Integer QUANTIDADE_THREADS_ATIVAS_MAX = 20;
    
    //Auto
    public static final String COD_ORGAO_AUTUADOR = "118100";
    public static final String LETRA_NUMERO_AUTO = "E";
    
    private Constantes() {
    }
}
