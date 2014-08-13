package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.MessageString;

/**
 * Servlet implementation class AccountLogin
 */
@WebServlet("/AccountLogin")
public class AccountLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// URL設定
		String url = "/accountLogin.jsp";
		// フォワード
		forward(url, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// エラーメッセージ
		StringBuilder errorMessage = new StringBuilder(0);

		// パラメータ受け取り
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("pass");
		
		// IDの必須チェック
		if (id == null || id.equals("")) {
			errorMessage.append(String.format(MessageString.M01W, "ID")
					+ "<br>");
		}
		// パスワードの必須チェック
		if (password == null || password.equals("")) {
			errorMessage.append(String.format(MessageString.M01W, "パスワード")
					+ "<br>");
		}
		
		// 入力チェックまででエラーがあったら、ログイン画面に戻る
		if (errorMessage.length() != 0) {
			// リクエストにエラー情報設定
			request.setAttribute("error", errorMessage.toString());
			// URL設定
			String url = "/accountLogin.jsp";
			// フォワード
			forward(url, request, response);
			return;
		}
	}
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
