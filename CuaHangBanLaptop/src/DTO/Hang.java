package DTO;

public class Hang {
	private int maHang;
	private String tenHang, diaChi;
	private static int sId = 1000;
	private static final String ma = "H";

	public Hang(int maHang, String tenHang, String diaChi) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.diaChi = diaChi;
	}

	public Hang(String maHang, String tenHang, String diaChi) {
		super();
		setMaHang(maHang);
		this.tenHang = tenHang;
		this.diaChi = diaChi;
	}

	public Hang() {
		super();

		maHang = sId++;
	}

	public Hang(String maHang) {
		super();

		setMaHang(maHang);
	}

	public String getMaHang() {
		return ma + maHang;
	}

	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = ClassSupport.getIntFromString(maHang);
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		Hang.sId = sId;
	}

	public static void setsId(String sId) {
		Hang.sId = ClassSupport.getIntFromString(sId) + 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getMaHang() + " " + tenHang + " " + diaChi;
	}
}
