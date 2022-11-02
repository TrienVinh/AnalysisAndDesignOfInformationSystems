package BUS;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DTO.Person;

public class ClassModel {
	public <E> DefaultTableModel getModel(List<E> listItem, String[] columnName) {
		DefaultTableModel model = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if(listItem.isEmpty())
					return Object.class;
				return getValueAt(0, columnIndex).getClass();
			}
		};
		model.setRowCount(0);
		model.setColumnIdentifiers(columnName);
		int count = 1;
		for (E e : listItem) {
//			if (e instanceof KhachHang) {
//				KhachHang kh = (KhachHang) e;
//				model.addRow(new Object[] { count++, kh.getMaDoiTuong(), kh.getHo(), kh.getTen(),
//						kh.isGioiTinh() ? "Nam" : "Nữ", new SimpleDateFormat("dd/MM/yyyy").format(kh.getNgaySinh()),
//						kh.getDiaChi(), kh.getEmail(), kh.getSoDienThoai() });
//			} else if (e instanceof NhanVien) {
//				NhanVien nv = (NhanVien) e;
//				model.addRow(new Object[] { count++, nv.getMaDoiTuong(), nv.getHo(), nv.getTen(),
//						nv.isGioiTinh() ? "Nam" : "Nữ", new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgaySinh()),
//						nv.getDiaChi(), nv.getEmail(), nv.getChucVu(), nv.getSoDienThoai() });
//			}
			if (e instanceof Person) {
				Person ps = (Person) e;
				model.addRow(new Object[] { count++, ps.getMaDoiTuong(), ps.getHo(), ps.getTen(),
						ps.isGioiTinh() ? "Nam" : "Nữ", new SimpleDateFormat("dd/MM/yyyy").format(ps.getNgaySinh()),
						ps.getDiaChi(), ps.getEmail(), ps.getSoDienThoai() });
			}
		}

		return model;
	}
}
