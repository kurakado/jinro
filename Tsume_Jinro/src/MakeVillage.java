

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//エンコード方式の指定
		res.setContentType("text/html; charset=UTF-8");
		//パラメータのエンコード方式の指定
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		//各人数集計
		int uranaishi=Integer.parseInt(req.getParameter("ninzuu_uranaishi"));
		int reinousha=Integer.parseInt(req.getParameter("ninzuu_reinousha"));
		int kyoyusha=Integer.parseInt(req.getParameter("ninzuu_kyoyusha"));
		int karyudo=Integer.parseInt(req.getParameter("ninzuu_karyudo"));
		int murabito=Integer.parseInt(req.getParameter("ninzuu_murabito"));
		int kyojin=Integer.parseInt(req.getParameter("ninzuu_kyojin"));
		int jinro=Integer.parseInt(req.getParameter("ninzuu_jinro"));
		int youko=Integer.parseInt(req.getParameter("ninzuu_youko"));
		int sankasha=uranaishi + reinousha + kyoyusha + karyudo + murabito + kyojin + jinro + youko;
		int[] ninzu={sankasha,uranaishi,reinousha,kyoyusha,karyudo,murabito,kyojin,jinro,youko};

		//Village オブジェクト作成
		Village vill= new Village(ninzu);
		
		out.println("<HTML>");
		out.println("<head>");
		out.println("<title>Test page</title>");
		out.println("</head>");
		out.println("<BODY>");
		out.println("村番号："+vill.number);
		out.println("</BODY>");
		out.println("</HTML>");
	}

}
