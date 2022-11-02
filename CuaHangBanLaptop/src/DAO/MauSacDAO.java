package DAO;

import java.util.List;

import DTO.MauSac;

public interface MauSacDAO {
	List<MauSac> getListMauSac();

	boolean addMau(MauSac ms);

	boolean editMau(MauSac ms);

	boolean removeMau(String maMau);
}
