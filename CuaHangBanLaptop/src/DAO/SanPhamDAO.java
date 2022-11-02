package DAO;

import java.util.List;

import DTO.SanPham;

public interface SanPhamDAO {
	List<SanPham> getListSanPham();

	boolean addSanPham(SanPham sp);

	boolean editSanPham(SanPham sp);

	boolean removeSanPham(String sp);

	String getLastId();
}
