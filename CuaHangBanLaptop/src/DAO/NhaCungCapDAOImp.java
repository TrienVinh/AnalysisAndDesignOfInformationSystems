package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.NhaCungCap;

public class NhaCungCapDAOImp implements NhaCungCapDAO {

	private MySQLConnectUnit connectUnit;
	private String tableName;

	public NhaCungCapDAOImp() {
		super();
		connectUnit = new MySQLConnectUnit();
		tableName = "nha_cung_cap";
	}

	@Override
	public List<NhaCungCap> getListNhaCungCap() {

		List<NhaCungCap> listItem = new ArrayList<NhaCungCap>();
		try {
			ResultSet rs = connectUnit.selectAll(tableName);
			while (rs.next()) {
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
				ncc.setDiaChi(rs.getString("diaChi"));
				ncc.setHoTen(rs.getString("hoTen"));
				ncc.setSoDienThoai(rs.getString("soDienThoai"));
				listItem.add(ncc);
			}
			return listItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNhaCungCap(NhaCungCap ncc) {
		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_NCC", ncc.getMaNCC());
		columnName.put("ho_ten", "N'" + ncc.getHoTen() + "'");
		columnName.put("dia_chi", "N'" + ncc.getDiaChi() + "'");
		columnName.put("so_dien_thoai", ncc.getSoDienThoai());
		return connectUnit.insert(tableName, columnName);
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap ncc) {
		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ho_ten", "N'" + ncc.getHoTen() + "'");
		columnValue.put("dia_chi", "N'" + ncc.getDiaChi() + "'");
		columnValue.put("so_dien_thoai", ncc.getSoDienThoai());
		String condition = "maNCC = '" + ncc.getMaNCC() + "'";
		return connectUnit.update(tableName, columnValue, condition);
	}

	@Override
	public boolean removeNhaCungCap(String maNCC) {
		String condition = "maNCC = '" + maNCC + "'";
		return connectUnit.delete(tableName, condition);
	}

}
