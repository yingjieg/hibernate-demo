package code.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.Restrictions;

import code.demo.dao.ITestRecordDao;
import code.demo.dao.impl.PlatformDaoImpl;
import code.demo.dao.impl.TestRecordDaoImpl;
import code.demo.model.Platform;
import code.demo.model.TestRecord;

@WebServlet(name = "index", urlPatterns = { "/index" })
public class TestRecordService extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String platformId = req.getParameter("sltPlatform");
		List<Platform> platforms = new PlatformDaoImpl().selectAllPlatform();
		List<TestRecord> records = null;
		ITestRecordDao dao = new TestRecordDaoImpl();
		if (platformId == null) {
			records = dao.selectAllTestRecord();
		} else {
			records = dao.selectTestRecordByRestrictions(Restrictions.eq(
					"platform.id", Short.parseShort(platformId)));
		}
		RequestDispatcher go = req.getRequestDispatcher("./record.jsp");
		req.setAttribute("platforms", platforms);
		req.setAttribute("records", records);

		try {
			go.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
