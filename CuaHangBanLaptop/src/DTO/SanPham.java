package DTO;

public class SanPham {
	private int maSP, giaTien;
	private String tenSP, quocGia, moTa, linhKien, maNCC, maKho, maHang;

	private static int sId = 1000;
	private static final String ma = "SP";

	public SanPham(int maSP, int giaTien, String tenSP, String quocGia, String moTa, String linhKien, String maNCC,
			String maKho, String maHang) {
		super();
		this.maSP = maSP;
		this.giaTien = giaTien;
		this.tenSP = tenSP;
		this.quocGia = quocGia;
		this.moTa = moTa;
		this.linhKien = linhKien;
		this.maNCC = maNCC;
		this.maKho = maKho;
		this.maHang = maHang;
	}

	public SanPham() {
		super();

		maSP = sId++;
	}

	public SanPham(String maSP) {
		super();

		setMaSP(maSP);
	}

	public String getMaSP() {
		return ma + maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = ClassSupport.getIntFromString(maSP);
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getLinhKien() {
		return linhKien;
	}

	public void setLinhKien(String linhKien) {
		this.linhKien = linhKien;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		SanPham.sId = sId;
	}

	public static void setsId(String sId) {
		SanPham.sId = ClassSupport.getIntFromString(sId) + 1;
	}

}
