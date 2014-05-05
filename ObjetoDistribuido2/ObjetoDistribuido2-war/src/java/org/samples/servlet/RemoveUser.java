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
import org.samples.controller.UserFacadeLocal;
import org.samples.entities.User;
import org.samples.exceptions.NoneexistentEntityException;


@WebServlet(name = "RemoveUser", urlPatterns = {"/RemoveUser"})
public class RemoveUser extends HttpServlet {

    @EJB
    private UserFacadeLocal facadeLocal;        
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoneexistentEntityException.NonexistentEntityException {        
            User o = new User();
            String requests = request.getParameter("id");                                                       
            PrintWriter out = response.getWriter();                                  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveRole</title>");            
            out.println("</head>");
            out.println("<body>");
            if (requests == null){
                out.println("<h1>Adicione o Id do usuário na url. Ex: AddUser?Id=Super</h1>");
            }else{
                int id = Integer.parseInt(requests);   
                long l = (long) id;  
                o.setId(l);
                out.println("<h1>Usuário com o ID: " + o.getId() + " removido.</h1>");                
                facadeLocal.excluir(o);            
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
            Logger.getLogger(RemoveUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RemoveUser.class.getName()).log(Level.SEVERE, null, ex);
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
