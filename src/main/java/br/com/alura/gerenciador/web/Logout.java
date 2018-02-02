package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Cookies;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		HttpSession session = req.getSession();
		if (session == null) {
			writer.println("<html><body> Não existe usuário logado </body></html>");
		} else {
			session.invalidate();
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
			requestDispatcher.forward(req, resp);
		}
	}

}
