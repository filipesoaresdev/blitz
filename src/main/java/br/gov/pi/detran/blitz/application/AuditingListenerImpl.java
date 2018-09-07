package br.gov.pi.detran.blitz.application;

import br.gov.pi.detran.blitz.mb.controleacesso.SessaoUsuarioMB;
import br.gov.pi.detran.ouvidoria.modelo.audit.Auditing;
import com.xpert.audit.AbstractAuditingListener;
import com.xpert.audit.model.AbstractAuditing;
import com.xpert.faces.utils.FacesUtils;
import javax.faces.context.FacesContext;

/**
 * Implmentacao do AbstractAuditingListener do xpert-framework, aqui serah definido o usuario
 * que esta realizando a acao, ele deve ser pego do bean de sessao #{sessaoUsuarioMB}
 * 
 * @author
 */
public class AuditingListenerImpl implements AbstractAuditingListener {

    @Override
    public void onSave(AbstractAuditing abstractAuditing) {
        Auditing auditing = (Auditing) abstractAuditing;
        if (FacesContext.getCurrentInstance() != null) {
            SessaoUsuarioMB sessaoUsuarioMB = FacesUtils.getBeanByEl("#{sessaoUsuarioMB}");
            if (sessaoUsuarioMB != null) {
                auditing.setUsuario(sessaoUsuarioMB.getUser());
            }
        }
    }
}
