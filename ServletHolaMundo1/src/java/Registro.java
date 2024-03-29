/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
Connection nos ayuda a realizar la conexion con las bases de datos, con el servidor
*/
import java.sql.Connection;
import java.sql.DriverManager;
/*
Statement nos ayuda a poder definir y manipular los datos de las bases de datos;
creacion de las bases de datos, insertar tablas, eliminar tablas, create, drop, alter
manipulacion de los datos, insert, update, delete
*/
import java.sql.Statement;
/*
Nos ayuda para las querrys, o las consultas a la base de datos
*/
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author eduardo
 */
public class Registro extends HttpServlet {
    //varibles globales
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    /*
    Constructor del servlet
    Nos va ayudar a inicializar la coneccion con la base de datos
    */

    public void init(ServletConfig cfg) throws ServletException{
        
        //trazr ruta al servidor de la base de datos
        String URL = "jdbc:mysql:3306//localhost/registro4iv8";
        //driver:gestor:puerto//IP/nombrebasededatos
        
        String userName = "root";
        String password = "HappyEduardo6759+-";
        
        
         try{
            //colocamos el tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            
            /*
            en algunas ocaciones enviar error al conectarse con la bd
            y eso se debe a que ya estegrado el puerto en el driver
            URL = "jdbc:mysql://localhost/registro4iv8";
            */
            URL = "jdbc:mysql://localhost/registro4iv8";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
        
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String nom, appat, apmat, correo, ip, iph;
            int edad, puerto, puertoh;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            correo = request.getParameter("correo");
            
            edad = Integer.parseInt(request.getParameter("edad"));
            
            ip = request.getLocalAddr() ;
            puerto = request.getLocalPort() ;
            
            iph = request.getRemoteAddr() ;
            puertoh = request.getRemotePort() ;
            
            
            
            
            
            try{
                
                
                String q = "insert into Mregistro (nom_usu, appat_usu,"
                        + " apmat_usu, edad_usu, correo_usu)"
                        + "values ('"+nom+"', '"+appat+"', '"+apmat+"', "+edad+", '"+correo+"')";
                
                //ejecutar la sentencia
                set.executeUpdate(q);
                
                System.out.println("Registro Exitoso");
                
                
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "Tu nombre es: " + nom);
            out.println("<br>"
                    + "Tu apellido paterno es: " + appat
                    + "<br>"
                    + "Tu apellido materno es: " + apmat
                    + "<br>"
                    + "Tu edad es: " + edad
                    + "<br>"
                    + "Tu correo electronico es: " + correo) ;
            out.println("<br>"
                    + "IP Local :" + ip
                    + "<br>"
                    + "Puerto Local :" + puerto
                    + "<br>"
                    + "IP Remota :" + iph
                    + "<br>"
                    + "Puerto Remoto : " + puertoh );
            out.println("<h1>Registro Exitoso</h1>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>");
            out.println("</body>");
            out.println("</html>");
            
            }catch(Exception e){
                
            out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Registro</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registro No Exitoso, vuelva a intentarlo</h1>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>");
                out.println("</body>");
                out.println("</html>");
                
                System.out.println("No se registro en la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                    
            }
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
    
    public void destroy(){
        try{
            con.close();
            System.out.println("Se destruyo");
            
            
        }catch(Exception e){
            super.destroy();
        
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
