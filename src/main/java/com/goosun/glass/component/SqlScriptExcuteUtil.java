package com.goosun.glass.component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class SqlScriptExcuteUtil {

	/**
	 * @param sql
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> executeSingleSql4Query(String sql,
			DataSource dataSource) throws Exception {
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
			ResultSetMetaData metaData = resultSet.getMetaData();
			while (resultSet.next()) {
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					Map<String, String> map = new LinkedHashMap<String, String>();
					map.put(metaData.getCatalogName(i), resultSet.getString(i));
					list.add(map);
				}
			}
			con.commit();
			return list;
		} catch (Exception e) {
			if (null != con) {
				con.rollback();
			}
			throw new Exception(e.getMessage());
		} finally {
			if (null != resultSet) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception e) {
					throw new RuntimeException("资源释放失败！");
				}
			}
			if (null != statement) {
				try {
					statement.close();
					statement = null;
				} catch (Exception e) {
					throw new RuntimeException("资源释放失败！");
				}
			}
			if (null != con) {
				try {
					con.close();
					con = null;
				} catch (Exception e) {
					throw new RuntimeException("资源释放失败！");
				}
			}
		}
	}
	
	public void executeBatchSql(List<String> sqls, DataSource dataSource)
			throws SQLException {
		Connection con = dataSource.getConnection();
		con.setAutoCommit(false);
		Statement statement = con.createStatement();
		try{
			executeBatchSql(sqls, statement);
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally{
			statement.close();
			con.close();
		}
	}
	
	private void executeBatchSql(List<String> sqls, Statement statement)
			throws SQLException {
		for (int i = 0; i < sqls.size(); i = 0) {
			String sql = sqls.get(i);
			sqls.remove(i);
			if(sql==null || "".equals(sql.trim())){
				continue;
			}
			statement.addBatch(sql);
			if (i / 50 == 0) {
				try {
					statement.executeBatch();
				} catch (SQLException e) {
					System.err.println("错误SQL：" + sql);
					if (sql.toLowerCase().trim().indexOf("drop")==-1) {
						throw new SQLException(sql, e);
					}
				}
			}
		}
	}
}
