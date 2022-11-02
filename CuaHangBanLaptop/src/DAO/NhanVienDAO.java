package DAO;

import java.util.List;

import DTO.Person;

public interface NhanVienDAO {
	List<Person> getListNhanVien();

	boolean addNhanVien(Person nv);

	boolean editNhanVien(Person nv);

	boolean removeNhanVien(String maNV);
}
