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
import org.samples.controller.RoleFacadeLocal;
import org.samples.entities.Role;
import org.samples.exceptions.NoneexistentEntityException;


@WebServlet(name = "RemoveRole", urlPatterns = {"/RemoveRole"})
public class RemoveRole extends HttpServlet {

     @EJB
    private RoleFacadeLocal facadeLocal;        
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoneexistentEntityException.NonexistentEntityException {
            Role o = new Role();
            String requests = request.getParameter("id");                                           
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();                                  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveRole</title>");            
            out.println("</head>");
            out.println("<body>");
            if (requests == null){
                out.println("<h1>Adicione o Id da regra na url. Ex: AddRole?Id=Super</h1>");
            }else{
                int id = Integer.parseInt(requests);   
                long l = (long) id;  
                o.setId(l);
                o.setName("Rubens");
                out.println("<h1>Regra com o ID: " + o.getId() + " removido.</h1>");
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
             Logger.getLogger(RemoveRole.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(RemoveRole.class.getName()).log(Level.SEVERE, null, ex);
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
