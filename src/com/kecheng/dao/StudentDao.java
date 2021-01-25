package com.kecheng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kecheng.entity.Student;
import com.kecheng.utils.PropertiesUtils;

public class StudentDao {
	public void add(Student student) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into student(stuName,stuNo,pwd) values(?,?,?)";
		queryRunner.update(sql, student.getStuName(), student.getStuNo(), student.getPwd());
	}

	public void delete(Integer stuId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from student where stuId = ?";
		queryRunner.update(sql, stuId);
	}

	public void update(Student student) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update student set stuName = ?,pwd = ? where stuId = ?";
		queryRunner.update(sql, student.getStuName(), student.getPwd());
	}

	public List<Student> list(Student student) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from student";
		BeanListHandler<Student> beanListHandler = new BeanListHandler<>(Student.class);
		List<Student> list = queryRunner.query(sql, beanListHandler);
		return list;
	}

	public Student findById(Integer stuId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from student where stuId = ?";
		BeanHandler<Student> beanHandler = new BeanHandler<>(Student.class);
		Student student = queryRunner.query(sql, beanHandler, stuId);
		return student;
	}

	public Student login(String stuNo, String pwd) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from student where stuNo = ? and pwd = ?";
		BeanHandler<Student> beanHandler = new BeanHandler<>(Student.class);
		Student student = queryRunner.query(sql, beanHandler, stuNo, pwd);
		return student;
	}
}
