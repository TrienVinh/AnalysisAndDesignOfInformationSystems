package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.MauSac;

public class MauSacDAOImp implements MauSacDAO {

	private MySQLConnectUnit connectUnit;
	private String tableName;

	public MauSacDAOImp() {
		super();

		connectUnit = new MySQLConnectUnit();
		tableName = "mau_sac";
	}

	@Override
	public List<MauSac> getListMauSac() {

		List<MauSac> listItem = new ArrayList<MauSac>();
		try {

			ResultSet rs = connectUnit.selectAll(tableName);
			while (rs.next()) {
				MauSac ms = new MauSac(rs.getString("ma_mau"), rs.getString("ten_mau"));
				listItem.add(ms);
			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addMau(MauSac ms) {
		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_mau", ms.getMaMau());
		columnName.put("ten_mau", "N'" + ms.getMaMau() + "'");
		return connectUnit.insert(tableName, columnName);
	}

	@Override
	public boolean editMau(MauSac ms) {

		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ten_mau", "N'" + ms.getTenMau() + "'");
		String condition = " ma_mau = '" + ms.getMaMau() + "'";
		return connectUnit.update(tableName, columnValue, condition);
	}

	@Override
	public boolean removeMau(String maMau) {

		String condition = " ma_mau = '" + maMau + "'";
		return connectUnit.delete(tableName, condition);
	}

}
