package edu.uth.childvaccinesystem.controller;

import edu.uth.childvaccinesystem.dao.VaccineDAO;
import edu.uth.childvaccinesystem.model.Vaccine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/vaccine")
public class VaccineServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addVaccine(request, response);
        } else if ("update".equals(action)) {
            updateVaccine(request, response);
        } else if ("delete".equals(action)) {
            deleteVaccine(request, response);
        }
    }

    private void addVaccine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int ageRequired = Integer.parseInt(request.getParameter("ageRequired"));

            VaccineDAO vaccineDAO = new VaccineDAO();
            vaccineDAO.addVaccine(new Vaccine(id, name, description, ageRequired));
            response.sendRedirect("vaccine_list.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?message=Thêm vaccine thất bại!");
        }
    }

    private void updateVaccine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int ageRequired = Integer.parseInt(request.getParameter("ageRequired"));

            VaccineDAO vaccineDAO = new VaccineDAO();
            vaccineDAO.updateVaccine(new Vaccine(id, name, description, ageRequired));

            response.sendRedirect("vaccine_list.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?message=Cập nhật vaccine thất bại!");
        }
    }

    private void deleteVaccine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            VaccineDAO vaccineDAO = new VaccineDAO();
            vaccineDAO.deleteVaccine(id);

            response.sendRedirect("vaccine_list.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?message=Xóa vaccine thất bại!");
        }
    }
}
