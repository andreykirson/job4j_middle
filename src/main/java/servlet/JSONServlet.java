package servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONObject;
import org.json.JSONPointer;

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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedReader reader = req.getReader();
            PrintWriter writer = resp.getWriter()) {
            StringBuilder fullLine = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fullLine.append(line);
            }
            JsonElement jsonElement =  new JsonParser().parse(String.valueOf(fullLine));
            String json = gson.toJson(jsonElement);
            writer.println(json);
            writer.flush();
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
