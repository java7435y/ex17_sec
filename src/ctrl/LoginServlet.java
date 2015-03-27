package ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BbsDTO;
import dao.BbsDAO;
import dao.UsrDAO;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException{

		request.setCharacterEncoding("utf-8");

		String btn = request.getParameter("btn");


		String id = null;

		HttpSession session = request.getSession();
		BbsDAO bDao = new BbsDAO();

		if(btn.equals("LOGIN")){

			id = request.getParameter("id");
			String pass = request.getParameter("pass");
			if(id.length() == 0 || pass.length() == 0){
				session.setAttribute("msg", "ユーザ名またはパスワードが未入力です");
				response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
				return;
			}
			UsrDAO uDao = new UsrDAO();
			String loginId = uDao.select(id,pass);
			if(loginId == null){
				session.setAttribute("msg", "ユーザ名またはパスワードが違います");
				response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
				return;
			}
			session.setAttribute("id", loginId);
		}else if(btn.equals("呟く")){
			String msg = request.getParameter("message");
			System.out.println("メッセージ:" + msg);
			bDao.insert((String)session.getAttribute("id"), msg);
		}


		List<BbsDTO> bbsList = bDao.select();
		session.setAttribute("list", bbsList);

		RequestDispatcher dispatch =
			request.getRequestDispatcher("jsp/bbs.jsp");
		dispatch.forward(request, response);
	}

}
