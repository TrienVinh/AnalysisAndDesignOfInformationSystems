package DTO;

public class NhaCungCap {
	private int maNCC;
	private String hoTen, diaChi, soDienThoai;
	private static int sId = 1000;
	private static final String ma = "NCC";

	public NhaCungCap(int maNCC, String hoTen, String diaChi, String soDienThoai) {
		super();
		this.maNCC = maNCC;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public NhaCungCap(String maNCC, String hoTen, String diaChi, String soDienThoai) {
		super();
		setMaNCC(maNCC);
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public NhaCungCap() {
		super();
		maNCC = sId++;
	}

	public NhaCungCap(String maNCC) {
		super();
		setMaNCC(maNCC);
	}

	public String getMaNCC() {
		return ma + maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = ClassSupport.getIntFromString(maNCC);
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		NhaCungCap.sId = sId;
	}

	public static void setsId(String sId) {
		NhaCungCap.sId = ClassSupport.getIntFromString(sId) + 1;
	}

}
