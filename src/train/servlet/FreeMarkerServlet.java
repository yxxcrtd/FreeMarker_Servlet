package train.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@WebServlet("/servlet")
@SuppressWarnings("serial")
public class FreeMarkerServlet extends HttpServlet {

	/**
	 * 初始化实例
	 */
	private Configuration cfg = null;
	
	/* (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		cfg = new Configuration();
		
		// 设置模板加载的目录
		cfg.setServletContextForTemplateLoading(getServletContext(), File.separator);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("中文123！");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Hello,FreeMarker模板123");
		map.put("time", new Date());
		map.put("abc", "123");
		
		// 使用Configuration实例加载指定的模板文件
		Template template = cfg.getTemplate("test.ftl");
		try {
			// 合并数据模型和模板，并将结果输出到：response.getWriter()中
			template.process(map, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
