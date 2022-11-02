package BUS;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.toedter.calendar.JDateChooser;

import DAO.KhachHangDAO;
import DAO.KhachHangDAOImp;
import DTO.ClassSupport;
import DTO.KhachHang;
import DTO.Person;

// Lam moi , 
public class DanhMucKhachHangController {
	private JTextField jtfMa, jtfHo, jtfTen, jtfDiaChi, jtfEmail, jtfSDT;
	private JDateChooser jdcNgaySinh;
	private JLabel jlbMsg;
	private JButton jbtnThem, jbtnXoa, jbtnSua, jbtnTimKiem, jbtnInBaoCao, jbtnLamMoi;
	private JRadioButton jrbNu;
	private JPanel jpnView;

	private JTable table;
	private String[] columnName = { "STT", "Mã KH", "Họ", "Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Email",
			"Số Điện Thoại" };
	private KhachHangDAO khDAO;
	private List<Person> listItem;
	private TableRowSorter<TableModel> rowSorter;

	public DanhMucKhachHangController(JTextField jtfMa, JTextField jtfHo, JTextField jtfTen, JTextField jtfDiaChi,
			JTextField jtfEmail, JDateChooser jdcNgaySinh, JLabel jlbMsg, JButton jbtnThem, JButton jbtnXoa,
			JButton jbtnSua, JButton jbtnTimKiem, JButton jbtnInBaoCao, JRadioButton jrbNu, JPanel jpnView,
			JTextField jtfSDT, JButton jbtnLamMoi) {
		super();
		this.jtfMa = jtfMa;
		this.jtfHo = jtfHo;
		this.jtfTen = jtfTen;
		this.jtfDiaChi = jtfDiaChi;
		this.jtfEmail = jtfEmail;
		this.jdcNgaySinh = jdcNgaySinh;
		this.jlbMsg = jlbMsg;
		this.jbtnThem = jbtnThem;
		this.jbtnXoa = jbtnXoa;
		this.jbtnSua = jbtnSua;
		this.jbtnTimKiem = jbtnTimKiem;
		this.jbtnInBaoCao = jbtnInBaoCao;
		this.jrbNu = jrbNu;
		this.jpnView = jpnView;
		this.jtfSDT = jtfSDT;
		this.jbtnLamMoi = jbtnLamMoi;

		khDAO = new KhachHangDAOImp();
		listItem = khDAO.getListKhachHang();
	}

	public void resetData() {
		if (listItem.size() > 0) {
			KhachHang.setsId(listItem.get(listItem.size() - 1).getMaDoiTuong());
		}

		jtfMa.setText(KhachHang.getsId());
		jtfHo.setText("");
		jtfTen.setText("");
		jtfDiaChi.setText("");
		jtfEmail.setText("");
		jlbMsg.setText("");
		jtfSDT.setText("");
		jdcNgaySinh.setDate(null);

		jtfMa.setEditable(false);
	}

	public void resetTable(List<Person> list, String[] columnName) {
		DefaultTableModel model = new ClassModel().getModel(list, columnName);
		table.setModel(model);
		rowSorter.setModel(table.getModel());
		table.setRowSorter(rowSorter);
	}

	public void setView() {

		resetData();

		rowSorter = new TableRowSorter<TableModel>();

		table = new JTable();
		resetTable(listItem, columnName);

		table.setRowHeight(50);
		table.setFont(new Font("tahoma", Font.PLAIN, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));

		rowSorter.setSortable(0, false);

		JScrollPane pane = new JScrollPane(table);
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();
	}

