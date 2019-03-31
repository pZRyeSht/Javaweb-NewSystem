package com.ns.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ns.common.MyFactory;
import com.ns.iservice.INsCatService;
import com.ns.pojo.NsCat;

public class NsCatTag extends SimpleTagSupport{
	private INsCatService catService =  (INsCatService)MyFactory.getBean("catService");

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		try {
			List<NsCat> list = catService.findCatAll();
			StringBuilder str = new StringBuilder();
			str.append("<select name=\"catId\" size=\"l\">");
			for (NsCat a :list) {
				str.append("<option value=\"").append(a.getCat_id()).append("\">").append
				(a.getCat_name()).append("</option>");
			}
			str.append("</select>");
			out.print(str.toString());
			JspFragment f = getJspBody();
			if (f != null) {
				f.invoke(out);
			}
		} catch (Exception ex) {
		}
	}
	
}
