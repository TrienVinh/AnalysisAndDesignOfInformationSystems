package DAO;

import java.util.List;

import DTO.Kho;

public interface KhoDAO {
	List<Kho> getListKho();

	boolean addKho(Kho k);

	boolean editKho(Kho k);

	boolean removeKho(String k);
}
