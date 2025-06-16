package com.project.EasyRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.EasyRoom.model.District;
import com.project.EasyRoom.model.Province;
import com.project.EasyRoom.model.User;
import com.project.EasyRoom.model.Ward;
import com.project.EasyRoom.service.EncryptionPassword;
import com.project.EasyRoom.service.UploadFile;
import com.project.EasyRoom.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
}

