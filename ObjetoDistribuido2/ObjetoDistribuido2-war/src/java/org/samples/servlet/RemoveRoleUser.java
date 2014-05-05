package org.samples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.samples.controller.UserRoleFacadeLocal;
import org.samples.entities.UserRole;
import org.samples.exceptions.NoneexistentEntityException;

@WebServlet(name = "RemoveRoleUser", urlPatterns = {"/RemoveRoleUser"})
public class RemoveRoleUser extends HttpServlet {

       @EJB
    private UserRoleFacadeLocal facadeLocal; 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoneexistentEntityException.NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
            UserRole o = new UserRole();
            String _user = request.getParameter("user");
            String _role = request.getParameter("role");                                       
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();                                  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveRole</title>");            
            out.println("</head>");
            out.println("<body>");
            if (_user == null || _role == null){
                out.println("<h1>Adicione o id do usuário e o id da regra. Ex: ?user=1&role=1</h1>");
            }else{                  
                o.setUserId(Long.parseLong(_user));
                o.setRoleId(Long.parseLong(_role));
                out.println("<h1>Removido a regra " + o.getRoleId()+ " do usuário " + o.getUserId()+ ".</h1>");
                facadeLocal.excluir(o.getUserId(), o.getRoleId());            
            } 
            out.println("</body>");
            out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try {
               processRequest(request, response);
           } catch (NoneexistentEntityException.NonexistentEntityException ex) {
               Logger.getLogger(RemoveRoleUser.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try {
               processRequest(request, response);
           } catch (NoneexistentEntityException.NonexistentEntityException ex) {
               Logger.getLogger(RemoveRoleUser.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
