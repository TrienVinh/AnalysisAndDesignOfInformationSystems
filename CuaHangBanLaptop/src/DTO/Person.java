package DTO;

import java.util.Date;

public class Person {

	private String maDoiTuong, ho, ten, diaChi, email, soDienThoai, chucVu;
	private Date ngaySinh;
	private boolean gioiTinh;

	public Person(String maDoiTuong, String ho, String ten, String diaChi, String email, String soDienThoai,
			Date ngaySinh, boolean gioiTinh, String chucVu) {
		super();
		this.maDoiTuong = maDoiTuong;
		this.ho = ho;
		this.ten = ten;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
	}

	public Person(String maDT) {
		super();

		this.maDoiTuong = maDT;
	}

	public Person() {
		super();

	}

	public String getMaDoiTuong() {
		return maDoiTuong;
	}

	public void setMaDoiTuong(String maDoiTuong) {
		this.maDoiTuong = maDoiTuong;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoTen() {
		return ho + " " + ten;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

}
