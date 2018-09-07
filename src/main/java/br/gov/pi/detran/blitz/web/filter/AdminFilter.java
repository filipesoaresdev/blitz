package br.gov.pi.detran.blitz.web.filter;

import br.gov.pi.detran.blitz.mb.controleacesso.SessaoUsuarioMB;
import com.xpert.security.filter.AbstractSecurityFilter;
import com.xpert.security.session.AbstractUserSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ayslan
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = {AdminFilter.PATTERN})
public class AdminFilter extends AbstractSecurityFilter {

    public static final String PATTERN = "/view/*";
    private static final Logger logger = Logger.getLogger(AdminFilter.class.getName());
    private static final String HOME = "/index.jsf";
    private static final String[] IGNORE_URL = {"/view/home.jsf"};
    @ManagedProperty(value = "#{sessaoUsuarioMB}")
    SessaoUsuarioMB sessaoUsuarioMB;

    @Override
    public String getUserSessionName() {
        return "sessaoUsuarioMB";
    }

    @Override
    public String getHomePage() {
        return HOME;
    }

    @Override
    public String[] getIgnoredUrls() {
        return IGNORE_URL;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.log(Level.INFO, "Iniciando Filter para modulo ADMIN para url: {0}", PATTERN);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        sessaoUsuarioMB = (SessaoUsuarioMB) getFromSession(request, getUserSessionName());
        
        AbstractUserSession userSession = (AbstractUserSession) getFromSession(request, getUserSessionName());
        
        if (userSession == null || !isAuthenticated(userSession)) {
            if (isDebug()) {
                logger.log(Level.INFO, "User not authenticated redirecting to: {0}", getHomePage());
            }
            redirectHome(request, response);
            return;
        }
        
        if (!hasUrl((HttpServletRequest) request)) {
            if (isDebug()) {
                logger.log(Level.INFO, "User {0} not authorized to url: {1}", new Object[]{userSession.getUser().getUserLogin(), ((HttpServletRequest) request).getRequestURI()});
            }
            redirectHome(request, response);
            return;
        }
        
        if (getMoreAuthentication(request, response)) {
            try {
                chain.doFilter(request, response);
            } catch (Throwable ex) {
                logger.log(Level.SEVERE, null, ex);
                onError();
            }
        }
        
    }

    public SessaoUsuarioMB getSessaoUsuarioMB() {
        return sessaoUsuarioMB;
    }

    public void setSessaoUsuarioMB(SessaoUsuarioMB sessaoUsuarioMB) {
        this.sessaoUsuarioMB = sessaoUsuarioMB;
    }
}
