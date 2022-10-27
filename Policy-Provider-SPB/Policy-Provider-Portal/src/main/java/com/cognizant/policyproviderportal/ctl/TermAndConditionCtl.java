package com.cognizant.policyproviderportal.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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

import com.cognizant.policyproviderportal.dto.TermAndConditionDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;
import com.cognizant.policyproviderportal.form.TermAndConditionForm;
import com.cognizant.policyproviderportal.service.TermAndConditionServiceInt;
import com.cognizant.policyproviderportal.util.DataUtility;


@Controller
@RequestMapping("/ctl/termAndCondition")
public class TermAndConditionCtl extends BaseCtl {

	@Autowired
	private TermAndConditionServiceInt service;
	
	@ModelAttribute
	public void preload(Model model) {
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") TermAndConditionForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			TermAndConditionDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "termAndCondition";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") TermAndConditionForm form, BindingResult bindingResult,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/termAndCondition";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "termAndCondition";
				}
				
				TermAndConditionDTO bean = (TermAndConditionDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Term & Condition update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Term & Condition Added Successfully!!!!");
				}
				return "termAndCondition";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "termAndCondition";
		} 
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") TermAndConditionForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/termAndCondition/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/termAndCondition";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					TermAndConditionDTO dto = new TermAndConditionDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		TermAndConditionDTO dto = (TermAndConditionDTO) form.getDTO();

		List<TermAndConditionDTO> list = service.search(dto, pageNo, pageSize);
		List<TermAndConditionDTO> totallist = service.search(dto);
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
		return "termAndConditionList";
	}

}
