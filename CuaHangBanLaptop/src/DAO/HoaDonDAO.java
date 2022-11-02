package DAO;

import java.util.List;

import DTO.HoaDon;

public interface HoaDonDAO {
	List<HoaDon> getListHoaDon(String tableName);

	boolean addHoaDon(HoaDon hd, String tableName);

	boolean editHoaDon(HoaDon hd, String tableName);

	boolean removeHoaDon(String hd, String tableName);

	String getLastId(String tableName);

}
