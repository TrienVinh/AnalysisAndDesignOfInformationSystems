package DAO;

import java.util.List;

import DTO.ChiTietHoaDon;

public interface ChiTietHoaDonDAO {
	List<ChiTietHoaDon> getListChiTietHoaDon(String tableName);

	boolean addChiTietHoaDon(ChiTietHoaDon hd, String tableName);

	boolean editChiTietHoaDon(ChiTietHoaDon hd, String tableName);

	boolean removeChiTietHoaDon(ChiTietHoaDon hd, String tableName);

}
