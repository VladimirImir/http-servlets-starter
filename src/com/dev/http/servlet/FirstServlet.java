package com.dev.http.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getHeader("user-agent");
       /* var headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            var header = headerNames.nextElement();
            System.out.println(req.getHeader(header));
        }*/

        var paramValue = req.getParameter("param");
        var parameterMap = req.getParameterMap();
        System.out.println();

        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "12345");
        //resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()) {
            writer.write("Hello from First Servlet. Привет с первого сервлета!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var parameterMap = req.getParameterMap();
        System.out.println(parameterMap);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
