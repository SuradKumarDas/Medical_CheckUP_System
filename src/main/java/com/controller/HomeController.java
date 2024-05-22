package com.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.MedicalCheckUp;
import com.serice.MedicalService;
import com.service.impl.MedicalServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private MedicalService service;

	@InitBinder
	public void customPropertyEditor(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping({ "/ui", "/" })
	public String showHomePage() {
		return "Ui";
	}

	@RequestMapping("/home")
	public String showHome() {
		return "Home";
	}

	@RequestMapping(value = { "/home" }, method = { RequestMethod.POST })
	public String saveBooking(@ModelAttribute MedicalCheckUp med, RedirectAttributes redirectAttributes) {
		System.out.println(med);
		MedicalServiceImpl serv = new MedicalServiceImpl();
		Integer id = serv.saveBooking(med);
		redirectAttributes.addFlashAttribute("patient_id", id);
		if (id != null && id > 0) {
			redirectAttributes.addFlashAttribute("successmsg", "Medical treatment slot booked successfully");
		} else {
			redirectAttributes.addFlashAttribute("failuremsg", "System problem. Please contact Help desk.");
		}

		return "redirect:/";
	}

	@RequestMapping("/about")
	public String showAbout() {
		return "AboutUs";
	}

	@RequestMapping("/contact")
	public String showContact() {
		return "ContactUs";
	}

	@RequestMapping("/delete")
	public String deletePatient() {
		return "Delete";
	}

	@RequestMapping("/aponitment")
	public String takeApointment() {
		return "Apointment";
	}

	@RequestMapping("/updateId")
	public String updatePatient() {
		return "Update";
	}

	@RequestMapping("/updateform")
	public String updatePatientForm() {
		return "UpdateForm";
	}

	@RequestMapping(value = { "/delete" }, method = { RequestMethod.POST })
	public String deleteBookingById(HttpServletRequest request, RedirectAttributes attrs) {
		int patientId = Integer.parseInt(request.getParameter("patient_id"));
		boolean result = service.deleteBookingById(patientId);
		if (result) {
			attrs.addFlashAttribute("message", "slot deleted successfully");
		} else {
			attrs.addFlashAttribute("message", "Failed to delete slot");
		}
		return "redirect:/ui";
	}

	@RequestMapping("/getDetails")
	public String getAllBooking(@ModelAttribute MedicalCheckUp mdcl, HttpServletRequest request) {
		List<MedicalCheckUp> patientDetails = service.getAllBooking();
		request.setAttribute("patients", patientDetails);
		return "ShowAllBooking";
	}

	@RequestMapping("/updatedetails")
	public String updateBooking(@ModelAttribute MedicalCheckUp mdcl, HttpServletRequest request) {

		String idStr = request.getParameter("patient_id");
		if (idStr != null && !idStr.isEmpty()) {
			try {
				int id = Integer.parseInt(idStr);
				request.setAttribute("id", id);

				int patient = service.updateBooking(mdcl); // Assuming your service method takes an id and
															// MedicalCheckUp object
				request.setAttribute("patient", patient);

			} catch (NumberFormatException e) {

				e.printStackTrace();
			}
		}

		return "redirect:/getDetails";
	}
}
