package com.ncut.wms.commodity.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Component;

import com.ncut.wms.commodity.dao.CommodityDAO;
import com.ncut.wms.commodity.model.Commodity;
import com.ncut.wms.commodity.model.CommodityCategory;
import com.ncut.wms.unit.model.Unit;
import com.ncut.wms.util.json.ObjectJsonValueProcessor;

@Component("commodityService")
public class CommodityService {

	private CommodityDAO commodityDAO;

	/**
	 * ������Ʒ����
	 * @return
	 */
	public int total() {
		int total = commodityDAO.count();
		return total;
	}

	/**
	 * ���ݷ�ҳ��ȡ��Ʒ�б�
	 * @param currentPage ��ǰҳ
	 * @param pageSize ҳ����ʾ��������
	 * @return
	 */
	public List<Commodity> getCommodityListByPage(int currentPage, int pageSize) {
		List<Commodity> commodityList = commodityDAO.findByPagination(
				currentPage, pageSize);
		return commodityList;
	}
	
	/**
	 * �����Ʒ�б��json�ַ���
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public String getCommodityListJson(int currentPage, int pageSize) {
		List<Commodity> commodityList = commodityDAO.findByPagination(
				currentPage, pageSize);
		// ƴJason�ַ��� {"total":total , "rows":[{},{}]}
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(CommodityCategory.class,
				new ObjectJsonValueProcessor(
						new String[] { "commodityCategoryName" },
						CommodityCategory.class));
		config.registerJsonValueProcessor(Unit.class,
				new ObjectJsonValueProcessor(new String[] { "unitName" },
						Unit.class));
		String commodityListStr = "{\"total\":" + this.total() + " , \"rows\":"
				+ JSONArray.fromObject(commodityList, config).toString() + "}";
		return commodityListStr;
	}
	
	/**
	 * ��ȡ������Ʒ�б�
	 * @return
	 */
	public List<Commodity> getCommodityList() {
		List<Commodity> commodityList = commodityDAO.findAll();
		return commodityList;
	}

	public void add(Commodity commodity) {
		//commodityDAO.add(commodity);
		System.out.println(commodity.toString());
	}

	public CommodityDAO getCommodityDAO() {
		return commodityDAO;
	}

	@Resource
	public void setCommodityDAO(CommodityDAO commodityDAO) {
		this.commodityDAO = commodityDAO;
	}

}
