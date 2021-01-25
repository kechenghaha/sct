package com.kecheng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kecheng.entity.Sc;
import com.kecheng.utils.PropertiesUtils;

public class ScDao {
	public void add(Sc sc) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into sc(cId,stuId,score) values(?,?,?)";
		queryRunner.update(sql, sc.getcId(), sc.getStuId(), sc.getScore());
	}

	public void delete(Integer id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from sc where id = ?";
		queryRunner.update(sql, id);
	}

	public void update(Sc sc) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update admin set score = ? where id = ?";
		queryRunner.update(sql, sc.getScore());
	}

	public List<Sc> list(Sc sc) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from sc";
		BeanListHandler<Sc> beanListHandler = new BeanListHandler<>(Sc.class);
		List<Sc> list = queryRunner.query(sql, beanListHandler);
		return list;
	}

	public Sc findById(Integer id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from sc where id = ?";
		BeanHandler<Sc> beanHandler = new BeanHandler<>(Sc.class);
		Sc sc = queryRunner.query(sql, beanHandler, id);
		return sc;
	}
}
