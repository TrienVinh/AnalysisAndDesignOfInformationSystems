package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.KhachHang;
import DTO.Person;

public class KhachHangDAOImp implements KhachHangDAO {

	private MySQLConnectUnit connectUnit;
	private String tableName = "khach_hang";

	public KhachHangDAOImp() {
		super();

		connectUnit = new MySQLConnectUnit();
	}

	@Override
	public List<Person> getListKhachHang() {

		List<Person> listItem = new ArrayList<Person>();
		try {
			ResultSet rs = connectUnit.selectAll(tableName);
			while (rs.next()) {
				Person kh = new KhachHang(rs.getString("ma_khach_hang"));
				kh.setChucVu("");
				kh.setDiaChi(rs.getString("dia_chi"));
				kh.setEmail(rs.getString("email"));
				kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
				kh.setHo(rs.getString("ho"));
				kh.setTen(rs.getString("ten"));
				kh.setNgaySinh(rs.getDate("ngay_sinh"));
				kh.setSoDienThoai(rs.getString("so_dien_thoai"));
				listItem.add(kh);
			}
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addKhachHang(Person kh) {
		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_khach_hang", kh.getMaDoiTuong());
		columnName.put("ho", "N'" + kh.getHo() + "'");
		columnName.put("ten", "N'" + kh.getTen() + "'");
		columnName.put("gioi_tinh", kh.isGioiTinh() ? 1 : 0);
		columnName.put("ngay_sinh", new SimpleDateFormat("yyyy-MM-dd").format(kh.getNgaySinh()));
		columnName.put("dia_chi", "N'" + kh.getDiaChi() + "'");
		columnName.put("email", kh.getEmail());
		columnName.put("so_dien_thoai", kh.getSoDienThoai());
		return connectUnit.insert(tableName, columnName);
	}

	@Override
	public boolean editKhachHang(Person kh) {
		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ho", "N'" + kh.getHo() + "'");
		columnValue.put("ten", "N'" + kh.getTen() + "'");
		columnValue.put("gioi_tinh", kh.isGioiTinh() ? 1 : 0);
		columnValue.put("ngay_sinh", new SimpleDateFormat("yyyy-MM-dd").format(kh.getNgaySinh()));
		columnValue.put("dia_chi", "N'" + kh.getDiaChi() + "'");
		columnValue.put("email", kh.getEmail());
		columnValue.put("so_dien_thoai", kh.getSoDienThoai());
		String condition = " ma_khach_hang = '" + kh.getMaDoiTuong() + "'";
		return connectUnit.update(tableName, columnValue, condition);
	}

	@Override
	public boolean removeKhachHang(String maKH) {
		String condition = " ma_khach_hang = '" + maKH + "'";
		return connectUnit.delete(tableName, condition);
	}

}
