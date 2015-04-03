package com.ncut.wms.commodity.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ncut.wms.commodity.model.Commodity;
import com.ncut.wms.commodity.service.CommodityService;
import com.opensymphony.xwork2.ActionSupport;

@Component("commodity")
@Scope("prototype")
public class CommodityAction extends ActionSupport {

	@Resource
	private CommodityService commodityService;
	
	/**
	 * ��ת��Ʒ��Ϣ����ҳ��
	 * @return
	 */
	public String managementPage() {
		
		return "managementPage";
	}
	
	/**
	 * ��ȡ��Ʒ��Ϣ�б�
	 * @return
	 * @throws IOException 
	 */
	public String getCommodityList() throws IOException {
		
		// ���request���󣬻�ȡҳ������
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��õ�ǰҳ
		int currentPage = Integer.parseInt(request.getParameter("page"));
		// ���һҳ��ʾ����������
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		
		List<Commodity> commodityList = commodityService.getCommodityListByPage(currentPage, pageSize);
		// ���response����,��Ӧҳ��:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// ƴJason�ַ���
		int total = commodityService.total();
		String commodityListStr =  "{\"total\":"+total+" , \"rows\":"+JSONArray.fromObject(commodityList).toString()+"}";
		response.getWriter().write(commodityListStr);
		return NONE;
	}

}
