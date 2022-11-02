package DTO;

import java.util.Date;

public class NhanVien extends Person {

	private static int sId = 1000;
	private static final String ma = "NV";

	public NhanVien(String maDoiTuong, String ho, String ten, String diaChi, String email, String soDienThoai,
			Date ngaySinh, boolean gioiTinh, String chucVu) {
		super(maDoiTuong, ho, ten, diaChi, email, soDienThoai, ngaySinh, gioiTinh, chucVu);
		// TODO Auto-generated constructor stub
	}

	public NhanVien(Person ps) {
		super(ps.getMaDoiTuong(), ps.getHo(), ps.getTen(), ps.getDiaChi(), ps.getEmail(), ps.getSoDienThoai(),
				ps.getNgaySinh(), ps.isGioiTinh(), ps.getChucVu());

	}

	public NhanVien(String maDT) {
		super(maDT);
	}

	public NhanVien() {
		super(getsId());
		sId++;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		NhanVien.sId = sId;
	}

	public static void setsId(String sId) {
		NhanVien.sId = ClassSupport.getIntFromString(sId) + 1;
	}

	public static String getMa() {
		return ma;
	}

}
