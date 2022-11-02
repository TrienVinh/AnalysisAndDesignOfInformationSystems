package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.Hang;

public class HangDAOImp implements HangDAO {

	private MySQLConnectUnit connectUnit;
	private String tableName;

	public HangDAOImp() {
		super();

		connectUnit = new MySQLConnectUnit();
		tableName = "hang";
	}

	@Override
	public List<Hang> getListHang() {

		List<Hang> listItem = new ArrayList<Hang>();
		try {

			ResultSet rs = connectUnit.selectAll(tableName);
			while (rs.next()) {
				Hang h = new Hang();
				h.setMaHang(rs.getString("ma_hang"));
				h.setDiaChi(rs.getString("dia_chi"));
				h.setTenHang(rs.getString("ten_hang"));
				listItem.add(h);

			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addHang(Hang h) {

		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_hang", h.getMaHang());
		columnName.put("ten_hang", "N'" + h.getTenHang() + "'");
		columnName.put("dia_chi", "N'" + h.getDiaChi() + "'");
		return connectUnit.insert(tableName, columnName);
	}

	@Override
	public boolean editHang(Hang h) {

		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ten_hang", "N'" + h.getTenHang() + "'");
		columnValue.put("dia_chi", "N'" + h.getDiaChi() + "'");

		String condition = "ma_hang = '" + h.getMaHang() + "'";
		return connectUnit.update(tableName, columnValue, condition);
	}

	@Override
	public boolean removeHang(String maH) {

		return connectUnit.delete(tableName, "ma_hang = '" + maH + "'");
	}

}
