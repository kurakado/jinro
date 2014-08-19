package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Village;

/**
 * Servlet implementation class GameScreenForGM
 */
@WebServlet("/GameScreenForGM")
public class GameScreenForGM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameScreenForGM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		Integer target=Integer.parseInt(request.getParameter("target_number"));
		Village vill=(Village)request.getAttribute("vill");
		System.out.println("dbg:ScreenForGM get");
		if(action==null){
			return;
		}
		if(action=="kick"){
			if(!(target==null)){
				vill.sankasha_map.remove(target);
				System.out.println("dbg:kick");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		//入れ物だけ作ってからnullチェック
		Integer target=null;
		if(!(request.getParameter("target_number")==null)){
			target=Integer.parseInt(request.getParameter("target_number"));
			System.out.println("dbg:target is "+target+".action is "+action);
		}
		Village vill=(Village)request.getAttribute("vill");
		System.out.println("dbg:ScreenForGM post");
		if(action==null){
			return;
		}
		if(action=="kick"){
			if(!(target==null)){
				vill.sankasha_map.remove(target);
				System.out.println("dbg:kick");
			}
		}
	}
}
