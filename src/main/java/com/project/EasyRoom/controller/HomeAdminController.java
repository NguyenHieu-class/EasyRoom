package com.project.EasyRoom.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.EasyRoom.constants.FiledName;
import com.project.EasyRoom.model.Booking;
import com.project.EasyRoom.model.Event;
import com.project.EasyRoom.model.User;
import com.project.EasyRoom.service.BlogService;
import com.project.EasyRoom.service.BookingService;
import com.project.EasyRoom.service.CarService;
import com.project.EasyRoom.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeAdminController implements FiledName {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CarService carService;
	
	
	@GetMapping("/admin")
	public String getHome(Model model,  HttpServletRequest request) {
		
		System.err.println(" tông: "+bookingService.countBill());
		model.addAttribute("countBill", bookingService.countBill());
		model.addAttribute("countCar", carService.countCar());
		model.addAttribute("countUser", userService.countUser());
		model.addAttribute("countBlog", blogService.countBlog());

		// Lấy ngày hiện tại
		LocalDate now = LocalDate.now();
		LocalDate nowPlus= now.plusDays(1);
		System.out.println(" ngay sau khi cong: "+now.plusDays(1));
		// Lấy ngày cách đây 30 ngày
		LocalDate last30Days = now.minusDays(30);
		String[] array= bookingService.sumRevenueOnTime(last30Days.toString(),nowPlus.toString(),STATUS_PAYMENT);
		String valueNgay = "";
		valueNgay += "[";
		String valueTongTien = "";
		valueTongTien += "[";	
		for( int i=0; i<array.length;i++) {
			System.err.println(array[i]);
			String[] arra= array[i].split(",");
			valueNgay=valueNgay+ "\""+arra[0]+"\""+"," ;
			valueTongTien=valueTongTien+ arra[1]+",";
		}
		valueNgay=valueNgay.substring(0, valueNgay.length()-1);
		valueTongTien=valueTongTien.substring(0,valueTongTien.length()-1);
		valueNgay=valueNgay+"]";
		valueTongTien=valueTongTien+"]";
		model.addAttribute("valueDate", valueNgay);
		model.addAttribute("totalMoney", valueTongTien);
		return "admin/pages/index";

	}
	@GetMapping("/admin/analysist")
	public String getAnalysis(Model model,  HttpServletRequest request) {
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("sesionUser");
		if(sessionUser!=null) {
			if (sessionUser.getRole().getIdRole()==ROLE_ACCOUNTANT || 
					sessionUser.getRole().getIdRole()==ROLE_ADMIN ) {
				return "admin/pages/analysis/analysis";
			}else {
				return "redirect:/login";
			}
		}
		 else {
			 return "redirect:/login";
		}
		
	}
	
	@PostMapping("/admin/analysist")
	public String getAnalysis(Model model, @RequestParam("dateStart") String dateStart,
			@RequestParam("dateEnd") String dateEnd,  HttpServletRequest request) {
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("sesionUser");
		if(sessionUser!=null) {
			if (sessionUser.getRole().getIdRole()==ROLE_ACCOUNTANT || 
					sessionUser.getRole().getIdRole()==ROLE_ADMIN ){
				List<Booking> listBooking= bookingService.getBookingOnTimeByStatusBill(dateStart, dateEnd, STATUS_PAYMENT);
				model.addAttribute("listBooking", listBooking);
				String[] array= bookingService.sumRevenueOnTime(dateStart,dateEnd,STATUS_PAYMENT);
				String valueNgay = "";
				valueNgay += "[";
				String valueTongTien = "";
				valueTongTien += "[";	
				for( int i=0; i<array.length;i++) {
					System.err.println(array[i]);
					String[] arra= array[i].split(",");
					valueNgay=valueNgay+ "\""+arra[0]+"\""+"," ;
					valueTongTien=valueTongTien+ arra[1]+",";
				}
				valueNgay=valueNgay.substring(0, valueNgay.length()-1);
				valueTongTien=valueTongTien.substring(0,valueTongTien.length()-1);
				valueNgay=valueNgay+"]";
				valueTongTien=valueTongTien+"]";
				model.addAttribute("valueDate", valueNgay);
				model.addAttribute("totalMoney", valueTongTien);
				
				return "admin/pages/analysis/analysis";
			}else {
				return "redirect:/login";
			}
		}
		 else {
			 return "redirect:/login";
		}
		
		
	}
}
