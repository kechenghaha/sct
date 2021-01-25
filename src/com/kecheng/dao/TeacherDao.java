package com.kecheng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kecheng.entity.Teacher;
import com.kecheng.utils.PropertiesUtils;

public class TeacherDao {
	public void add(Teacher teacher) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into teacher(tName,account,pwd) values(?,?,?)";
		queryRunner.update(sql, teacher.gettName(), teacher.getAccount(), teacher.getPwd());
	}

	public void delete(Integer tId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from teacher where tId = ?";
		queryRunner.update(sql, tId);
	}

	public void update(Teacher teacher) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update teacher set tName = ?,pwd = ? where tId = ?";
		queryRunner.update(sql, teacher.gettName(), teacher.getPwd());
	}

	public List<Teacher> list(Teacher teacher) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from teacher";
		BeanListHandler<Teacher> beanListHandler = new BeanListHandler<>(Teacher.class);
		List<Teacher> list = queryRunner.query(sql, beanListHandler);
		return list;
	}

	public Teacher findById(Integer tId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from teacher where tId = ?";
		BeanHandler<Teacher> beanHandler = new BeanHandler<>(Teacher.class);
		Teacher teacher = queryRunner.query(sql, beanHandler, tId);
		return teacher;
	}

	public Teacher login(String account, String pwd) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from teacher where account = ? and pwd = ?";
		BeanHandler<Teacher> beanHandler = new BeanHandler<>(Teacher.class);
		Teacher teacher = queryRunner.query(sql, beanHandler, account, pwd);
		return teacher;
	}
}
