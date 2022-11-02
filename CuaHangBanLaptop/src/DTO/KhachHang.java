package DTO;

import java.util.Date;

public class KhachHang extends Person {
	private static int sId = 1000;
	private static final String ma = "KH";

	public KhachHang(String maDoiTuong, String ho, String ten, String diaChi, String email, String soDienThoai,
			Date ngaySinh, boolean gioiTinh) {
		super(maDoiTuong, ho, ten, diaChi, email, soDienThoai, ngaySinh, gioiTinh, "");
	}

	public KhachHang() {
		super(getMaKH());
		sId++;
	}

	public KhachHang(String maKh) {
		super(maKh);
	}

	public static String getMaKH() {
		return ma + sId;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		KhachHang.sId = sId;
	}

	public static void setsId(String sId) {
		KhachHang.sId = ClassSupport.getIntFromString(sId) + 1;
	}

}
