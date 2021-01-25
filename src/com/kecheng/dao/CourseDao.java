package com.kecheng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kecheng.entity.Course;
import com.kecheng.utils.PropertiesUtils;

public class CourseDao {
	public void add(Course course) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into course(cName,tId) values(?,?)";
		queryRunner.update(sql, course.getcName(), course.gettId());
	}

	public void delete(Integer cId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from course where cId = ?";
		queryRunner.update(sql, cId);
	}

	public void update(Course course) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update course set cName = ?,tId = ? where cId = ?";
		queryRunner.update(sql, course.getcName(), course.gettId());
	}

	public List<Course> list(Course course) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from course";
		BeanListHandler<Course> beanListHandler = new BeanListHandler<>(Course.class);
		List<Course> list = queryRunner.query(sql, beanListHandler);
		return list;
	}

	public Course findById(Integer cId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from course where cId = ?";
		BeanHandler<Course> beanHandler = new BeanHandler<>(Course.class);
		Course course = queryRunner.query(sql, beanHandler, cId);
		return course;
	}

}
