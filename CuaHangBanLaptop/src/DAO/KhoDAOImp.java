package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.Kho;

public class KhoDAOImp implements KhoDAO {

	private MySQLConnectUnit connectUnit;
	private String tableName;

	public KhoDAOImp() {
		super();

		connectUnit = new MySQLConnectUnit();
		tableName = "kho";
	}

	@Override
	public List<Kho> getListKho() {

		List<Kho> listItem = new ArrayList<Kho>();
		try {

			ResultSet rs = connectUnit.selectAll(tableName);
			while (rs.next()) {
				Kho k = new Kho(rs.getString("ma_kho"));
				k.setSoKe(rs.getInt("so_ke"));
				k.setSoKhu(rs.getInt("so_khu"));
				listItem.add(k);
			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addKho(Kho k) {

		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_kho", k.getMaKho());
		columnName.put("so_khu", k.getSoKhu());
		columnName.put("so_ke", k.getSoKe());
		return connectUnit.insert(tableName, columnName);
	}

	@Override
	public boolean editKho(Kho k) {

		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("so_ke", k.getSoKe());
		columnValue.put("so_khu", k.getSoKhu());
		String condition = " ma_kho = '" + k.getMaKho() + "'";
		return connectUnit.update(tableName, columnValue, condition);
	}

	@Override
	public boolean removeKho(String k) {

		return connectUnit.delete(tableName, "ma_kho = '" + k + "'");
	}

}
