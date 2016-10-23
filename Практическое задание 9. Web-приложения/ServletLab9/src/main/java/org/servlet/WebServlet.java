package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WebServlet extends HttpServlet {

    private Decoder decoder = new Decoder();
    private Encoder encoder = new Encoder();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("servlet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String nameOperation = req.getParameter("nameOperation");
        String stringForOperation = req.getParameter("string");

        writer.println("Your string: " + stringForOperation);

        if(nameOperation.equals("decode")) {
            writer.print("Decode string: " + decoder.decode(stringForOperation));
        }
        if(nameOperation.equals("encode")) {
            writer.print("Encode string: " + encoder.encode(stringForOperation));
        }
    }
}
