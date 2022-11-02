package DTO;

import java.util.Date;

public class PhieuXuat extends HoaDon {
	private static int sId = 1000;
	private static final String ma = "HDPX";

	public PhieuXuat() {
		super(getsId());

		sId++;
	}

	public PhieuXuat(String maHD, int tongSoLuong, int tongTien, String maKH, String maNV, Date ngayMua) {
		super(maHD, tongSoLuong, tongTien, maKH, maNV, ngayMua);

	}

	public PhieuXuat(String maHD) {
		super(maHD);

	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		PhieuXuat.sId = sId;
	}

	public static void setsId(String sId) {
		PhieuXuat.sId = ClassSupport.getIntFromString(sId) + 1;
	}

}
