package Conection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RG 295
 */
public class ConectionFactory {
     private static final String DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String URL = "jdbc:mysql://localhost/webdb"; 
    private static final String USER = "root"; 
    private static final String PASS = ""; 
    
    public Connection getConection(){
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na Conexão", ex);
            
                   
             
        }
    }
    public static void CloseConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Conexão encerrada", ex);
            }
        }
    }
    
    public static void CloseConnection(Connection con, PreparedStatement stmt){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Conexão encerrada", ex);
            }
            CloseConnection(con);
        }
    }
    public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Conexão encerrada", ex);
            }
            CloseConnection(con,stmt);
        }
    }
    public String cmatricula(String matricula){
        Connection c = new ConectionFactory().getConection();
        String fim= null;
         try {
             PreparedStatement st = c.prepareStatement("SELECT nomeDoAluno FROM Aluno where MatriculaAluno = '"+matricula+"'");
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 fim=rs.getString("nomeDoAluno");
                 System.out.println(fim);
                 
             }
             
             CloseConnection(c);
             st.close();
             rs.close();
             return fim;
             
         } catch (SQLException ex) {
             Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        return fim;
    }
    
    
        public void getTurmas(PrintWriter out){
        Connection c = new ConectionFactory().getConection();
        String fim= null;
         try {
             PreparedStatement st = c.prepareStatement("SELECT CodDisciplina,NomeD,chs, CodTurma,DiaHora1,DiaHora2,DiaHora3 FROM  turma inner join disciplinas  on turma.CodDisciplina = disciplinas.CodD ");
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 out.println("<tr>");
                 out.println("<td>");
                 out.println(rs.getString("CodDisciplina"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("NomeD"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("chs"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("CodTurma"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("DiaHora1"));
                 out.println("<br/>");
                 out.println(rs.getString("DiaHora2"));
                 out.println("<br/>");
                 out.println(rs.getString("DiaHora3"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println("<input type=\"checkbox\" name = \"turmas\" value = \""+rs.getString("CodTurma")+"\"");
                 out.println("</td>");
                 out.println("</tr>");
                 
             }
             
             CloseConnection(c);
             st.close();
             rs.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
        
        
        
        public void getTurmas1(PrintWriter out, String  t){
        Connection c = new ConectionFactory().getConection();
        String fim= null;
         try {
             PreparedStatement st = null;
             ResultSet rs = null;
              st = c.prepareStatement("SELECT CodDisciplina,NomeD,chs, CodTurma,DiaHora1,DiaHora2,DiaHora3 FROM  turma inner join disciplinas  on turma.CodDisciplina = disciplinas.CodD where CodTurma ='"+t+"'");
              rs = st.executeQuery();
             while(rs.next()){
                 out.println("<tr>");
                 out.println("<td>");
                 out.println(rs.getString("CodDisciplina"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("NomeD"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("chs"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("CodTurma"));
                 out.println("</td>");
                 out.println("<td>");
                 out.println(rs.getString("DiaHora1"));
                 out.println("<br/>");
                 out.println(rs.getString("DiaHora2"));
                 out.println("<br/>");
                 out.println(rs.getString("DiaHora3"));
                 out.println("</td>");
                 out.println("</tr>");
                 
             }
             
             CloseConnection(c);
             st.close();
             rs.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    
    
    public String ccurso(String codigo){
        Connection c = new ConectionFactory().getConection();
        String fim= null;
         try {
             PreparedStatement st = c.prepareStatement("SELECT NomeCurso FROM Curso where codigo = '"+codigo+"'");
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 fim=rs.getString("NomeCurso");
                 System.out.println(fim);
                 
             }
             CloseConnection(c);
             st.close();
             rs.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        return fim;
    }
}
