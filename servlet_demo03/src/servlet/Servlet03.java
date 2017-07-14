package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过ServletContext获取工程webroot下WEB-INF路径下的文件
 * 获取路径以后可执行上传下载等操作
 * Servlet implementation class Servlet01
 */
public class Servlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext sc = config.getServletContext();
		//获取webroot下WEB-INF路径下的文件
		//getRealPath的参数不会被校验，只有真正要用这个路径的时候才会知道路径是否存在
		String path = sc.getRealPath("text.properties");
		String path1 = sc.getRealPath("/upload");
		String path2 = sc.getRealPath("/");  // 获取工程根目录
//		System.out.println(path1);
//		System.out.println(path);
		
		
		//通过流获取工程目录文件夹下文件key对应的value
		InputStream in = sc.getResourceAsStream("/WEB-INF/test.properties");
		Properties prop = new Properties();
		
		try {
			prop.load(in);
			System.out.println(prop.get("key"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//获取ServletContext容器对象
//		ServletContext sc = getServletContext();
//		//通过容器对象获取全局的属性值
//		//pvcount 访问Servlet01的次数
//		Integer pvcount = (Integer) sc.getAttribute("pvcount");
//		if(pvcount == null){
//			sc.setAttribute("pvcount", 1);
//		}else{
//			sc.setAttribute("pvcount", ++pvcount);
//		}
//		pvcount = (Integer) sc.getAttribute("pvcount");
//		String result = "<font color='red' size='20'>--当前站点被点击了"+pvcount+"次</font>";
//		response.getOutputStream().write(result.getBytes());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
