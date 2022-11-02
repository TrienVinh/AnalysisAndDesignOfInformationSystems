package DAO;

import java.util.List;

import DTO.ChiTietSanPham;

public interface ChiTietSanPhamDAO {
	List<ChiTietSanPham> getListChiTietSanPham();

	boolean addChiTietSanPham(ChiTietSanPham sp);

	boolean editChiTietSanPham(ChiTietSanPham sp);

	boolean removeChiTietSanPham(ChiTietSanPham sp);

}
