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
import object.Sankasha;
import object.Village;
import system.MessageString;
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
		StringBuilder errorMessage = new StringBuilder(0);
		HttpSession session=request.getSession(true);
		
		//アカウントログインしていない場合には追い返す
		if(session.getAttribute("account")==null){
			errorMessage.append(MessageString.M01S);
			
		}else{
			Account account=(Account)session.getAttribute("account");
			System.out.println(account.getId());
		}
		request.setAttribute("error", errorMessage.toString());
		String url="/nyuson.jsp";
		forward(url,request,response);
		return;
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
		StringBuilder errorMessage = new StringBuilder(0);
		HttpSession session=request.getSession(true);
		
		//アカウントログインしていない場合にはエラー
		if(session.getAttribute("account")==null){
			errorMessage.append(MessageString.M01S);
		}
		
		//村情報取得
		HashMap<Integer, Village> village_list=Server.get_village_list();
		Village vill=village_list.get(Integer.parseInt(request.getParameter("Village_number")));

		//名前の"◆"はGM専用記号の為、"◇"に置き換え
		Sankasha sankasha=new Sankasha(request.getParameter("name").replaceAll("◆", "◇"),(Account)session.getAttribute("account"),request.getParameter("kibo"));

		//村に参加者を登録
		if(!(vill.sanka(sankasha))){
			errorMessage.append(MessageString.M02W);
		}

		//エラーがある場合には追い返す
		if (errorMessage.length() != 0) {
			// リクエストにエラー情報設定
			request.setAttribute("error", errorMessage.toString());
			// URL設定
			String url = "/nyuson.jsp";
			// フォワード
			forward(url, request, response);
			return;
		}
		//セッションに情報を登録
		session.setAttribute("vill", vill);
		session.setAttribute("sankasha", sankasha);	
		
		String url="/nyusonResult.jsp";
		forward(url,request,response);
		return;
	}
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
