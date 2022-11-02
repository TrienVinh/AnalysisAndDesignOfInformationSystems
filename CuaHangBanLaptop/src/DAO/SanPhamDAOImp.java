package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.SanPham;

public class SanPhamDAOImp implements SanPhamDAO {

	private MySQLConnectUnit unit;
	private String tableName;

	public SanPhamDAOImp() {
		super();

		unit = new MySQLConnectUnit();
		tableName = "san_pham";
	}

	@Override
	public List<SanPham> getListSanPham() {

		List<SanPham> listItem = new ArrayList<SanPham>();
		try {
			ResultSet rs = unit.selectAll(tableName);
			while (rs.next()) {
				SanPham sp = new SanPham(rs.getString("ma_san_pham"));
				sp.setGiaTien(rs.getInt("gia_tien"));
				sp.setLinhKien(rs.getString("linh_kien"));
				sp.setMaHang(rs.getString("ma_hang"));
				sp.setMaKho(rs.getString("ma_kho"));
				sp.setMaNCC(rs.getString("ma_NCC"));
				sp.setMoTa(rs.getString("mo_ta"));
				sp.setQuocGia(rs.getString("quoc_gia"));
				sp.setTenSP(rs.getString("ten_san_pham"));
				listItem.add(sp);
			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addSanPham(SanPham sp) {

		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_san_pham", sp.getMaSP());
		columnName.put("ten_san_pham", "N'" + sp.getTenSP() + "'");
		columnName.put("gia_tien", sp.getGiaTien());
		columnName.put("linh_kien", "N'" + sp.getLinhKien() + "'");
		columnName.put("ma_hang", sp.getMaHang());
		columnName.put("ma_kho", sp.getMaKho());
		columnName.put("ma_NCC", sp.getMaNCC());
		columnName.put("mo_ta", "N'" + sp.getMoTa() + "'");
		columnName.put("quoc_gia", "N'" + sp.getQuocGia() + "'");
		return unit.insert(tableName, columnName);
	}

	@Override
	public boolean editSanPham(SanPham sp) {

		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ten_san_pham", "N'" + sp.getTenSP() + "'");
		columnName.put("gia_tien", sp.getGiaTien());
		columnName.put("linh_kien", "N'" + sp.getLinhKien() + "'");
		columnName.put("ma_hang", sp.getMaHang());
		columnName.put("ma_kho", sp.getMaKho());
		columnName.put("ma_NCC", sp.getMaNCC());
		columnName.put("mo_ta", "N'" + sp.getMoTa() + "'");
		columnName.put("quoc_gia", "N'" + sp.getQuocGia() + "'");
		String condition = "ma_san_pham = '" + sp.getMaSP() + "'";
		return unit.update(tableName, columnName, condition);
	}

	@Override
	public boolean removeSanPham(String sp) {

		String condition = "ma_san_pham = '" + sp + "'";
		return unit.delete(tableName, condition);
	}

	@Override
	public String getLastId() {

		try {
			String columnName = "max(ma_san_pham)";
			ResultSet rs = unit.select(columnName, tableName);
			String id = "";
			while (rs.next()) {
				id = rs.getString(1);
			}
			return id;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
