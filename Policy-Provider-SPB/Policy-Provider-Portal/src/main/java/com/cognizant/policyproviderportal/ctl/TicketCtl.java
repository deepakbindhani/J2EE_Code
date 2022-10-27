package com.cognizant.policyproviderportal.ctl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.policyproviderportal.dto.TicketDTO;
import com.cognizant.policyproviderportal.dto.UserDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;
import com.cognizant.policyproviderportal.form.TicketForm;
import com.cognizant.policyproviderportal.service.TicketServiceInt;
import com.cognizant.policyproviderportal.util.DataUtility;

@Controller
@RequestMapping("/ctl/ticket")
public class TicketCtl extends BaseCtl {

	@Autowired
	private TicketServiceInt service;

	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Pending", "Pending");
		map2.put("Completed", "Completed");
		model.addAttribute("status", map2);

	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") TicketForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			TicketDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "ticket";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") TicketForm form, BindingResult bindingResult,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/ticket";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "ticket";
				}

				UserDTO uDto = (UserDTO) session.getAttribute("user");

				TicketDTO bean = (TicketDTO) form.getDTO();

				if (bean.getId() > 0) {
					TicketDTO tDto = service.findBypk(bean.getId());
					bean.setUser(tDto.getUser());
					bean.setTicketId(tDto.getTicketId());
					if (uDto.getRoleId() == 2) {
						bean.setStatus("Pending");
					}
					service.update(bean);
					model.addAttribute("success", "Ticket update Successfully!!!!");
				} else {
					bean.setTicketId(DataUtility.getRandom());
					bean.setUser(uDto);
					bean.setStatus("Pending");
					service.add(bean);
					model.addAttribute("success", "Ticket Added Successfully!!!!");
				}
				return "ticket";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "ticket";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") TicketForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/ticket/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/ticket";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					TicketDTO dto = new TicketDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		TicketDTO dto = (TicketDTO) form.getDTO();

		List<TicketDTO> list = service.search(dto, pageNo, pageSize);
		List<TicketDTO> totallist = service.search(dto);
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
		return "ticketList";
	}

}
