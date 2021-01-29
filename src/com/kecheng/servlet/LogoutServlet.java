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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("login.jsp");
	}
}
