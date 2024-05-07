package hamBurGer.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hamBurGer.dao.hamDAO;
import hamBurGer.vo.hamVO;

@WebServlet("/hamList.json")
public class hamListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		hamDAO hdao = new hamDAO();
		List<hamVO> hlist = hdao.selectHam();
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(hlist);
		
		System.out.println(json);
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().println(json);
	}
}
