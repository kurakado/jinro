package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Account;
import system.MessageString;

/**
 * Servlet implementation class SingUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// URL設定
		String url = "/signUp.jsp";
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
		
		//IDの重複チェック
		File user_file = new File("./csv/user/user_"+id+".csv");
		if(user_file.exists()){
			errorMessage.append(String.format(MessageString.M03W, "ID")
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
			String url = "/signUp.jsp";
			// フォワード
			forward(url, request, response);
			return;
		}
		/* このインスタンスからディレクトリを生成します。*/
		File tmp_file = new File("csv/user");
		tmp_file.mkdirs();
		
		//登録ユーザ用のcsvファイル作成
		user_file.createNewFile();
		System.out.println(user_file.getAbsolutePath());
		
		Account account=new Account(id,password);
		
		//ユーザリスト用のcsvファイルが存在しないなら作成
		File user_list_file = new File("csv/user_list.csv");
		user_list_file.createNewFile();
		
		//ユーザリスト用のcsvファイルに追記
		BufferedWriter bw = new BufferedWriter(new FileWriter(user_list_file));
		bw.write(account.getId()+","+account.getPassword());
		bw.newLine();
		bw.close();
		// セッションにログイン会員情報を追加
		HttpSession session = request.getSession();
		session.setAttribute("account", account);

		// URL設定
		String url = "/index.jsp";
		// フォワード
		forward(url, request, response);
	}
	
	private void forward(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
