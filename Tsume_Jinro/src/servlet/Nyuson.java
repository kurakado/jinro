package servlet;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Sankasha;
import object.Village;
import system.Server;

/**
 * Servlet implementation class Nyuson
 */
@WebServlet("/Nyuson")
public class Nyuson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nyuson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//エンコード方式の指定
		response.setContentType("text/html; charset=UTF-8");
		//パラメータのエンコード方式の指定
		request.setCharacterEncoding("UTF-8");
		
		HashMap<Integer, Village> village_list=Server.get_village_list();
		Village vill=village_list.get(Integer.parseInt(request.getParameter("Village_number")));
		Sankasha person=new Sankasha(request.getParameter("name"),request.getParameter("pass"),request.getParameter("kibo"));
		Boolean result = vill.sanka(person);
		request.setAttribute("result", result);
		request.setAttribute("vill", vill);
		request.setAttribute("person", person);
		
		
		String url="/nyusonResult.jsp";
		forward(url,request,response);
	}
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
