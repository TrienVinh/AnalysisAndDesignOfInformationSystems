package DAO;

import java.util.List;

import DTO.NhaCungCap;

public interface NhaCungCapDAO {
	List<NhaCungCap> getListNhaCungCap();

	boolean addNhaCungCap(NhaCungCap ncc);

	boolean editNhaCungCap(NhaCungCap ncc);

	boolean removeNhaCungCap(String maNCC);
	
}
