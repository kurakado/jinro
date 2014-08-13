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
import javax.servlet.http.HttpSession;

import object.Village;
import system.Server;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
//		System.out.println("dbg:start post");
		// TODO Auto-generated method stub
		//エンコード方式の指定
		response.setContentType("text/html; charset=UTF-8");
		//パラメータのエンコード方式の指定
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession(true);
		
		//既に入村中ならば、その村に入る
		if(!(session.getAttribute("vill")==null)){
			Village vill=(Village)session.getAttribute("vill");
			request.setAttribute("village_number", vill.number);
			String url="/gameScreen.jsp";
			forward(url,request,response);
			return;
		}
		
		HashMap<Integer, Village> village_list=Server.get_village_list();
		request.setAttribute("village_list", village_list);
		if(!(request.getParameter("vill_number")==null)){
			int vill_number = Integer.parseInt(request.getParameter("vill_number"));
			Village vill=Server.get_village_list().get(vill_number);
			request.setAttribute("vill", vill);
					
			if((!(request.getParameter("pass")==null))&&(!(request.getParameter("id")==null))){
				int id=Integer.parseInt(request.getParameter("id"));
				if(vill.sankasha.get(id).getPassword().equals(request.getParameter("pass"))){
					request.setAttribute("village_number", vill.number);
					session.setAttribute("vill", vill);
					session.setAttribute("sankasha", vill.sankasha.get(id));
					String url="/gameScreen.jsp";
					forward(url,request,response);
					return;
				}
			}
		}
		String url="/login.jsp";
		System.out.println("dbg:forward login.jsp");
		forward(url,request,response);

	}
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
