package org.sberteh.servlet;

import org.sberteh.dao.EmployeeDao;
import org.sberteh.model.Employee;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * class controller
 */
@WebServlet(urlPatterns = "/employeeServletSync")
public class EmployeeServletSync extends HttpServlet {

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private Logger log;

    /**
     *
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        employee.setPhone(req.getParameter("phone"));
        employeeDao.save(employee);
        log.finest("save employee " + employee);
        resp.sendRedirect("main.html");
        return;
    }

}
