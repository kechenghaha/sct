package com.kecheng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kecheng.entity.Admin;
import com.kecheng.utils.PropertiesUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class AdminDao {
	public void add(Admin admin) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into admin(name,account,pwd) values(?,?,?)";
		queryRunner.update(sql, admin.getName(), admin.getAccount(), admin.getPwd());
	}

	public void delete(Integer id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from admin where id = ?";
		queryRunner.update(sql, id);
	}

	public void update(Admin admin) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update admin set name = ?,account = ?,pwd = ? where id = ?";
		queryRunner.update(sql, admin.getName(), admin.getAccount(), admin.getPwd(), admin.getId());
	}

	public List<Admin> list(Admin admin) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from admin";
		BeanListHandler<Admin> beanListHandler = new BeanListHandler<>(Admin.class);
		List<Admin> list = queryRunner.query(sql, beanListHandler);
		return list;
	}

	public Admin findById(Integer id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from admin where id = ?";
		BeanHandler<Admin> beanHandler = new BeanHandler<>(Admin.class);
		Admin admin = queryRunner.query(sql, beanHandler, id);
		return admin;
	}
	
	public Admin login(Admin admin) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from admin where account = ? and pwd = ?";
		Admin entity = queryRunner.query(sql, new BeanHandler<>(Admin.class),admin.getAccount(),admin.getPwd());
		return entity;
	}
}
