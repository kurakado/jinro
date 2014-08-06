

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//エンコード方式の指定
		res.setContentType("text/html; charset=UTF-8");
		//パラメータのエンコード方式の指定
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();

		
		out.println("<HTML>");
		out.println("<head>");
		out.println("<title>Test page</title>");
		out.println("</head>");
		out.println("<BODY>");
		HashMap<Integer, Village> village_list=Server.get_village_list();
		Village vill=village_list.get(Integer.parseInt(req.getParameter("Village_number")));
		Sankasha person=new Sankasha(req.getParameter("name"),req.getParameter("kibo"));
		boolean result = vill.sanka(person);
		if (result==true){
			out.println("村番号："+vill.number);
			out.println("村名前："+vill.name);
			out.println("名前："+req.getParameter("name") + "<br>");
			out.println("名前："+person.name + "<br>");
			out.println("希望役職："+req.getParameter("kibo") + "<br>");
			out.println("役職："+person.yaku + "<br>");		
			out.println("<form method=\"post\" action=\"gameScreen.jsp\">");
			out.println("<input type=\"hidden\" name=\"village_number\" value="+vill.number+">");
			out.println("<input type=\"submit\" value=\"進む\">");
		} else{
			out.println("定員オーバー");
		}
		out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");

	}

}
