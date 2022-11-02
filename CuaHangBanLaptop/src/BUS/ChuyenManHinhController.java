package BUS;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import GUI.DanhMucKhachHangPanel;
import GUI.DanhMucNhanVienPanel;

public class ChuyenManHinhController {
	private JMenuItem jmiDMKhachHang, jmiDMNhanVien, jmiDMNCC, jmiDMHang, jmiDMMauSac, jmiSPAdd, jmiSPList,
			jmiBHLapHoaDon, jmiBHQuanLy;
	private JPanel jpnView;

	public ChuyenManHinhController(JMenuItem jmiDMKhachHang, JMenuItem jmiDMNhanVien, JMenuItem jmiDMNCC,
			JMenuItem jmiDMHang, JMenuItem jmiDMMauSac, JMenuItem jmiSPAdd, JMenuItem jmiSPList,
			JMenuItem jmiBHLapHoaDon, JMenuItem jmiBHQuanLy, JPanel jpnView) {
		super();
		this.jmiDMKhachHang = jmiDMKhachHang;
		this.jmiDMNhanVien = jmiDMNhanVien;
		this.jmiDMNCC = jmiDMNCC;
		this.jmiDMHang = jmiDMHang;
		this.jmiDMMauSac = jmiDMMauSac;
		this.jmiSPAdd = jmiSPAdd;
		this.jmiSPList = jmiSPList;
		this.jmiBHLapHoaDon = jmiBHLapHoaDon;
		this.jmiBHQuanLy = jmiBHQuanLy;
		this.jpnView = jpnView;
	}

	public void setView() {

	}

	public void setEvent() {
		jmiDMKhachHang.addActionListener(new JMenuItemEvent(new DanhMucKhachHangPanel()));
		jmiDMNhanVien.addActionListener(new JMenuItemEvent(new DanhMucNhanVienPanel()));
	}

	public class JMenuItemEvent implements ActionListener {
		private JPanel jpn;

		public JMenuItemEvent(JPanel jpn) {
			super();
			this.jpn = jpn;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jpnView.removeAll();
			jpnView.setLayout(new BorderLayout());
			jpnView.add(jpn);
			jpnView.validate();
			jpnView.repaint();
		}

	}
}
