package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/")
public class GetIndexPageServlet extends HttpServlet {
    private final static String index = "/WEB-INF/view/index.jsp";
    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("Alexander", 35));
        users.add(new User("Alina", 30));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", users);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        if (!requestIsValid(req)) {
            doGet(req, resp);
        }

        final String name = req.getParameter("name");
        final String age = req.getParameter("age");

        final User user = new User(name, Integer.parseInt(age));
        users.add(user);

        doGet(req, resp);
    }

    private boolean requestIsValid(final HttpServletRequest req) {

        final String name = req.getParameter("name");
        final String age = req.getParameter("age");

        return name != null && name.length() > 0 &&
                age != null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }
}
