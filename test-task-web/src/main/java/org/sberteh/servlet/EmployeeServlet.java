package org.sberteh.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sberteh.dao.EmployeeDao;
import org.sberteh.model.Employee;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

/**
 * class controller
 */
@WebServlet(urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {

    public static final String TEXT_JSON_CHARSET_UTF_8 = "text/json;charset=UTF-8";

    private static ObjectMapper objectMapper = new ObjectMapper();

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.finest("get employee list");
        List<Employee> employees = employeeDao.fetchAll();
        resp.setContentType(TEXT_JSON_CHARSET_UTF_8);
        try (PrintWriter out = resp.getWriter()) {
            String employeesString = objectMapper.writeValueAsString(employees);
            out.print(employeesString);
        }
    }

    /**
     *
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //for ajax requests
        // get received JSON data from request
        try (BufferedReader br = req.getReader()) {
            String employeeJson = null;
            if (br != null) {
                employeeJson = br.readLine();
            }

            System.out.println("employeeJson = " + employeeJson);

            Employee employee = objectMapper.readValue(employeeJson, Employee.class);
            employeeDao.save(employee);
            log.finest("save employee: " + employeeJson);
        }
    }
}
