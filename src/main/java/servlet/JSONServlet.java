package servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

/**
 * @author Andrey
 * @date 29/10/2020
 * @version 1
 */

public class JSONServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        JSONObject jObj = new JSONObject();
        JSONObject newObj = jObj.getJSONObject(req.getParameter("jsondata"));
        String json = newObj.getString("text");
        System.out.println(req.getParameter("text"));
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
    }
}
