package DAO;

import java.util.List;

import DTO.Person;

public interface KhachHangDAO {
	List<Person> getListKhachHang();

	boolean addKhachHang(Person kh);

	boolean editKhachHang(Person kh);

	boolean removeKhachHang(String maKH);
}
