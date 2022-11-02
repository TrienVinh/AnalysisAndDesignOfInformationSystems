package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import BUS.DanhMucKhachHangController;

import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class DanhMucKhachHangPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfMa;
	private JTextField jtfHo;
	private JTextField jtfEmail;
	private JTextField jtfTen;
	private JTextField jtfDiaChi;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField jtfSDT;

	/**
	 * Create the panel.
	 */
	public DanhMucKhachHangPanel() {

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.PREFERRED_SIZE, 934, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

		JLabel lblKhachHang = new JLabel("Quản Lý Khách Hàng");
		lblKhachHang.setBackground(new Color(51, 204, 255));
		lblKhachHang.setOpaque(true);
		lblKhachHang.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Thao T\u00E1c",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel jpnView = new JPanel();
		jpnView.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Danh S\u00E1ch",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JButton btnNewButton = new JButton("In Danh Sách");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKhachHang, GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup().addGap(10)
								.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup().addGap(436).addComponent(btnNewButton)
								.addContainerGap(689, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblKhachHang, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton).addGap(57)));

		JLabel lblNewLabel = new JLabel("Mã Khách Hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfMa = new JTextField();
		jtfMa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jtfMa.setColumns(10);

		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JRadioButton jrbNam = new JRadioButton("Nam");
		buttonGroup.add(jrbNam);
		jrbNam.setSelected(true);
		jrbNam.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JRadioButton jrbNu = new JRadioButton("Nữ");
		buttonGroup.add(jrbNu);
		jrbNu.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JDateChooser jdcNgaySinh = new JDateChooser();
		jdcNgaySinh.setFont(new Font("tahoma", Font.PLAIN, 17));
		jdcNgaySinh.setDateFormatString("dd/MM/yyyy");

		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblH = new JLabel("Họ:");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfHo = new JTextField();
		jtfHo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jtfHo.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jtfEmail.setColumns(10);

		JLabel lblTn = new JLabel("Tên:");
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfTen = new JTextField();
		jtfTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jtfTen.setColumns(10);

		JLabel lblaCh = new JLabel("Địa Chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfDiaChi = new JTextField();
		jtfDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jtfDiaChi.setColumns(10);

		JLabel lblMsg = new JLabel("");
		lblMsg.setForeground(new Color(255, 0, 0));
		lblMsg.setFont(new Font("Tahoma", Font.ITALIC, 16));

		JButton jbtnThem = new JButton("Thêm");
		jbtnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton jbtnXoa = new JButton("Xóa");
		jbtnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton jbtnSua = new JButton("Sửa");
		jbtnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton jbtnTimKiem = new JButton("Tìm Kiếm");
		jbtnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblSdt = new JLabel("SDT:");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfSDT = new JTextField();
		jtfSDT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jtfSDT.setColumns(10);

		JButton jbtnLamMoi = new JButton("Làm Mới");
		jbtnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(83)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMsg, GroupLayout.PREFERRED_SIZE, 1005, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(jbtnThem, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(12)
								.addComponent(jbtnXoa, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(12)
								.addComponent(jbtnSua, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(16)
								.addComponent(jbtnTimKiem, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(jbtnLamMoi, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel).addGap(18)
										.addComponent(jtfMa, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 115,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 115,
														GroupLayout.PREFERRED_SIZE))
										.addGap(33)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(jrbNam, GroupLayout.PREFERRED_SIZE, 69,
																GroupLayout.PREFERRED_SIZE)
														.addGap(4).addComponent(jrbNu, GroupLayout.DEFAULT_SIZE, 117,
																Short.MAX_VALUE))
												.addComponent(jdcNgaySinh, GroupLayout.DEFAULT_SIZE, 190,
														Short.MAX_VALUE))))
								.addGap(52)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 74,
														GroupLayout.PREFERRED_SIZE)
												.addGap(26)
												.addComponent(jtfDiaChi, GroupLayout.DEFAULT_SIZE, 582,
														Short.MAX_VALUE))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 61,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(39).addComponent(jtfEmail,
																		GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(lblH, GroupLayout.PREFERRED_SIZE, 61,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(39).addComponent(jtfHo,
																		GroupLayout.DEFAULT_SIZE, 215,
																		Short.MAX_VALUE)))
												.addGap(72)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(lblTn, GroupLayout.PREFERRED_SIZE, 61,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(jtfTen,
																		GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(lblSdt, GroupLayout.PREFERRED_SIZE, 61,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(jtfSDT,
																		GroupLayout.DEFAULT_SIZE, 216,
																		Short.MAX_VALUE)))))))
				.addGap(59)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(10)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(lblNewLabel))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(lblH))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(jtfHo,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(2).addComponent(lblTn))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(jtfTen,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(jtfMa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(8)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblGiiTnh)
										.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(jrbNam,
												GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblEmail)))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(11).addComponent(jrbNu,
								GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(9).addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(lblSdt,
										GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addComponent(jtfSDT, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))))
				.addGap(9)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblNgySinh)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(lblaCh))
						.addComponent(jtfDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jdcNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(8).addComponent(lblMsg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(14)
				.addGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(jbtnThem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtnSua, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(jbtnTimKiem, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jbtnLamMoi, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)))));
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		DanhMucKhachHangController control = new DanhMucKhachHangController(jtfMa, jtfHo, jtfTen, jtfDiaChi, jtfEmail,
				jdcNgaySinh, lblMsg, jbtnThem, jbtnXoa, jbtnSua, jbtnTimKiem, btnNewButton, jrbNu, jpnView, jtfSDT,
				jbtnLamMoi);
		control.setView();
		control.setEvent();
	}
}