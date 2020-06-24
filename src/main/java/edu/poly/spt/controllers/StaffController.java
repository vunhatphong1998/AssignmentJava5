package edu.poly.spt.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.spt.models.Staff;
import edu.poly.spt.dtos.StaffDto;
import edu.poly.spt.models.Depart;
import edu.poly.spt.services.StaffService;

@Controller
@RequestMapping("/staffs")
public class StaffController {
	Staff staff = new Staff();
	
	@Autowired
	private StaffService staffService;
	
	
	
		@RequestMapping("/list")
		public String list(ModelMap model, HttpSession session) {
			if(session.getAttribute("username")!=null) {
				model.addAttribute("staffs", staffService.findAll());
				return "staffs/list";
				
			}
			
			
			return "redirect:/login";
		}
		
		@GetMapping("/add")
		public String add(ModelMap model, HttpSession session) {
			if(session.getAttribute("username")!= null) {
				StaffDto staffDto = new StaffDto();
				
				model.addAttribute("staffDto", staffDto);
				
				return "staffs/addOrEdit";
			}
			
			
			
			return  "redirect:/login";
		}
		
		
//		@PostMapping("/saveOrUpdate")
//		public String saveOrUpdate(ModelMap model, Staff staff ) {
//			
//			
//			String message ="Đã thêm mới thành công";
//			if(staff.getId() != null && staff.getId()>0) {
//				message = " Đã sửa thành công";
//			}
//			
//			staffService.save(staff);
//			
//			
//			model.addAttribute(staff);
//			model.addAttribute("message", message);
//			
//			return "staffs/addOrEdit";
//		}
		
		
		@PostMapping("/saveOrUpdate")
		public String saveOrUpdate(ModelMap model, @Validated StaffDto staffDto ,BindingResult result ) {
		
			if(result.hasErrors()) {
				model.addAttribute("message", "vui lòng nhập thông tin các bắt buộc");
				model.addAttribute("staffDto", staffDto);
				
				return "staffs/addOrEdit";
			}
			
			
			
//			if(staffDto.getId() != null && staffDto.getId() >0 ) {
//				model.addAttribute("message" , "Đã sửa thành công");
//				
//			}else {
//				model.addAttribute("message", "Đã thêm một nhân viên mới");
//			}
			
			
			
			Path path = Paths.get("images/");
			
			try(InputStream inputStream =  staffDto.getImage().getInputStream()){
				Files.copy(inputStream, path.resolve(staffDto.getImage().getOriginalFilename()), 
				 StandardCopyOption.REPLACE_EXISTING);
				String filename = staffDto.getImage().getOriginalFilename();
				
			}catch(Exception e ) {
			  e.printStackTrace();
			  model.addAttribute("message", "error: " + e.getMessage());
				
			}
			
			Staff staff = new Staff();
			staff.setBirthday(staffDto.getBirthday());
			staff.setName(staffDto.getName());
			staff.setEmail(staffDto.getEmail());
			staff.setLuong(staffDto.getLuong());
			staff.setPhone(staff.getPhone());
			staff.setNotes(staffDto.getNotes());
			staff.setPhoto(staffDto.getImage().getOriginalFilename());
			Depart depart = new Depart();
			depart.setId(staffDto.getDepartId());
			
			staff.setDepart(depart);
		
			
			
			staffService.save(staff);
			
			model.addAttribute("staffDto", staffDto);
			
			return "staffs/addOrEdit";
		
		}
		
		
		
		
		
		@ModelAttribute(name ="departs")
		public List<Depart> getDeparts(){
			return staffService.findAllDeparts();
		}
		
		
		 @GetMapping("/delete/{id}")
		   public String delete(ModelMap model, @PathVariable(name = "id") Integer id, HttpSession session) {
			   
			  staffService.deleteById(id);	
			   
			   
			   return list(model, session);
		   }
		 
		 @GetMapping("/edit/{id}")
		   public String edit(ModelMap model, @PathVariable(name = "id") Integer id, HttpSession session) {
			   Optional<Staff> optStaff = staffService.findById(id);
			  System.out.println(staff);
			    if(optStaff.isPresent()) {
			    	model.addAttribute("staff", optStaff.get());
			    }else {
			    	return list(model, session);
			    }
			   
			   
			   return "staffs/addOrEdit";
		   }
		
		
}
