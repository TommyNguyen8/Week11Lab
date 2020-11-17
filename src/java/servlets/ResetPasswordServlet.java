package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.AccountService;

/**
 *
 * @author 791662
 */
public class ResetPasswordServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String uuid = request.getParameter("uuid");
        
        if(uuid != null)
        {
            request.setAttribute("userUuid", uuid);
            
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp")
                    .forward(request, response);
            
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        AccountService as = new AccountService();
        User user = new User();
        
        String action = request.getParameter("action");
        
        try
        {
            switch (action)
            {
                case "send":
                    String email = request.getParameter("email");
                    String path = getServletContext().getRealPath("/WEB-INF");
                    String url = request.getRequestURL().toString();
                    
                    user = as.resetPassword(email, path, url);
                    
                    request.setAttribute("message", "An email has been sent");
                    
                    getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp")
                            .forward(request, response);
                    
                    break;
                case "update":
                    String password = request.getParameter("password");
                    String uuid = request.getParameter("userUuid");
                    
                    Boolean reset = as.changePassword(uuid, password);
                    
                    if(!reset)
                    {
                        request.setAttribute("message", "An error has occur");
            
                        getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp")
                                .forward(request, response);
                    }
                    else    
                    {
                        request.setAttribute("message", "Your password was successfully changed");
            
                        getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp")
                                .forward(request, response);
                    }
                    
                    break;
            }
        }
        catch (Exception e)
        {
            
        }
        
        if(user == null)
        {
            request.setAttribute("message", "An error has occur");
                        
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp")
                    .forward(request, response);
        }
    }
}
