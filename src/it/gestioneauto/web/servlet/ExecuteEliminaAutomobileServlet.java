package it.gestioneauto.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneauto.model.Automobile;
import it.gestioneauto.service.AutomobileService;

@WebServlet("/ExecuteEliminaAutomobileServlet")
public class ExecuteEliminaAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AutomobileService automobileService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteEliminaAutomobileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeDaPagina = request.getParameter("marcaInput");
		long idDaPagina = Long.parseLong(request.getParameter("idInput"));

		String destinazione = null;

		Automobile automobileDaEliminare = automobileService.caricaSingolaAutomobile(idDaPagina);

		if (!nomeDaPagina.equals(automobileDaEliminare.getMarca())) {
			String messaggioDaInviareAPagina = "Attenzione! Marca Sbagliata.";
			request.setAttribute("automobileDaInviareAPaginaEliminaForm", automobileDaEliminare);
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "eliminaAutomobileForm.jsp";
		} else {

			automobileService.rimuovi(automobileDaEliminare);
			destinazione = "ListAllServlet";
		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
