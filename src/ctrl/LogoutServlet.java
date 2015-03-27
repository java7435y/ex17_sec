package ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException{

		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.setAttribute("msg", "ログアウトしました");

		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
	}

}
