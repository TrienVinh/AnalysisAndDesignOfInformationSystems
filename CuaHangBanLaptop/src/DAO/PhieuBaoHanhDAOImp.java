package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.PhieuBaoHanh;

public class PhieuBaoHanhDAOImp implements PhieuBaoHanhDAO {

	private MySQLConnectUnit connect;
	private String tableName;

	public PhieuBaoHanhDAOImp() {
		super();

		connect = new MySQLConnectUnit();
		tableName = "phieu_bao_hanh";
	}

	@Override
	public List<PhieuBaoHanh> getListBaoHanh() {

		List<PhieuBaoHanh> listItem = new ArrayList<PhieuBaoHanh>();
		try {
			ResultSet rs = connect.selectAll(tableName);
			while (rs.next()) {
				PhieuBaoHanh bh = new PhieuBaoHanh(rs.getString("ma_bao_hanh"));
				bh.setChinhSach(rs.getString("chinh_sach_bao_hanh"));
				bh.setLyDo(rs.getString("ly_do_bao_hanh"));
				bh.setMaKH(rs.getString("ma_khach_hang"));
				bh.setMaSP(rs.getString("ma_san_pham"));
				bh.setThoiGianBaoHanh(rs.getDate("thoi_gian_bao_hanh"));
				listItem.add(bh);
			}
			return listItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addBaoHanh(PhieuBaoHanh pbh) {
		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ma_bao_hanh", pbh.getMaPhieuBH());
		columnValue.put("ma_san_pham", pbh.getMaSP());
		columnValue.put("ma_khach_hang", pbh.getMaKH());
		columnValue.put("thoi_gian_bao_hanh", new SimpleDateFormat("yyyy-MM-dd").format(pbh.getThoiGianBaoHanh()));
		columnValue.put("ly_do_bao_hanh", "N'" + pbh.getLyDo() + "',");
		columnValue.put("chinh_sach_bao_hanh", "N'" + pbh.getChinhSach() + "')");
		return connect.insert(tableName, columnValue);
	}

	@Override
	public boolean editBaoHanh(PhieuBaoHanh pbh) {
		HashMap<String, Object> columnValue = new HashMap<String, Object>();
		columnValue.put("ma_san_pham", pbh.getMaSP());
		columnValue.put("ma_khach_hang", pbh.getMaKH());
		columnValue.put("thoi_gian_bao_hanh", new SimpleDateFormat("yyyy-MM-dd").format(pbh.getThoiGianBaoHanh()));
		columnValue.put("ly_do_bao_hanh", "N'" + pbh.getLyDo() + "',");
		columnValue.put("chinh_sach_bao_hanh", "N'" + pbh.getChinhSach() + "')");
		String condition = "ma_bao_hanh = '" + pbh.getMaPhieuBH() + "'";

		return connect.update(tableName, columnValue, condition);
	}

	@Override
	public boolean removeBaoHanh(String pbh) {
		return connect.delete(tableName, " ma_bao_hanh = '" + pbh + "'");
	}

}
