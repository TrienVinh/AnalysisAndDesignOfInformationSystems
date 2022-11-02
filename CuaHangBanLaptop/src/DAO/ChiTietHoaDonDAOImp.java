package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.ChiTietHoaDon;

public class ChiTietHoaDonDAOImp implements ChiTietHoaDonDAO {

	private MySQLConnectUnit connect;

	public ChiTietHoaDonDAOImp() {
		super();

		connect = new MySQLConnectUnit();
	}

	@Override
	public List<ChiTietHoaDon> getListChiTietHoaDon(String tableName) {

		List<ChiTietHoaDon> listItem = new ArrayList<ChiTietHoaDon>();
		try {
			ResultSet rs = connect.selectAll(tableName);
			while (rs.next()) {
				ChiTietHoaDon ct = new ChiTietHoaDon();
				ct.setMaHD(rs.getString("ma_hoa_don"));
				ct.setGiaTien(rs.getInt("gia_tien"));
				ct.setMaSP(rs.getString("ma_san_pham"));
				ct.setSoLuong(rs.getInt("so_luong_mua"));
				ct.setMaMau(rs.getString("ma_mau"));
				listItem.add(ct);
			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addChiTietHoaDon(ChiTietHoaDon hd, String tableName) {
		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_hoa_don", hd.getMaHD());
		columnName.put("gia_tien", hd.getGiaTien());
		columnName.put("ma_san_pham", hd.getMaSP());
		columnName.put("so_luong_mua", hd.getSoLuong());
		columnName.put("ma_mau", hd.getMaMau());

		return connect.insert(tableName, columnName);
	}

	@Override
	public boolean editChiTietHoaDon(ChiTietHoaDon hd, String tableName) {
		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("gia_tien", hd.getGiaTien());
		columnName.put("so_luong_mua", hd.getSoLuong());
		String condition = "ma_hoa_don ='" + hd.getMaHD() + "' and ma_san_pham='" + hd.getMaSP() + "' and ma_mau = '"
				+ hd.getMaMau() + "'";
		return connect.update(tableName, columnName, condition);
	}

	@Override
	public boolean removeChiTietHoaDon(ChiTietHoaDon hd, String tableName) {
		String condition = "ma_hoa_don ='" + hd.getMaHD() + "' and ma_san_pham='" + hd.getMaSP() + "' and ma_mau = '"
				+ hd.getMaMau() + "'";
		return connect.delete(tableName, condition);
	}

	public static void main(String[] args) {
		ChiTietHoaDonDAO hdDAO = new ChiTietHoaDonDAOImp();
		List<ChiTietHoaDon> list = hdDAO.getListChiTietHoaDon("chi_tiet_hoa_don_xuat");
		for (ChiTietHoaDon hd : list) {
			System.out.println(hd.getMaHD() + " " + hd.getMaSP());
		}
	}
}
