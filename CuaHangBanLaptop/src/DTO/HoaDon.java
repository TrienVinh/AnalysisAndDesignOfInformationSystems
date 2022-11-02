package DTO;

import java.util.Date;

public class HoaDon {
	private int tongSoLuong, tongTien;
	private String maHD, maKH, maNV;
	private Date ngayMua;

	public HoaDon(String maHD, int tongSoLuong, int tongTien, String maKH, String maNV, Date ngayMua
			) {
		super();
		this.maHD = maHD;
		this.tongSoLuong = tongSoLuong;
		this.tongTien = tongTien;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayMua = ngayMua;
	}
	public HoaDon() {
		super();

	}

	public HoaDon(String maHD) {
		super();

		setMaHD(maHD);
	}

	public int getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	
}
