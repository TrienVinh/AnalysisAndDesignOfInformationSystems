package DTO;

import java.util.Date;

public class PhieuNhap extends HoaDon {
	private static int sId = 1000;
	private static final String ma = "HDPN";

	public PhieuNhap() {
		super(getsId());

		sId++;
	}

	public PhieuNhap(String maHD, int tongSoLuong, int tongTien, String maKH, String maNV, Date ngayMua) {
		super(maHD, tongSoLuong, tongTien, maKH, maNV, ngayMua);

	}

	public PhieuNhap(String maHD) {
		super(maHD);

	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		PhieuNhap.sId = sId;
	}

	public static void setsId(String sId) {
		PhieuNhap.sId = ClassSupport.getIntFromString(sId) + 1;
	}
}
