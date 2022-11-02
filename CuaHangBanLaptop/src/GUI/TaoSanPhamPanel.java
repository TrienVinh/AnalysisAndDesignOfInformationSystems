package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class TaoSanPhamPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfMa;
	private JTextField jtfGiaTien;
	private JTextField jtfQuocGia;
	private JTextField jtfSoLuong;

	/**
	 * Create the panel.
	 */
	public TaoSanPhamPanel() {

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

		JLabel lblToSnPhm = new JLabel("TẠO SẢN PHẨM");
		lblToSnPhm.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblToSnPhm.setOpaque(true);
		lblToSnPhm.setBackground(new Color(51, 204, 255));
		lblToSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblToSnPhm.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Th\u00F4ng Tin S\u00E1ch",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel jpnView = new JPanel();
		jpnView.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Th\u00F4ng Tin Chi Ti\u1EBFt",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot
				.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
						.addComponent(lblToSnPhm, GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
						.addGroup(gl_jpnRoot.createSequentialGroup().addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_jpnRoot.createSequentialGroup().addContainerGap()
								.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnRoot.createSequentialGroup()
						.addComponent(lblToSnPhm, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(252, Short.MAX_VALUE)));

		JLabel lblMSnPhm_1 = new JLabel("Mã Sản Phẩm:");
		lblMSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JComboBox<String> jcbMaSP = new JComboBox<String>();
		jcbMaSP.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMMu = new JLabel("Mã Màu:");
		lblMMu.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JComboBox<String> jcbMaMau = new JComboBox<String>();
		jcbMaMau.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblSTin = new JLabel("Số Lượng:");
		lblSTin.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfSoLuong = new JTextField();
		jtfSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSoLuong.setColumns(10);

		JButton jbtnThemChiTiet = new JButton("Thêm");
		jbtnThemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel jlbMsgChiTiet = new JLabel("");
		jlbMsgChiTiet.setForeground(Color.RED);
		jlbMsgChiTiet.setFont(new Font("Tahoma", Font.ITALIC, 16));
		GroupLayout gl_jpnView = new GroupLayout(jpnView);
		gl_jpnView.setHorizontalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnView
				.createSequentialGroup()
				.addGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnView.createSequentialGroup()
						.addGap(10)
						.addComponent(lblMSnPhm_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addGap(4).addComponent(jcbMaSP, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addGap(31).addComponent(lblMMu, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addGap(4).addComponent(jcbMaMau, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblSTin, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(jtfSoLuong, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnView.createSequentialGroup().addGap(10).addComponent(jlbMsgChiTiet,
								GroupLayout.PREFERRED_SIZE, 1027, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnView.createSequentialGroup().addGap(9).addComponent(jbtnThemChiTiet,
								GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(139, Short.MAX_VALUE)));
		gl_jpnView.setVerticalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnView
				.createSequentialGroup().addGap(10)
				.addGroup(gl_jpnView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpnView.createSequentialGroup().addGap(2).addComponent(lblMSnPhm_1))
						.addComponent(jcbMaSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpnView.createSequentialGroup().addGap(4).addComponent(lblMMu))
						.addGroup(gl_jpnView.createSequentialGroup().addGap(2).addComponent(jcbMaMau,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnView.createSequentialGroup().addGap(4).addComponent(lblSTin))
						.addGroup(gl_jpnView.createSequentialGroup().addGap(2).addComponent(jtfSoLuong,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(10).addComponent(jlbMsgChiTiet, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addGap(12).addComponent(jbtnThemChiTiet, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addGap(156)));
		jpnView.setLayout(gl_jpnView);

		JLabel lblMSnPhm = new JLabel("Mã Sản Phẩm:");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfMa = new JTextField();
		jtfMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfMa.setColumns(10);

		JLabel lblMHng = new JLabel("Mã Hãng:");
		lblMHng.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JComboBox<String> jcbMaHang = new JComboBox<String>();
		jcbMaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblTnSnPhm = new JLabel("Tên Sản Phẩm:");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMKho = new JLabel("Mã Kho:");
		lblMKho.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JComboBox<String> jcbMaKho = new JComboBox<String>();
		jcbMaKho.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblLinhKin = new JLabel("Linh Kiện:");
		lblLinhKin.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblGiTin = new JLabel("Giá Tiền:");
		lblGiTin.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfGiaTien = new JTextField();
		jtfGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfGiaTien.setColumns(10);

		JLabel lblQucGia = new JLabel("Quốc Gia:");
		lblQucGia.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jtfQuocGia = new JTextField();
		jtfQuocGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfQuocGia.setColumns(10);

		JLabel lblMT = new JLabel("Mô Tả:");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel jlbMsgSP = new JLabel("");
		jlbMsgSP.setForeground(new Color(255, 0, 0));
		jlbMsgSP.setFont(new Font("Tahoma", Font.ITALIC, 16));

		JButton jbtnThemSP = new JButton("Thêm");
		jbtnThemSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGap(10).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
								.createSequentialGroup()
								.addComponent(lblMSnPhm, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(jtfMa, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addGap(44)
								.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addGap(36)
								.addComponent(lblLinhKin, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 196,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblMHng, GroupLayout.PREFERRED_SIZE, 122,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(jcbMaHang, GroupLayout.PREFERRED_SIZE, 177,
												GroupLayout.PREFERRED_SIZE)
										.addGap(44)
										.addComponent(lblMKho, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(jcbMaKho, GroupLayout.PREFERRED_SIZE, 196,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36)
										.addComponent(lblGiTin, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(jtfGiaTien, GroupLayout.PREFERRED_SIZE, 196,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblQucGia, GroupLayout.PREFERRED_SIZE, 122,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(jtfQuocGia, GroupLayout.PREFERRED_SIZE, 177,
												GroupLayout.PREFERRED_SIZE)
										.addGap(44)
										.addComponent(lblMT, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 540,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jbtnThemSP, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(jlbMsgSP,
								GroupLayout.PREFERRED_SIZE, 1027, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(139, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(lblMSnPhm))
								.addComponent(jtfMa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(lblTnSnPhm))
								.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(lblLinhKin))
								.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(scrollPane_1,
										GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(lblMHng))
								.addComponent(jcbMaHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(lblMKho))
								.addComponent(jcbMaKho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(lblGiTin))
								.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(
										jtfGiaTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(lblQucGia))
								.addGroup(gl_panel.createSequentialGroup().addGap(4).addComponent(jtfQuocGia,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(lblMT))
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jlbMsgSP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(7)
						.addComponent(jbtnThemSP, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JTextArea jtaLinhKien = new JTextArea();
		scrollPane_1.setViewportView(jtaLinhKien);

		JTextArea jtaMoTa = new JTextArea();
		scrollPane_2.setViewportView(jtaMoTa);

		JTextArea jtaTenSP = new JTextArea();
		scrollPane.setViewportView(jtaTenSP);
		panel.setLayout(gl_panel);
		jpnRoot.setLayout(gl_jpnRoot);
		setLayout(groupLayout);

	}
}
