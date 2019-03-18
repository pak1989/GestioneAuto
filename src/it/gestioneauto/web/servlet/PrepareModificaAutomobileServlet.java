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

@WebServlet("/PrepareModificaAutomobileServlet")
public class PrepareModificaAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AutomobileService automobileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public PrepareModificaAutomobileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idDaPagina = Long.parseLong(request.getParameter("idAutomobile"));
		
		Automobile automobileDaModificare = automobileService.caricaSingolaAutomobile(idDaPagina);
		
		request.setAttribute("automobileDaInviareAPaginaModificaForm", automobileDaModificare);
		
		RequestDispatcher rd = request.getRequestDispatcher("modificaAutomobileForm.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
