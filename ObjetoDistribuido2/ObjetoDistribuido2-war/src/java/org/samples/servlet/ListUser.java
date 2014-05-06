package org.samples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.samples.controller.UserFacadeLocal;
import org.samples.entities.User;

@WebServlet(name = "ListUser", urlPatterns = {"/ListUser"})
public class ListUser extends HttpServlet {

    @EJB
    private UserFacadeLocal facadeLocal;  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             List<User> users = facadeLocal.findUserEntities();
                    
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>");
            out.println("<title>List User</title>");            
            out.println("</head>");
            out.println("<body>");            
            out.println("<div class='container' style='margin-top: 20px'>");
            out.println("<div class='row'>");            
            out.println("<div class='col-sm-12'>");
            out.println("<div class='text-center'>");
            out.println("<marquee><h1>Users</h1>");
            out.println("</marquee>");
            out.println("</div>");
            out.println("<table class='table table-condensed table-bordered'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th style='text-align: center'>ID</th>");
            out.println("<th style='text-align: center'>Nome</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<tbody>");            
            User o;
            for (int i = 0; i < users.size(); i++) {
                o = (User) users.get(i);
                out.println("<tr style='text-align: center'>");
                out.println("<td style='text-align: center'>" + o.getId() +"</td>");
                out.println("<td style='text-align: center'>" + o.getName() + "</td>");
                out.println("</tr>");
                
            }
            out.println("</tbody>");
            out.println("</table>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
