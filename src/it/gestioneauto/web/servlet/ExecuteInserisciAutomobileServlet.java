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

@WebServlet("/ExecuteInserisciAutomobileServlet")
public class ExecuteInserisciAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AutomobileService automobileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteInserisciAutomobileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloDaPagina = request.getParameter("modelloInput");
		String coloreDaPagina = request.getParameter("coloreInput");
		Integer cilindrataDaPagina = Integer.parseInt(request.getParameter("cilindrataInput"));

		String destinazione = "ListAllServlet";
		
		if (marcaDaPagina.equals("") || modelloDaPagina.equals("") || coloreDaPagina.equals("")
				|| cilindrataDaPagina <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "inserisciAutomobileForm.jsp";
		}
		
		Automobile automobileDaInserire = new Automobile(marcaDaPagina, modelloDaPagina, coloreDaPagina, cilindrataDaPagina);
		
		automobileService.inserisciNuova(automobileDaInserire);
				
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
