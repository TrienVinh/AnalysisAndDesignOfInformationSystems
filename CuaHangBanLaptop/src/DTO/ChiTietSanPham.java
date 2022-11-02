package DTO;

public class ChiTietSanPham {
	private String maSP, maMau;
	private int soLuong;

	public ChiTietSanPham(String maSP, String maMau, int soLuong) {
		super();
		this.maSP = maSP;
		this.maMau = maMau;
		this.soLuong = soLuong;
	}

	public ChiTietSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getMaMau() {
		return maMau;
	}

	public void setMaMau(String maMau) {
		this.maMau = maMau;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
