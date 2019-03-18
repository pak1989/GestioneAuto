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

import it.gestioneauto.service.AutomobileService;

@WebServlet("/VisualizzaDettaglioAutomobileServlet")
public class VisualizzaDettaglioAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AutomobileService automobileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public VisualizzaDettaglioAutomobileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAutomobileDaPagina = request.getParameter("idAutomobile");
		
		request.setAttribute("automobileSingola.attribute.name", automobileService.caricaSingolaAutomobile(Long.parseLong(idAutomobileDaPagina)));

		RequestDispatcher rd = request.getRequestDispatcher("dettaglioAutomobile.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
