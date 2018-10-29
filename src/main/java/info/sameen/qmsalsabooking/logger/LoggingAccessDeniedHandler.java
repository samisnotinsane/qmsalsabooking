package info.sameen.qmsalsabooking.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A custom <code>403 - Access Denied</code> handler.
 * In this handler we log the user who is trying to
 * access a protected resource which they don't have sufficient rights
 * to access and redirect the request to <code>/access-denied</code>.
 * @author sameenislam
 * @version 1.0
 */
@Component
public class LoggingAccessDeniedHandler implements AccessDeniedHandler {

    private static Logger LOG = LoggerFactory.getLogger(LoggingAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            LOG.info(auth.getName() + " was trying to access protected resource: " +
                    httpServletRequest.getRequestURI());
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/access-denied");
    }
}
