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
import com.opensymphony.xwork2.ModelDriven;

@Component("commodityAction")
@Scope("prototype")
public class CommodityAction extends ActionSupport implements ModelDriven<Commodity> {

	@Resource
	private CommodityService commodityService;
	
	private Commodity commodity = new Commodity();
	
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
		//ͨ����ҳ��ö�Ӧ��Ʒ�б��json�ַ���
		String commodityList = commodityService.getCommodityListJson(currentPage, pageSize);
		// ���response����,��Ӧҳ��:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(commodityList);
		return NONE;
	}
	
	/**
	 * �����Ʒ��Ϣ
	 * @return
	 */
	public String addCommodity() {
		// ���response����,��Ӧҳ��:
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			commodityService.add(commodity);
			response.setContentType("text/html;charset=UTF-8");
			String str = "{\"status\":\"ok\" , \"message\":\"�����ɹ�!\"}";

			response.getWriter().write(str);
		} catch (IOException e) {
			response.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"fail\" , \"message\":\"����ʧ��!\"}";
			try {
				response.getWriter().write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return NONE;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public Commodity getModel() {
		return commodity;
	}


}
