package com.kecheng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.kecheng.dao.AdminDao;
import com.kecheng.dao.StudentDao;
import com.kecheng.dao.TeacherDao;
import com.kecheng.entity.Admin;
import com.kecheng.entity.Student;
import com.kecheng.entity.Teacher;
import com.kecheng.utils.MD5;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String type = req.getParameter("type");
		HttpSession session = req.getSession();
		if (StringUtils.isBlank(userName)||StringUtils.isBlank(password)||StringUtils.isBlank(type)) {
			req.setAttribute("error", "录入信息不能为空"); 
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		if (StringUtils.isNotBlank(type)) {
			try {
				if ("0".equals(type)) {
					// 学生登录
					Student student = new StudentDao().login(userName, MD5.EncodeByMd5(password));
					if (student != null) {
						// 执行跳转
						session.setAttribute("user",student);
						session.setAttribute("type", type);
						resp.sendRedirect("index.jsp");
					} else {
						// 用户或密码错误
						session.setAttribute("error","用户名或密码错误");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
				} else if ("1".equals(type)) {
					// 教师登录
					Teacher teacher = new TeacherDao().login(userName, MD5.EncodeByMd5(password));
					if (teacher != null) {
						// 执行跳转
						session.setAttribute("user",teacher);
						session.setAttribute("type", type);
						resp.sendRedirect("index.jsp");
					} else {
						// 用户或密码错误
						session.setAttribute("error","用户名或密码错误");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
				} else {
					// 管理员登录
					Admin admin = new Admin();
					admin.setAccount(userName);
					admin.setPwd(MD5.EncodeByMd5(password));
					Admin entity = new AdminDao().login(admin);
					if (entity != null) {
						// 执行跳转
						session.setAttribute("user",entity);
						session.setAttribute("type", type);
						resp.sendRedirect("index.jsp");
					} else {
						// 用户或密码错误
						session.setAttribute("error","用户名或密码错误");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {

		}
	}
}
