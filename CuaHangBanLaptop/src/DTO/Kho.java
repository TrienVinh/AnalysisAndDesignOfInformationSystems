package DTO;

public class Kho {
	private int maKho, soKe, soKhu;
	private static final String ma = "K";
	private static int sId = 1000;

	public Kho(int maKho, int soKe, int soKhu) {
		super();
		this.maKho = maKho;
		this.soKe = soKe;
		this.soKhu = soKhu;
	}

	public Kho(String maKho, int soKe, int soKhu) {
		super();
		setMaKho(maKho);
		this.soKe = soKe;
		this.soKhu = soKhu;
	}

	public Kho() {
		super();

		maKho = sId++;
	}

	public Kho(String maKho) {
		super();

		setMaKho(maKho);
	}

	public String getMaKho() {
		return ma + maKho;
	}

	public void setMaKho(int maKho) {
		this.maKho = maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = ClassSupport.getIntFromString(maKho);

	}

	public int getSoKe() {
		return soKe;
	}

	public void setSoKe(int soKe) {
		this.soKe = soKe;
	}

	public int getSoKhu() {
		return soKhu;
	}

	public void setSoKhu(int soKhu) {
		this.soKhu = soKhu;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		Kho.sId = sId;
	}

	public static void setsId(String sId) {
		Kho.sId = ClassSupport.getIntFromString(sId) + 1;
	}

}
