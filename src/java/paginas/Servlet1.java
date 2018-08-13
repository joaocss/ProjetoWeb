/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paginas;

import Conection.ConectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * esse é o seu ?
 * @author RG-295
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public ConectionFactory con = new ConectionFactory();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mat = request.getParameter("mat");
        ConectionFactory conection = new ConectionFactory();
        String nome=conection.cmatricula(mat);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> \n"+
            "	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" );
            
            out.println("<title>MATRICULA</title>");            
            out.println("</head>");
            out.println("<body>");
            if(nome != null){
            out.println("<div>"+nome+"</div>");
            out.println("<form action=\"NewServlet2\">");
            out.println("<div class=\"div1\"><table class=\"tb\" border=\"1px solid\"> "
                    + "<tr> <td>Codigo da Disciplina </td>"
                    +"<td> Nome Da Disciplina </td>"
                    +"<td> Carga Horaria Semanal </td>"
                    +"<td> Codigo Da Turma </td>"
                    +"<td> Dia e Hora </td>"
                     +"<td> Selecionar<td></tr>");
                    conection.getTurmas(out);
                    out.println("</table></div>");
                    out.println("<button type=\"submit\">enviar</button>");
                    out.println("</form>");
     //       out.println("<h1>Bem Vindo " + nome+ "</h1>");
            out.println("</body>");
            out.println("</html>");}
            else{
            out.println("Aluno não matriculado");
            out.println("</body>");
            out.println("</html>");}
            
            
            con.getConection();
        }
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
