package filter;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.User;


@WebFilter(filterName = "CheckLoggedIn", urlPatterns =
{
    "/faces/secure/*"
})
public class CheckLoggedIn implements Filter
{
    @Inject
    private User user;
    
    private FilterConfig filterConfig = null;
    
    public CheckLoggedIn()
    {
    }    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException
    {
        if (user.isLoggedIn())
        {
            chain.doFilter(request, response);
        }
        else
        {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse res = (HttpServletResponse)response;
            
            res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
        }
    }

    public FilterConfig getFilterConfig()
    {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    public void destroy()
    {        
    }

    public void init(FilterConfig filterConfig)
    {        
        this.filterConfig = filterConfig;
    }

    @Override
    public String toString()
    {
        if (filterConfig == null)
        {
            return ("CheckLoggedIn()");
        }
        StringBuffer sb = new StringBuffer("CheckLoggedIn(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);        
    }
    
}
