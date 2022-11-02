package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.HoaDon;

public class HoaDonDAOImp implements HoaDonDAO {

	private MySQLConnectUnit connect;

	public HoaDonDAOImp() {
		super();

		connect = new MySQLConnectUnit();
	}

	@Override
	public List<HoaDon> getListHoaDon(String tableName) {

		List<HoaDon> listItem = new ArrayList<HoaDon>();
		try {
			ResultSet rs = connect.selectAll(tableName);
			while (rs.next()) {
				HoaDon hd = new HoaDon(rs.getString(1));
				hd.setMaKH(rs.getString(2));
				hd.setMaNV(rs.getString(3));
				hd.setNgayMua(rs.getDate(4));
				hd.setTongSoLuong(rs.getInt(5));
				hd.setTongTien(rs.getInt(6));
				listItem.add(hd);
			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addHoaDon(HoaDon hd, String tableName) {

		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ma_hoa_don", hd.getMaHD());

		columnValue.put("ma_nhan_vien", hd.getMaNV());
		columnValue.put("ngay_mua", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(hd.getNgayMua()));
		columnValue.put("tong_so_luong", hd.getTongSoLuong());
		columnValue.put("tong_tien", hd.getTongTien());
		if (tableName.compareTo("hoa_don_nhap") == 0) {
			columnValue.put("ma_NCC", hd.getMaKH());
		} else
			columnValue.put("ma_khach_hang", hd.getMaKH());
		return connect.insert(tableName, columnValue);

	}

	@Override
	public boolean editHoaDon(HoaDon hd, String tableName) {

		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ma_nhan_vien", hd.getMaNV());
		columnValue.put("ngay_mua", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(hd.getNgayMua()));
		columnValue.put("tong_so_luong", hd.getTongSoLuong());
		columnValue.put("tong_tien", hd.getTongTien());
		if (tableName.compareTo("hoa_don_nhap") == 0) {
			columnValue.put("ma_NCC", hd.getMaKH());
		} else
			columnValue.put("ma_khach_hang", hd.getMaKH());
		String condition = "ma_hoa_don ='" + hd.getMaHD() + "'";
		return connect.update(tableName, columnValue, condition);
	}

	@Override
	public boolean removeHoaDon(String hd, String tableName) {

		String condition = "ma_hoa_don ='" + hd + "'";
		return connect.delete(tableName, condition);
	}

	@Override
	public String getLastId(String tableName) {

		try {
			String id = "";
			String columnName = "max(ma_hoa_don)";
			ResultSet rs = connect.select(columnName, tableName);
			while (rs.next()) {
				id = rs.getString(1);
			}
			return id;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		HoaDonDAO hdDAO = new HoaDonDAOImp();
		List<HoaDon> list = hdDAO.getListHoaDon("hoa_don_xuat");
		for (HoaDon hd : list) {
			System.out.println(hd.getMaHD());
		}
	}
}
