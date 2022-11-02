package DTO;

public class MauSac {
	private int maMau;
	private String tenMau;

	private static int sId = 1000;
	private static final String ma = "MS";

	public MauSac(int maMau, String tenMau) {
		super();
		this.maMau = maMau;
		this.tenMau = tenMau;
	}

	public MauSac(String maMau, String tenMau) {
		super();
		this.tenMau = tenMau;
		setMaMau(maMau);
	}

	public MauSac() {
		super();

		maMau = sId++;
	}

	public MauSac(String maMau) {
		super();

		setMaMau(maMau);
	}

	public String getMaMau() {
		return ma + maMau;
	}

	public void setMaMau(int maMau) {
		this.maMau = maMau;
	}

	public void setMaMau(String maMau) {
		this.maMau = ClassSupport.getIntFromString(maMau);
	}

	public String getTenMau() {
		return tenMau;
	}

	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		MauSac.sId = sId;
	}

	public static void setsId(String sId) {
		MauSac.sId = ClassSupport.getIntFromString(sId) + 1;
	}

}
