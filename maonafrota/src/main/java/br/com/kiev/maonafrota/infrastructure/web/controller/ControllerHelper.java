package br.com.kiev.maonafrota.infrastructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ControllerHelper {
	
	public static void setEditMode(Model model, boolean isEdit) {
		model.addAttribute("editMode", isEdit);
	}
}
