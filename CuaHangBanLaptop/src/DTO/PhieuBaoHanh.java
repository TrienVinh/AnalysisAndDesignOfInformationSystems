package DTO;

import java.util.Date;

public class PhieuBaoHanh {
	private int maPhieuBH;
	private String maSP, maKH, lyDo, chinhSach;
	private Date thoiGianBaoHanh;

	private static int sId = 1000;
	private static final String ma = "PBH";

	public PhieuBaoHanh(int maPhieuBH, String maSP, String maKH, String lyDo, String chinhSach, Date thoiGianBaoHanh) {
		super();
		this.maPhieuBH = maPhieuBH;
		this.maSP = maSP;
		this.maKH = maKH;
		this.lyDo = lyDo;
		this.chinhSach = chinhSach;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public PhieuBaoHanh() {
		super();

		maPhieuBH = sId++;
	}

	public PhieuBaoHanh(String maPBH) {
		super();

		setMaPhieuBH(maPBH);
	}

	public String getMaPhieuBH() {
		return ma + maPhieuBH;
	}

	public void setMaPhieuBH(int maPhieuBH) {
		this.maPhieuBH = maPhieuBH;
	}

	public void setMaPhieuBH(String maPhieuBH) {
		this.maPhieuBH = ClassSupport.getIntFromString(maPhieuBH);
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public String getChinhSach() {
		return chinhSach;
	}

	public void setChinhSach(String chinhSach) {
		this.chinhSach = chinhSach;
	}

	public Date getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(Date thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		PhieuBaoHanh.sId = sId;
	}

	public static void setsId(String sId) {
		PhieuBaoHanh.sId = ClassSupport.getIntFromString(sId) + 1;
	}

}
