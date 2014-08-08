package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Sankasha;
import object.Village;

/**
 * Servlet implementation class MakeVillage
 */
@WebServlet("/MakeVillage")
public class MakeVillage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeVillage() {
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
		
		//GM名
		String name=request.getParameter("name");
		//GMパスワード
		String pass=request.getParameter("pass");
		//村名取得
		String village_name=request.getParameter("village_name");
		//各人数集計
		int uranaishi=Integer.parseInt(request.getParameter("ninzuu_uranaishi"));
		int reinousha=Integer.parseInt(request.getParameter("ninzuu_reinousha"));
		int kyoyusha=Integer.parseInt(request.getParameter("ninzuu_kyoyusha"));
		int karyudo=Integer.parseInt(request.getParameter("ninzuu_karyudo"));
		int murabito=Integer.parseInt(request.getParameter("ninzuu_murabito"));
		int kyojin=Integer.parseInt(request.getParameter("ninzuu_kyojin"));
		int jinro=Integer.parseInt(request.getParameter("ninzuu_jinro"));
		int youko=Integer.parseInt(request.getParameter("ninzuu_youko"));
		int sankasha=uranaishi + reinousha + kyoyusha + karyudo + murabito + kyojin + jinro + youko;
		int[] ninzu={sankasha,uranaishi,reinousha,kyoyusha,karyudo,murabito,kyojin,jinro,youko};

		//Village オブジェクト作成
		Village vill= new Village(village_name,ninzu);
		Sankasha GM = new Sankasha(name,pass,"GM");
		vill.setGM(GM);
		request.setAttribute("vill", vill);
		request.setAttribute("GM", GM);
		String url="/makeVillageResult.jsp";
		forward(url,request,response);
	}
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
