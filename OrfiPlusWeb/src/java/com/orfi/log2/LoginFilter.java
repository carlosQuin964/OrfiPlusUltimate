/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.log2;

import com.orfi.entity.Persona;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/faces/protegido/*","/faces/errorpages/*","/faces/reportes"})
public class LoginFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public LoginFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest reqt = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession ses = reqt.getSession(false);
        if (ses != null) {
            Persona p = (Persona) ses.getAttribute("usuario");

            if (p != null) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
            }
        } else {
            resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
        }
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {

    }

}
