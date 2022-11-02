package DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

public class MySQLConnectUnit {
	private MySQLDatabaseConnect connect;

	public MySQLConnectUnit() {
		super();

		connect = new MySQLDatabaseConnect();
	}

	public MySQLConnectUnit(String hostName, String userName, String passWord, String dataBase) {

		connect = new MySQLDatabaseConnect(hostName, userName, passWord, dataBase);
	}

	public MySQLConnectUnit(String dataBase) {
		connect = new MySQLDatabaseConnect(dataBase);

	}

	// Hàm hỗ trợ SELECT CSDL
	// select columnName ,... from tableName where condition group by(groupBy)
	// having haVing etc...
	public ResultSet select(String columnName, String tableName, String condition, String orderBy, String groupBy,
			String haVing, String etc) {
		// Khai báo StringBuilder để tạo 1 chuỗi select
		StringBuilder query = new StringBuilder("select " + columnName + " from " + tableName);

		// Thêm điều kiện vào câu query
		addCondition(query, condition);

		// Thêm order By cho câu query
		addOrderBy(query, orderBy);

		// Thêm group By vào câu query
		if (groupBy != null)
			query.append(" group by(" + groupBy + ") ");

		// Thêm having vào câu query
		if (haVing != null)
			query.append(" having " + haVing + " ");

		// Thêm 1 số câu lệnh khác vào câu query
		if (etc != null)
			query.append(etc);

		return connect.executeQuery(query.toString());
	}

	public ResultSet select(String columnName, String tableName, String condition) {
		return select(columnName, tableName, condition, null, null, null, null);
	}

	public ResultSet select(String columnName, String tableName) {
		return select(columnName, tableName, null);
	}

	// select * from TableName where Condition order by OrderBy;
	public ResultSet selectAll(String tableName, String conditon, String orderBy) {

		return select("*", tableName, conditon, orderBy, null, null, null);
	}

	// Hàm overLoad của select khi loại bỏ order by
	public ResultSet selectAll(String tableName, String condition) {
		return selectAll(tableName, condition, null);
	}

	// Hàm overload của select khi loại bỏ order by và condition
	public ResultSet selectAll(String tableName) {
		return selectAll(tableName, null);
	}

	public void addCondition(StringBuilder sql, String condition) {
		if (condition != null)
			sql.append(" where " + condition);
	}

	public void addOrderBy(StringBuilder sql, String orderBy) {
		if (orderBy != null)
			sql.append(" order by " + orderBy);
	}

	// Hàm hỗ trợ INSERT vào CSDL
	// Insert into tableName (columnName, ...) values (value1 , ...)
	public boolean insert(String tableName, HashMap<String, Object> columnName) {

		// Khai báo 1 StringBuilder để tạo chuỗi insert
		StringBuilder insert = new StringBuilder("insert into " + tableName);

		// Khai báo 1 StringBuilder để tạo chuỗi column Value
		StringBuilder valueInsert = new StringBuilder();

		insert.append("(");

		// Duyệt và đưa thông tin tên cột và giá trị của cột vào valueInsert
		for (String key : columnName.keySet()) {
			insert.append(key + ",");

			String valueText = columnName.get(key).toString();
			if (columnName.get(key).getClass() == Integer.class || valueText.indexOf("'") != -1)
				valueInsert.append(columnName.get(key) + ",");
			else
				valueInsert.append("'" + valueText + "',");
		}

		// Cắt bớt kí tự ',' cuối câu
		insert = insert.delete(insert.length() - 1, insert.length());
		valueInsert = valueInsert.delete(valueInsert.length() - 1, valueInsert.length());

		// Đưa giá trị của cột vào câu insert
		insert.append(") values (" + valueInsert.toString() + ")");

		// Chèn ký tự ';' vào cuối dòng lệnh để cách các câu query
		insert.append(";");

		return connect.executeUpdate(insert.toString());
	}

	// Hàm hỗ trợ UPDATE CSDL
	// update tableName set columnName = newValue ,... where condition
	public boolean update(String tableName, HashMap<String, Object> columnValue, String condition) {

		// Khai báo 1 StringBuilder để tạo 1 chuỗi update
		StringBuilder update = new StringBuilder("update " + tableName + " set ");

		// Duyệt và đưa thông tin tên cột và giá trị của cột vào câu update
		for (String key : columnValue.keySet()) {
			String valueText = columnValue.get(key).toString();
			if (columnValue.get(key).getClass() == Integer.class || valueText.indexOf("'") != -1)
				update.append(key + " = " + columnValue.get(key).toString() + ",");
			else
				update.append(key + " = '" + columnValue.get(key).toString() + "',");
		}

		// Loại bỏ kí tự ',' ở cuối câu update
		update = update.delete(update.length() - 1, update.length());

		// Thêm điều kiện cho câu update
		addCondition(update, condition);

		// Chèn ký tự ';' vào cuối dòng lệnh để cách các câu query
		update.append(";");

		return connect.executeUpdate(update.toString());
	}

	// Hàm hỗ trợ DELETE CSDL
	// delete from tableName where condition
	public boolean delete(String tableName, String condition) {

		// Khai báo 1 chuỗi StringBuilder để tạo 1 câu delete
		StringBuilder delete = new StringBuilder("delete from " + tableName);

		// Thêm điều kiện vào câu delete
		addCondition(delete, condition);

		// Chèn ký tự ';' vào cuối dòng lệnh để cách các câu query
		delete.append(";");

		return connect.executeUpdate(delete.toString());
	}

	// Đếm số cột trong Result select từ CSDL
	public static int getColumnCount(ResultSet rs) {
		try {
			return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return -1;
	}

	// Hàm lấy danh sách tên cột trong Result select từ CSDL
	public static String[] getColumnName(ResultSet rs) {
		String[] list = new String[0];
		try {
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int columnCount = rsMetaData.getColumnCount();

			list = Arrays.copyOf(list, columnCount);
			for (int i = 0; i < columnCount; i++) {
				list[i] = rsMetaData.getColumnName(i);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

}
