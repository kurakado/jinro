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
		request.setAttribute("vill",vill);
		request.setAttribute("village_number", village_number);
		HttpSession session=request.getSession();
		//chatがnullでも空文字でもない時
		if ((request.getParameter("chat")!=null) && (! (request.getParameter("chat").equals("")))){
			String name;
			if(session.getAttribute("sankasha")==null){
				if(session.getAttribute("account")==null){
					name="ゲスト";
				}else{
					Account tmp_account=(Account) session.getAttribute("account");
					name="ゲスト("+tmp_account.getId()+")";
				}
			}else{
				Sankasha sankasha=(Sankasha) session.getAttribute("sankasha");
				name=sankasha.name;
			}
			//発言の新しい物ほど上にくるように要素0に挿入。
			//逆順で表示したいなら位置指定を消す。(最後の要素に追加)
			vill.chat.add(0,name+"｢"+request.getParameter("chat")+"｣");
				
		}
		
		//GM専用処理を他サーブレットに実行させる。
	    String disp = "/GameScreenForGM";
	    RequestDispatcher dispatch = request.getRequestDispatcher(disp);

	    dispatch.include(request, response);
		
		String url="/gameScreen.jsp";
		//GMの場合だけ別画面に遷移
		if( !(session.getAttribute("vill")==null) && !(session.getAttribute("sankasha")==null) ){
			if( (session.getAttribute("vill").equals(vill)) && (session.getAttribute("sankasha").equals(vill.getGM())) ){
				System.out.println("dbg:you are GM.");
				url="/gameScreenForGM.jsp";
			}
		}
		forward(url,request,response);
	}
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
