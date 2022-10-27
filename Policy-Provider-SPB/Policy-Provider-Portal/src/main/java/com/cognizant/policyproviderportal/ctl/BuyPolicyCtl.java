package com.cognizant.policyproviderportal.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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

import com.cognizant.policyproviderportal.dto.BuyPolicyDTO;
import com.cognizant.policyproviderportal.dto.PolicyDTO;
import com.cognizant.policyproviderportal.dto.UserDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;
import com.cognizant.policyproviderportal.form.BuyPolicyForm;
import com.cognizant.policyproviderportal.form.RenewalForm;
import com.cognizant.policyproviderportal.service.BuyPolicyServiceInt;
import com.cognizant.policyproviderportal.service.PolicyServiceInt;
import com.cognizant.policyproviderportal.util.DataUtility;


@Controller
@RequestMapping("/ctl/buyPolicy")
public class BuyPolicyCtl extends BaseCtl {

	@Autowired
	private BuyPolicyServiceInt service;
	
	@Autowired
	private PolicyServiceInt policyService;
	
	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("policyList",policyService.search(null));
	}

	@GetMapping("/renewal")
	public String displayRenewal(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") RenewalForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			BuyPolicyDTO bean = service.findBypk(id);
			form.setOldPolicyId(bean.getPoilicyId());
			session.setAttribute("buyId",form.getId());
		}
		return "renewalPolicy";
	}
	
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") BuyPolicyForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			BuyPolicyDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		if(DataUtility.getLong(String.valueOf(pId))>0) {
			session.setAttribute("pId",DataUtility.getLong(String.valueOf(pId)));
		}
		return "buyPolicy";
	}
	

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") BuyPolicyForm form, BindingResult bindingResult,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/buyPolicy";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "buyPolicy";
				}
				
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				BuyPolicyDTO bean = (BuyPolicyDTO) form.getDTO();
				long pid=DataUtility.getLong(String.valueOf(session.getAttribute("pId")));
				
				if(service.findByUserIdAndPolicyId(uDto.getId(), pid)!=null) {
					model.addAttribute("error","You have already buy this policy");
					return "buyPolicy";
				}
				
				PolicyDTO pDto=policyService.findBypk(pid);
					bean.setPoilicyId(pDto.getId());
					bean.setPolicyName(pDto.getName());
					bean.setPrice(pDto.getPrice());
					bean.setRoi(pDto.getRoi());
					bean.setUserId(uDto.getId());
					bean.setRenewalDate(pDto.getDate());
					bean.setBuyDate(DataUtility.getCurrentTimestamp());
					session.setAttribute("buyDetail",bean);
					session.setAttribute("pDto", pDto);
					model.addAttribute("pdto",pDto);
					return "payment";
			}
			
			if (OP_PAY.equalsIgnoreCase(form.getOperation())) {
					BuyPolicyDTO bDto=(BuyPolicyDTO)session.getAttribute("buyDetail");
					PolicyDTO pDto=(PolicyDTO)session.getAttribute("pDto");
					service.add(bDto);
					model.addAttribute("success", "Policy Apply Successfully!!!!");
					model.addAttribute("pdto",pDto);
					return "payment";
				
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "buyPolicy";
		} 
		return "";
	}
	
	
	@PostMapping("/renewal")
	public String submitRenewal(@Valid @ModelAttribute("form") RenewalForm form, BindingResult bindingResult,
			HttpSession session, Model model) {

		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/buyPolicy/search";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "renewalPolicy";
				}
				
					PolicyDTO pDto=policyService.findBypk(form.getNewPolicyId());
					long pid=DataUtility.getLong(String.valueOf(session.getAttribute("buyId")));
					BuyPolicyDTO bean=service.findBypk(pid);
					bean.setPoilicyId(pDto.getId());
					bean.setPolicyName(pDto.getName());
					bean.setPrice(pDto.getPrice());
					bean.setRoi(pDto.getRoi());
					bean.setRenewalDate(pDto.getDate());
					bean.setBuyDate(DataUtility.getCurrentTimestamp());
					service.update(bean);
					model.addAttribute("success","Policy Renewal Successfull!!!");
					
					return "renewalPolicy";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "renewalPolicy";
		} 
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BuyPolicyForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/buyPolicy/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/buyPolicy";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					BuyPolicyDTO dto = new BuyPolicyDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		BuyPolicyDTO dto = (BuyPolicyDTO) form.getDTO();
		
		UserDTO uDto=(UserDTO)session.getAttribute("user");

		if(uDto.getRoleId()==2) {
			dto.setUserId(uDto.getId());
		}
		List<BuyPolicyDTO> list = service.search(dto, pageNo, pageSize);
		List<BuyPolicyDTO> totallist = service.search(dto);
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
		return "buyPolicyList";
	}

}
