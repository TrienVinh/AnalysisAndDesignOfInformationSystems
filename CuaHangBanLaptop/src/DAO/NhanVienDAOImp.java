package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.NhanVien;
import DTO.Person;

public class NhanVienDAOImp implements NhanVienDAO {

	private MySQLConnectUnit connectUnit;
	private String tableName;

	public NhanVienDAOImp() {
		super();
		connectUnit = new MySQLConnectUnit();
		tableName = "nhan_vien";
	}

	@Override
	public List<Person> getListNhanVien() {

		List<Person> listItem = new ArrayList<Person>();
		try {
			ResultSet rs = connectUnit.selectAll(tableName);
			while (rs.next()) {
				Person kh = new NhanVien(rs.getString("ma_nhan_vien"));
				kh.setChucVu(rs.getString("chuc_vu"));
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
	public boolean addNhanVien(Person nv) {
		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ma_nhan_vien", nv.getMaDoiTuong());
		columnName.put("ho", "N'" + nv.getHo() + "'");
		columnName.put("ten", "N'" + nv.getTen() + "'");
		columnName.put("gioi_tinh", nv.isGioiTinh() ? 1 : 0);
		columnName.put("ngay_sinh", new SimpleDateFormat("yyyy-MM-dd").format(nv.getNgaySinh()));
		columnName.put("dia_chi", "N'" + nv.getDiaChi() + "'");
		columnName.put("email", nv.getEmail());
		columnName.put("so_dien_thoai", nv.getSoDienThoai());
		columnName.put("chuc_vu", nv.getChucVu());
		return connectUnit.insert(tableName, columnName);
	}

	@Override
	public boolean editNhanVien(Person nv) {
		HashMap<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("ho", "N'" + nv.getHo() + "'");
		columnName.put("ten", "N'" + nv.getTen() + "'");
		columnName.put("gioi_tinh", nv.isGioiTinh() ? 1 : 0);
		columnName.put("ngay_sinh", new SimpleDateFormat("yyyy-MM-dd").format(nv.getNgaySinh()));
		columnName.put("dia_chi", "N'" + nv.getDiaChi() + "'");
		columnName.put("email", nv.getEmail());
		columnName.put("so_dien_thoai", nv.getSoDienThoai());
		columnName.put("chuc_vu", nv.getChucVu());
		String condition = "ma_nhan_vien = '" + nv.getMaDoiTuong() + "'";
		return connectUnit.update(tableName, columnName, condition);
	}

	@Override
	public boolean removeNhanVien(String maNV) {
		String condition = " ma_nhan_vien = '" + maNV + "'";
		return connectUnit.delete(tableName, condition);
	}

}
