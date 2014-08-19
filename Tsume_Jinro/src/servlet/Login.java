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

import object.Account;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("dbg:start post");
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
			System.out.println("dbg:serch sankasha.");
			int vill_number = Integer.parseInt(request.getParameter("vill_number"));
			Village vill=Server.get_village_list().get(vill_number);
//			System.out.println("dbg:village name is "+vill.name);
//			System.out.println("dbg:GM hash"+vill.getGM().getAccount().hashCode());
//			System.out.println("dbg:now hash"+session.getAttribute("account").hashCode());
			if( !((Account)session.getAttribute("account")==null) ){
				if(vill.getGM().getAccount().getId().equals(
						((Account)session.getAttribute("account")).getId() )){
					System.out.println("dbg:GM much.");
					request.setAttribute("village_number", vill.number);
					session.setAttribute("sankasha", vill.getGM());
					session.setAttribute("vill", vill);
					String url="/gameScreen.jsp";
					forward(url,request,response);
					return;
				}
			} 
			for (int i:vill.sankasha_map.keySet()){
				//該当の村の参加者に同じアカウント者がいたらその参加者として入村
				if(vill.sankasha_map.get(i).getAccount().getId().equals(
						( (Account)session.getAttribute("account") ).getId() ) ){
					System.out.println("dbg:account much.");
					request.setAttribute("village_number", vill.number);
					session.setAttribute("sankasha", vill.sankasha_map.get(i));
					session.setAttribute("vill", vill);
					String url="/gameScreen.jsp";
					forward(url,request,response);
					return;
				}
				System.out.println("dbg:not much."+vill.sankasha_map.get(i).getAccount().getId());
			}
			System.out.println("dbg:guest.");

			//パラメータセット
			request.setAttribute("village_number", vill.number);
			request.setAttribute("vill", vill);
			String url="/gameScreen.jsp";
			forward(url,request,response);
			return;
			/*	if((!(request.getParameter("pass")==null))&&(!(request.getParameter("id")==null))){
				int id=Integer.parseInt(request.getParameter("id"));
				if(vill.sankasha.get(id).getPassword().equals(request.getParameter("pass"))){
					request.setAttribute("village_number", vill.number);
					session.setAttribute("vill", vill);
					session.setAttribute("sankasha", vill.sankasha.get(id));
					String url="/gameScreen.jsp";
					forward(url,request,response);
					return;
				}
			}*/
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
