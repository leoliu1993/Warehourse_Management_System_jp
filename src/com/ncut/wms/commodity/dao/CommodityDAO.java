package com.ncut.wms.commodity.dao;

import java.util.List;

import com.ncut.wms.commodity.model.Commodity;

public interface CommodityDAO {

	/**
	 * ��ѯ������Ʒ�б�
	 * @return ��Ʒ�б�
	 */
	public List<Commodity> findAll();

	/**
	 * ��ҳ��ѯ��Ʒ�б�
	 * @param currentPage ��ǰҳ
	 * @param pageSize һҳ������������
	 * @return ��ҳ��Ʒ�б�
	 */
	public List<Commodity> findByPagination(int currentPage, int pageSize);
	
	/**
	 * ��ȡ��Ʒ����
	 * @return ��Ʒ����
	 */
	public int count();
}
