package com.cognizant.policyproviderportal.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.policyproviderportal.dto.PolicyDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;
import com.cognizant.policyproviderportal.form.PolicyForm;
import com.cognizant.policyproviderportal.service.PolicyServiceInt;
import com.cognizant.policyproviderportal.util.DataUtility;


@Controller
@RequestMapping("/ctl/policy")
public class PolicyCtl extends BaseCtl {

	@Autowired
	private PolicyServiceInt service;
	

	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Health", "Health");
		map2.put("Life", "Life");
		map2.put("Vehicle", "Vehicle");
		map2.put("Electronics", "Electronics");
		model.addAttribute("category", map2);

	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") PolicyForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			PolicyDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "policy";
	}
	
	@GetMapping("/search/detail")
	public String displayDetail(@RequestParam(required = false) Long id,@ModelAttribute("form") PolicyForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			PolicyDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "policyDetail";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") PolicyForm form, BindingResult bindingResult,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/policy";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "policy";
				}
				PolicyDTO bean = (PolicyDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Policy update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Policy Added Successfully!!!!");
				}
				return "policy";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "policy";
		} 
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PolicyForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/policy/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/policy";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					PolicyDTO dto = new PolicyDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		
		if (OP_COMPARE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				if(form.getIds().length == 2) {
					int i=1;
				for (long id : form.getIds()) {
					PolicyDTO dto =service.findBypk(id);
					model.addAttribute("dto"+i++,dto);
				}
				return "compareDetail";
				}else {
					model.addAttribute("error", "Select at least two record");
				}
			} else {
				model.addAttribute("error", "Select at least two record");
			}
		}
		
		PolicyDTO dto = (PolicyDTO) form.getDTO();
		List<PolicyDTO> list = service.search(dto, pageNo, pageSize);
		List<PolicyDTO> totallist = service.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "policyList";
	}
	
	@GetMapping("/category")
	public String displayCategory(Model model) {
			
		return "categoryList";
	}

}
