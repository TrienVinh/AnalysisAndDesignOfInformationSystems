package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.ChuyenManHinhController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class ManHinhChinhFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinhFrame frame = new ManHinhChinhFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManHinhChinhFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 697);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
//		mnFile.setMnemonic(KeyEvent.VK_F);
		mnFile.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnFile);

		JMenu mnNewMenu = new JMenu("Danh mục");
		mnNewMenu.setMnemonic(KeyEvent.VK_D);
		mnNewMenu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);

		JMenuItem jmiDMKhachHang = new JMenuItem("Khách Hàng");
		jmiDMKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(jmiDMKhachHang);

		JMenuItem jmiDMNhanVien = new JMenuItem("Nhân Viên");
		jmiDMNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(jmiDMNhanVien);

		JMenuItem jmiDMNCC = new JMenuItem("NCC");
		jmiDMNCC.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(jmiDMNCC);

		JMenuItem jmiDMHang = new JMenuItem("Hãng");
		jmiDMHang.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(jmiDMHang);

		JMenuItem jmiDMMauSac = new JMenuItem("Màu Sắc");
		jmiDMMauSac.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(jmiDMMauSac);

		JMenu mnSnPhm = new JMenu("Sản Phẩm");
		mnSnPhm.setMnemonic(KeyEvent.VK_S);
		mnSnPhm.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnSnPhm);

		JMenuItem jmiSPAdd = new JMenuItem("Tạo sản phẩm");
		jmiSPAdd.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnSnPhm.add(jmiSPAdd);

		JMenuItem jmiSPList = new JMenuItem("Danh sách ");
		jmiSPList.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnSnPhm.add(jmiSPList);

		JMenu mnBnHng = new JMenu("Bán Hàng");
		mnBnHng.setMnemonic(KeyEvent.VK_H);
		mnBnHng.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnBnHng);

		JMenuItem jmiBHLapHoaDon = new JMenuItem("Lập hoá đơn");
		jmiBHLapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnBnHng.add(jmiBHLapHoaDon);

		JMenuItem jmiBHQuanLy = new JMenuItem("Quản lý");
		jmiBHQuanLy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnBnHng.add(jmiBHQuanLy);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel jpnView = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(jpnView,
				GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(jpnView,
				GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE));
		GroupLayout gl_jpnView = new GroupLayout(jpnView);
		gl_jpnView
				.setHorizontalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 1083, Short.MAX_VALUE));
		gl_jpnView.setVerticalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 650, Short.MAX_VALUE));
		jpnView.setLayout(gl_jpnView);
		contentPane.setLayout(gl_contentPane);

		ChuyenManHinhController control = new ChuyenManHinhController(jmiDMKhachHang, jmiDMNhanVien, jmiDMNCC,
				jmiDMHang, jmiDMMauSac, jmiSPAdd, jmiSPList, jmiBHLapHoaDon, jmiBHQuanLy, jpnView);
		control.setView();
		control.setEvent();
	}
}
