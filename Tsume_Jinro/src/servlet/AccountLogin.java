package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		
		//ユーザーリストのファイル
		File user_list_file = new File("csv/user_list.csv");
		BufferedReader br = new BufferedReader(new FileReader(user_list_file));
		if (!(user_list_file.exists())){
			user_list_file.createNewFile();
		}
		// パラメータ受け取り
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("pass");
		String[] user_data=new String[2];
		boolean result=true;
		String read_line;
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
		
		//登録済みのユーザかチェック
		read_line = br.readLine();
		while(true){
			user_data=read_line.split(",");
			if( ( id.equals(user_data[0])) && (password.equals(user_data[1])) ){
				result=true;
				break;
			}
			//ファイル全て読み込み完了している場合にブレイク
			read_line = br.readLine();
			if(read_line==null){
				result=false;
				break;
			}
		}
		//IDとパスワードが完全一致するものが無い場合にエラー出力
		if(!result){
			errorMessage.append(String.format(MessageString.M04W, "ID")
					+ "<br>");
		}
		
		


		
		br.close();
		
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
		
		//セッションに情報登録
		Account account=new Account(id,password);
		HttpSession session = request.getSession();
		if(!(session.getAttributeNames()==null)){
			session.invalidate();
			session = request.getSession();
		}
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
