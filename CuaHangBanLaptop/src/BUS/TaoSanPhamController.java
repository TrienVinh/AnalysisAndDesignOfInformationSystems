package BUS;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.SanPhamDAO;
import DAO.SanPhamDAOImp;

public class TaoSanPhamController {
	private JTextField jtfMa, jtfSoLuong, jtfGiaTien, jtfQuocGia;
	private JTextArea jtaTenSP, jtaLinhKien, jtaMoTa;
	private JComboBox<String> jcbMaHang, jcbMaKho, jcbMaSP, jtfMaMau;
	private JLabel jlbMsgSp, jlbMsgChiTiet;
	private JButton jbtnThemSP, jbtnThemChiTiet;

	private SanPhamDAO spDAO;

	public TaoSanPhamController(JTextField jtfMa, JTextField jtfSoLuong, JTextField jtfGiaTien, JTextField jtfQuocGia,
			JTextArea jtaTenSP, JTextArea jtaLinhKien, JTextArea jtaMoTa, JComboBox<String> jcbMaHang,
			JComboBox<String> jcbMaKho, JComboBox<String> jcbMaSP, JComboBox<String> jtfMaMau, JLabel jlbMsgSp,
			JLabel jlbMsgChiTiet, JButton jbtnThemSP, JButton jbtnThemChiTiet) {
		super();
		this.jtfMa = jtfMa;
		this.jtfSoLuong = jtfSoLuong;
		this.jtfGiaTien = jtfGiaTien;
		this.jtfQuocGia = jtfQuocGia;
		this.jtaTenSP = jtaTenSP;
		this.jtaLinhKien = jtaLinhKien;
		this.jtaMoTa = jtaMoTa;
		this.jcbMaHang = jcbMaHang;
		this.jcbMaKho = jcbMaKho;
		this.jcbMaSP = jcbMaSP;
		this.jtfMaMau = jtfMaMau;
		this.jlbMsgSp = jlbMsgSp;
		this.jlbMsgChiTiet = jlbMsgChiTiet;
		this.jbtnThemSP = jbtnThemSP;
		this.jbtnThemChiTiet = jbtnThemChiTiet;

		spDAO = new SanPhamDAOImp();
	}

}
