package br.com.sematec.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sematec.gerenciador.dao.EmpresaDAO;
import br.com.sematec.gerenciador.modelo.Empresa;

public class BuscaEmpresa implements Tarefa {
	
	public BuscaEmpresa() {
		System.out.println("Construindo uma servlet do tipo BuscaEmpresa " + this);
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse response) {
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
