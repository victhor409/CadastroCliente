package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Cliente;
import com.service.ClienteServiceImpl;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns = { "/ClienteController", "/main", "/create" ,"/read"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClienteServiceImpl service = new ClienteServiceImpl();

	public ClienteController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			inicio(request, response);
		} else if (action.equals("/create")) {
			criarNovoCliente(request, response);
		}else if(action.equals("/read")) {
			consultarTodosClientes(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}

	}

	protected void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendRedirect("index.jsp");
	}

	protected void criarNovoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String idString = request.getParameter("id");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String valorContratoString = request.getParameter("valorContrato");
		String ativoString = request.getParameter("ativo");

		BigDecimal valorContrato = new BigDecimal(valorContratoString);
		// Integer id = Integer.parseInt(idString);
		boolean ativo = Boolean.parseBoolean(ativoString);

		Cliente cliente = new Cliente();

		// cliente.setId(id);
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		cliente.setValorContrato(valorContrato);
		cliente.setAtivo(ativo);

		service.create(cliente);

		response.sendRedirect("index.jsp");

	}
	
	
	protected void consultarTodosClientes(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Cliente> list = service.findAll();
		
		request.setAttribute("clientes", list);
		RequestDispatcher rd = request.getRequestDispatcher("consultaCliente.jsp");
		rd.forward(request, response);
	}

}
