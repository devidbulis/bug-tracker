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
import Bean.LoginBean;


@WebFilter(filterName = "CheckSubmitter", urlPatterns =
{
    "/faces/secure/submitter/*"
})
public class CheckSubmitter implements Filter
{
    @Inject
    private LoginBean user;
    
    private FilterConfig filterConfig = null;
    
    public CheckSubmitter()
    {
    }    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException
    {
        if ("Submitter".equals(user.getRole()))
        {
            chain.doFilter(request, response);
        }
        else
        {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse res = (HttpServletResponse)response;
            
            res.sendRedirect(req.getContextPath() + "/faces/secure/main.xhtml");
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
            return ("CheckSubmitter()");
        }
        StringBuffer sb = new StringBuffer("CheckSubmitter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);        
    }
    
}
