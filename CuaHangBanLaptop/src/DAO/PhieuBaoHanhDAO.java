package DAO;

import java.util.List;

import DTO.PhieuBaoHanh;

public interface PhieuBaoHanhDAO {
	List<PhieuBaoHanh> getListBaoHanh();

	boolean addBaoHanh(PhieuBaoHanh pbh);

	boolean editBaoHanh(PhieuBaoHanh pbh);

	boolean removeBaoHanh(String pbh);
}
