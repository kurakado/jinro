

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yakushoku.Charactor;
import yakushoku.Jinro;
import yakushoku.Murabito;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Test() {
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
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	//(1)エンコード方式の指定
	res.setContentType("text/html; charset=UTF-8");
	//(2)パラメータのエンコード方式の指定
	req.setCharacterEncoding("UTF-8");
	Charactor cha=new Jinro("ookami");
	Charactor cha2=new Murabito("heimin");
	//(3)PrintWriterオブジェクトの生成
	PrintWriter out = res.getWriter();
	out.println("<HTML>");
	out.println("<head>");
	out.println("<title>Test page</title>");
	out.println("</head>");
	out.println("<BODY>");
	//(4)name1パラメータの取得
	out.println(req.getParameter("name1") + "<br>");
	//(5)vehicleパラメータの取得
	String vehicle[] = req.getParameterValues("vehicle");
	for (int i = 0; i < vehicle.length; i++ ) {
		out.println(vehicle[i] + "<br>");
	}
	out.println(cha.get_name() + "'s result : " + cha.get_uranai_result() + "<br>");
	out.println(cha2.get_name() + "'s result : " + cha2.get_uranai_result() + "<br>");
	int sanka_ninzu=0;
	sanka_ninzu +=Integer.parseInt(req.getParameter("ninzuu_uranaishi"));
	sanka_ninzu +=Integer.parseInt(req.getParameter("ninzuu_reinousha"));
	out.println("人数："+sanka_ninzu + "<br>");
	out.println("内訳："+"<br>");
	out.println("占い師:"+req.getParameter("ninzuu_uranaishi")+"<br>");
	out.println("霊能者:"+req.getParameter("ninzuu_reinousha")+"<br>");
	out.println("</BODY>");
	out.println("</HTML>");
	}
}
