package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.ChiTietSanPham;

public class ChiTietSanPhamDAOImp implements ChiTietSanPhamDAO {

	private MySQLConnectUnit unit;
	private String tableName;

	public ChiTietSanPhamDAOImp() {
		super();

		tableName = "sanpham_mausac";
		unit = new MySQLConnectUnit();
	}

	@Override
	public List<ChiTietSanPham> getListChiTietSanPham() {

		List<ChiTietSanPham> listItem = new ArrayList<ChiTietSanPham>();
		try {
			ResultSet rs = unit.selectAll(tableName);
			while (rs.next()) {
				ChiTietSanPham ct = new ChiTietSanPham(rs.getString("ma_san_pham"), rs.getString("ma_mau"),
						rs.getInt("so_luong"));
				listItem.add(ct);
			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addChiTietSanPham(ChiTietSanPham sp) {

		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_san_pham", sp.getMaSP());
		columnName.put("ma_mau", sp.getMaMau());
		columnName.put("so_luong", sp.getSoLuong());
		return unit.insert(tableName, columnName);
	}

	@Override
	public boolean editChiTietSanPham(ChiTietSanPham sp) {

		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("so_luong", sp.getSoLuong());
		String condition = "ma_san_pham = '" + sp.getMaSP() + "' and ma_mau = '" + sp.getMaMau() + "'";
		return unit.update(tableName, columnName, condition);
	}

	@Override
	public boolean removeChiTietSanPham(ChiTietSanPham sp) {

		String condition = "ma_san_pham = '" + sp.getMaSP() + "' and ma_mau = '" + sp.getMaMau() + "'";
		return unit.delete(tableName, condition);
	}

}
