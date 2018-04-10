package com.goosun.glass.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EachTestInitialization {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlScriptExcuteUtil sqlScriptExcuteUtil;
	
	@Value("${spring.datasource.database-name}")
	private String databaseName;
	
	
	
	public void init() throws Exception {
		String truncateSql = "SELECT CONCAT('truncate table ', table_name) FROM INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='"
				+databaseName+"' and table_name<>'flyway_schema_history'";
		SelectSqlToExcute(truncateSql, dataSource);
		
	}
	
	private void SelectSqlToExcute(String sql, DataSource dataSource)
			throws Exception {
		List<Map<String, String>> list = sqlScriptExcuteUtil
				.executeSingleSql4Query(sql, dataSource);
		List<String> proccessSqls = new ArrayList<String>();
		for (Map<String, String> map : list) {
			if (null != map && map.size() > 0) {
				for (Entry<String, String> entry : map.entrySet()) {
					proccessSqls.add(entry.getValue());
					//logger.info(entry.getValue());
					
				}
			}
			if (proccessSqls.size() > 0) {
				sqlScriptExcuteUtil.executeBatchSql(proccessSqls, dataSource);
			}
		}
	}
	
	
}
