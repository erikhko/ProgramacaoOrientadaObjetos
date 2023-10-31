package br.fiap.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.FuncionarioDAO;
import br.fiap.dao.VendaDAO;
import br.fiap.entidade.Funcionario;
import br.fiap.entidade.Venda;

/**
 * Servlet implementation class CadastroVendaServlet
 */
@WebServlet("/cadastroVenda")
public class CadastroVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroVendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO dao = new FuncionarioDAO();
		Venda venda = new Venda();
		VendaDAO daoVenda = new VendaDAO();
		
		int id_funcionario = Integer.parseInt(request.getParameter("funcionario"));
		List<Funcionario> lista = dao.listar();
		for(Funcionario f : lista) {
			if(id_funcionario == f.getId()) {
				venda.setFuncionario(f);
			}
		}
		
		venda.setValor(Double.parseDouble(request.getParameter("venda")));
		daoVenda.inserir(venda);
		
		response.sendRedirect("form/formCadastroVenda.jsp");
		
	}

}
