package io.jtools.totp.infra.mail.web;

import java.io.Serializable;

import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Reset Password
 * 
 * @author KHJ
 *
 */
@Controller
@RequestMapping("")
public class mailController implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

//	@Autowired
//	CustomerService customerService;
//
//	@ModelAttribute
//	CustomerForm setUpForm() {
//		return new CustomerForm();
//	}
//	
//    @RequestMapping(method = RequestMethod.GET)
//    String list(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customers/list";
//    }
//    
//    /**
//     * 생성
//     * @param form
//     * @param result
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    String create(
//    		@Validated CustomerForm form
//    		, BindingResult result
//    		, Model model
//    		//@AuthenticationPrincipal를 붙이면 로그인 상태에 있는 LoginUserDetails 객체를 가져올 수 있음.
//    		, @AuthenticationPrincipal LoginUserDetails userDetails	
//    		) {
//    	if (result.hasErrors()) {
//			return list(model);
//		}
//    	Customer customer = new Customer();
//    	BeanUtils.copyProperties(form, customer);
//    	customerService.create(customer, userDetails.getUser());
//    	return "redirect:/customers";
//    }
//    
//    /**
//     * 수정 복사 폼
//     * @param id
//     * @param form
//     * @return
//     */
//    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
//    String editForm(@RequestParam Integer id, CustomerForm form) {
//    	Customer customer = customerService.findOne(id);
//    	BeanUtils.copyProperties(customer, form);
//    	return "customers/edit";
//    }
//	
//    /**
//     * 수정 처리
//     * @param id
//     * @param form
//     * @param result
//     * @return
//     */
//    @RequestMapping(value = "edit", method = RequestMethod.POST)
//    String edit(
//    		@RequestParam Integer id
//    		, @Validated CustomerForm form
//    		, BindingResult result
//    		, @AuthenticationPrincipal LoginUserDetails userDetails) {
//        if (result.hasErrors()) {
//            return editForm(id, form);
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(form, customer);
//        customer.setId(id);
//        customerService.update(customer, userDetails.getUser());
//        return "redirect:/customers";
//    }
//
//    /**
//     * 화면 전환 처리
//     * @return
//     */
//    @RequestMapping(value = "edit", params = "goToTop")
//    String goToTop() {
//        return "redirect:/customers";
//    }
//    
//    /**
//     * 삭제
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "delete", method = RequestMethod.POST)
//    String edit(@RequestParam Integer id) {
//    	customerService.delete(id);
//    	return "redirect:/customers";
//    }
}
