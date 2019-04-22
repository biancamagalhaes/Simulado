package br.ucsal.geu.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.geu.dao.EspacoDAO;
import br.ucsal.geu.dao.ReservaDAO;
import br.ucsal.geu.model.Reserva;

@WebServlet("/reservas")
public class ReservaController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			EspacoDAO dao = new EspacoDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservaform.jsp").forward(request, response);
		} else {
			ReservaDAO dao = new ReservaDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservalist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String justificativa = request.getParameter("justificativa");
		String solicitante = request.getParameter("solicitante");
		String telefone = request.getParameter("telefone");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = simpleDateFormat.parse(request.getParameter("data"));
			java.sql.Date data = new java.sql.Date(date.getTime()); 
			SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
			java.util.Date inicio = formatador.parse(request.getParameter("horaIni"));
			java.util.Date fim = formatador.parse(request.getParameter("horaFim"));
			Time horaIni = new Time(inicio.getTime());
			Time horaFim = new Time(fim.getTime());
			Reserva reserva = new Reserva(titulo, descricao, justificativa, solicitante, telefone, data, horaIni, horaFim);
			ReservaDAO dao = new ReservaDAO();
			dao.inserir(reserva);
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservalist.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		


	}
}
