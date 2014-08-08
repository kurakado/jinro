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

import object.Village;
import system.Server;

/**
 * Servlet implementation class GameScreen
 */
@WebServlet("/GameScreen")
public class GameScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameScreen() {
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
		int village_number=Integer.parseInt(request.getParameter("village_number"));
		HashMap<Integer, Village> village_list=Server.get_village_list();
		Village vill=village_list.get(village_number);
		request.setAttribute("village_number", village_number);
		//chatがnullでも空文字でもない時
		if ((request.getParameter("chat")!=null) && (! (request.getParameter("chat").equals("")))){
				//発言の新しい物ほど上にくるように要素0に挿入。
				//逆順で表示したいなら位置指定を消す。(最後の要素に追加)
				vill.chat.add(0,"｢"+request.getParameter("chat")+"｣");
		}
		String url="/gameScreen.jsp";
		forward(url,request,response);
	}
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
