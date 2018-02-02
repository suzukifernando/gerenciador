package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet("/adicionaEmpresa")
public class AdicionaEmpresa extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String nomeEmpresa = req.getParameter("nomeEmpresa");
		new EmpresaDAO().adiciona(new Empresa(nomeEmpresa));
		writer.println("<html><body> A empresa " + nomeEmpresa + " foi adicionada com sucesso !</body></html>");

	}

}