	public void addPop(Component cmp, final JPopupMenu pop) {
		cmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void showMenu(MouseEvent e) {
				pop.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void setEvent() {
		jtfHo.requestFocus();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					row = table.convertRowIndexToModel(row);
					Person kh = listItem.get(row);
					jtfMa.setText(kh.getMaDoiTuong());
					jtfHo.setText(kh.getHo());
					jtfTen.setText(kh.getTen());
					jtfDiaChi.setText(kh.getDiaChi());
					jtfEmail.setText(kh.getEmail());
					jrbNu.setSelected(!kh.isGioiTinh());
					jtfSDT.setText(kh.getSoDienThoai());
					jdcNgaySinh.setDate(kh.getNgaySinh());
				}
			}
		});

		rowSorter.addRowSorterListener(new RowSorterListener() {

			@Override
			public void sorterChanged(RowSorterEvent e) {

				int indexOfSTT = 0;
				for (int i = 0; i < listItem.size(); i++) {
					table.setValueAt(i + 1, i, indexOfSTT);
				}
			}
		});

		jtfHo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfTen.requestFocus();
				}
			}
		});

		jtfTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfEmail.requestFocus();
				}
			}
		});

		jtfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfSDT.requestFocus();
				}
			}
		});

		jtfSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfDiaChi.requestFocus();
				}
			}
		});

		jtfDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtnThem.requestFocus();
				}
			}
		});

		jbtnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = jtfMa.getText();

				String ho = jtfHo.getText();
				if (!ClassSupport.checkText(ho, ".+")) {
					jlbMsg.setText("Họ không dc để trống");
				} else {

					String ten = jtfTen.getText();
					if (!ClassSupport.checkText(ten, ".+")) {
						jlbMsg.setText("Tên không dc để trống");
					} else {

						String email = jtfEmail.getText();
						if (!ClassSupport.checkText(email, "\\w+@[a-z]+(\\.[a-z]{2,4}){1,3}")) {
							jlbMsg.setText("Email không hơp lệ");
						} else {

							String sdt = jtfSDT.getText();
							if (!ClassSupport.checkText(sdt, "0\\d{9}")) {
								jlbMsg.setText("Số Điện Thoại không hợp lệ");
							} else {

								String diaChi = jtfDiaChi.getText();
								if (!ClassSupport.checkText(diaChi, ".+")) {
									jlbMsg.setText("Địa Chỉ không dc để trống");
								} else {
									Date ngaySinh = jdcNgaySinh.getDate();
									boolean gioiTinh = !jrbNu.isSelected();
									Person ps = new Person(id, ho, ten, diaChi, email, sdt, ngaySinh, gioiTinh, "");
									if (khDAO.addKhachHang(ps)) {
										resetData();
										listItem.add(ps);
										resetTable(listItem, columnName);
										jlbMsg.setText("Thêm Thành Công!!!");
									}
								}
							}
						}

					}
				}
			}
		});
		jbtnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = jtfMa.getText();

				String ho = jtfHo.getText();
				if (!ClassSupport.checkText(ho, ".+")) {
					jlbMsg.setText("Họ không dc để trống");
				} else {

					String ten = jtfTen.getText();
					if (!ClassSupport.checkText(ten, ".+")) {
						jlbMsg.setText("Tên không dc để trống");
					} else {

						String email = jtfEmail.getText();
						if (!ClassSupport.checkText(email, "\\w+@[a-z]+(\\.[a-z]{2,4}){1,3}")) {
							jlbMsg.setText("Email không hơp lệ");
						} else {

							String sdt = jtfSDT.getText();
							if (!ClassSupport.checkText(sdt, "0\\d{9}")) {
								jlbMsg.setText("Số Điện Thoại không hợp lệ");
							} else {

								String diaChi = jtfDiaChi.getText();
								if (!ClassSupport.checkText(diaChi, ".+")) {
									jlbMsg.setText("Địa Chỉ không dc để trống");
								} else {
									int row = table.getSelectedRow();
									row = table.convertRowIndexToModel(row);
									Date ngaySinh = jdcNgaySinh.getDate();
									boolean gioiTinh = !jrbNu.isSelected();
									Person ps = new Person(id, ho, ten, diaChi, email, sdt, ngaySinh, gioiTinh, "");
									if (khDAO.editKhachHang(ps)) {
										resetData();
										listItem.set(row, ps);
										resetTable(listItem, columnName);
										jlbMsg.setText("Sửa Thành Công!!!");
									}
								}
							}
						}

					}
				}
			}
		});

		jbtnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá???", null,
							JOptionPane.QUESTION_MESSAGE);
					if (choose == 0) {
						row = table.convertRowIndexToModel(row);
						String maKH = listItem.get(row).getMaDoiTuong();
						if (khDAO.removeKhachHang(maKH)) {
							resetData();
							listItem.remove(row);
							resetTable(listItem, columnName);
							jlbMsg.setText("Xoá Thành Công!!!");
						}
					}
				}
			}
		});

		jbtnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String ho = jtfHo.getText();
				String ten = jtfTen.getText();
				String email = jtfEmail.getText();
				String diaChi = jtfDiaChi.getText();
				String sdt = jtfSDT.getText();
				String ngaySinh = (jdcNgaySinh.getDate() == null) ? ""
						: new SimpleDateFormat("dd/MM/yyyy").format(jdcNgaySinh.getDate());
				boolean gioiTinh = !jrbNu.isSelected();

				List<Person> listTemp = new ArrayList<Person>();
				for (Person ps : listItem) {
					String ngay = new SimpleDateFormat("dd/MM/yyyy").format(ps.getNgaySinh());
					if (ps.getHo().contains(ho) && ps.getTen().contains(ten) && ps.getDiaChi().contains(diaChi)
							&& ps.getEmail().contains(email) && ps.getSoDienThoai().contains(sdt)
							&& ngay.contains(ngaySinh) && ps.isGioiTinh() == gioiTinh) {
						listTemp.add(ps);
					}
				}

				resetTable(listTemp, columnName);
				if (listTemp.size() == 0)
					jlbMsg.setText("Hãy kiểm tra kĩ giới tính!!! hoặc đối tượng ko có");
			}
		});

		jbtnInBaoCao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet("Khach Hang");

				HSSFRow row = null;
				Cell cell = null;

				HSSFCellStyle cellStyle = getCellStyleForHeader(sheet);
				row = sheet.createRow(1);

