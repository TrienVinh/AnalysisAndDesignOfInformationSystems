package DAO;

import java.util.List;

import DTO.Hang;

public interface HangDAO {
	List<Hang> getListHang();

	boolean addHang(Hang h);

	boolean editHang(Hang h);

	boolean removeHang(String maH);

}
