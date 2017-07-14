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
 * 通过ServletContext获取工程classes(src)路径下的文件
 * 获取路径以后可执行上传下载等操作
 * Servlet implementation class Servlet01
 */
public class Servlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext sc = config.getServletContext();
		//获取webroot下WEB-INF路径下的文件
		//getRealPath的参数不会被校验，只有真正要用这个路径的时候才会知道路径是否存在
		String path2 = sc.getRealPath("/");  // 获取工程根目录
//		System.out.println(path1);
		
		
		//通过流获取工程目录classpath下的资源文件流，用于classpath下的文件发布之后
		//是在/WEB-INF/classes/下，所以指定/WEB-INF/classes/test1.properties
		//方式1：
		InputStream in = sc.getResourceAsStream("/WEB-INF/classes/test1.properties");
		Properties prop = new Properties();
		
		try {
			prop.load(in);
			System.out.println(prop.get("key1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//方式2：
		InputStream in1 = this.getClass().getClassLoader().getResourceAsStream("test1.properties");
		Properties prop1 = new Properties();
		try {
			prop1.load(in1);
			System.out.println(prop1.get("key1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet04() {
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