//				cell = row.createCell(1);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("STT");
//
//				cell = row.createCell(2);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("Ma KH");
//
//				cell = row.createCell(3);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("Ho");
//
//				cell = row.createCell(4);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("Ten");
//
//				cell = row.createCell(5);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("Gioi Tinh");
//
//				cell = row.createCell(6);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("Ngay Sinh");
//
//				cell = row.createCell(7);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("Dia Chi");
//
//				cell = row.createCell(8);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("Email");
//
//				cell = row.createCell(9);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("SDT");

				cell = createCell(row, "STT", cellStyle, 1);
				cell = createCell(row, "Ma KH", cellStyle, 2);
				cell = createCell(row, "Ho", cellStyle, 3);
				cell = createCell(row, "Ten", cellStyle, 4);
				cell = createCell(row, "Gioi Tinh", cellStyle, 5);
				cell = createCell(row, "Ngay Sinh", cellStyle, 6);
				cell = createCell(row, "Dia Chi", cellStyle, 7);
				cell = createCell(row, "Email", cellStyle, 8);
				cell = createCell(row, "SDT", cellStyle, 9);

				for (int i = 0; i < listItem.size(); i++) {
					Person ps = listItem.get(i);
					row = sheet.createRow(2 + i);

					cell = row.createCell(1);
					cell.setCellValue(i + 1);

					cell = row.createCell(2);
					cell.setCellValue(ps.getMaDoiTuong());

					cell = row.createCell(3);
					cell.setCellValue(ps.getHo());

					cell = row.createCell(4);
					cell.setCellValue(ps.getTen());

					cell = row.createCell(5);
					cell.setCellValue(ps.isGioiTinh() ? "Nam" : "Nu");

					cell = row.createCell(6);
					cell.setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(ps.getNgaySinh()));

					cell = row.createCell(7);
					cell.setCellValue(ps.getDiaChi());

					cell = row.createCell(8);
					cell.setCellValue(ps.getEmail());

					cell = row.createCell(9);
					cell.setCellValue(ps.getSoDienThoai());

				}

				for (int i = 1; i < 10; i++) {
					sheet.autoSizeColumn(i);
				}

				File file = new File("D:DMKhachHang.xls");
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file);
					workBook.write(fos);
					workBook.close();
					fos.close();
					jlbMsg.setText("Lưu thành công xuống file: " + file.getAbsolutePath());
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});

		jbtnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetData();
				resetTable(listItem, columnName);
			}
		});

	}

	public Cell createCell(HSSFRow row, String value, HSSFCellStyle style, int num) {
		Cell cell = row.createCell(num);
		if (style != null)
			cell.setCellStyle(style);
		cell.setCellValue(value);
		return cell;
	}

//	public

	public HSSFCellStyle getCellStyleForHeader(HSSFSheet sheet) {
		HSSFFont font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 14);

		HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);
		return cellStyle;
	}
}
