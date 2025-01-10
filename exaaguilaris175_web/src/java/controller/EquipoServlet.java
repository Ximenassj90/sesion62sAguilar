/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EquipoDAO;
import model.Equipo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Servlet encargado de manejar las solicitudes relacionadas con equipos.
 */
@WebServlet(name = "EquipoServlet", urlPatterns = {"/EquipoServlet"})
public class EquipoServlet extends HttpServlet {

    private EquipoDAO equipoDAO;

    @Override
    public void init() throws ServletException {
        // Inicializar el DAO de Equipos
        equipoDAO = new EquipoDAO();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * Muestra los equipos registrados.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener lista de equipos
        List<Equipo> listaEquipos = equipoDAO.obtenerEquipos();

        // Pasar la lista de equipos al JSP
        request.setAttribute("equipos", listaEquipos);

        // Redirigir a la página equipos.jsp
        request.getRequestDispatcher("equipos.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Agrega un nuevo equipo.
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
            // Obtener parámetros enviados desde el formulario
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String precioStr = request.getParameter("precio");

            System.out.println("Marca: " + marca);
            System.out.println("Modelo: " + modelo);
            System.out.println("Precio (String): " + precioStr);

            int precio = Integer.parseInt(precioStr);

            // Crear un objeto Equipo con los datos proporcionados
            Equipo equipo = new Equipo(0, marca, modelo, precio);
            System.out.println("Equipo creado: " + equipo);

            // Agregar el equipo a la base de datos
            boolean exito = equipoDAO.agregarEquipo(equipo);

            // Mensaje para el usuario según el resultado
            request.setAttribute("mensaje", exito ? "Equipo agregado correctamente." : "Error al agregar el equipo.");
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el precio: " + e.getMessage());
            request.setAttribute("mensaje", "El precio debe ser un número válido.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            request.setAttribute("mensaje", "Ocurrió un error al procesarr la solicitud.");
        }

        // Redirigir nuevamente a la lista de equipos
        doGet(request, response);
    }
}
