package com.example.cjh.controller;



import com.example.cjh.dto.userDto;
import com.example.cjh.mapper.loginmapper;
import com.example.cjh.service.ExService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Log4j2
public class USController {
    private final ExService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping(value = "/signup")
    public String createForm() {
        return "/signup";
    }

    @PostMapping(value = "/signup")
    public String create(userDto userDto) {
        log.info("아이디!!!!" + userDto.getEmail());
        log.info("비밀번호!!!!" + userDto.getPassword());
        service.insertUser(userDto);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String loginForm() {
        return "/login";
    }

    @PostMapping(value = "/login")
    public String signIn(userDto userDto, HttpServletRequest request, RedirectAttributes attributes, Model model) {
        log.info("controller");
        HttpSession session = request.getSession();
        log.info("서비스 통과");
        userDto user2 = service.loginUser(userDto);
        log.info("아아아아이디" + user2);
        if(user2 != null) {
            session.setAttribute("LoginUser", user2);
            model.addAttribute("id", user2.getCode());
        }
        return "redirect:/";
    }


    @GetMapping(value = "/users")
    public String list() {
        return "/users";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = (HttpSession) request.getSession();
        session.removeAttribute("email");
        session.invalidate();
        return "redirect:";
    }

    @PostMapping(value = "/update")
    public String updateUser(userDto userDto,String email, HttpServletRequest request) {
        HttpSession session = request.getSession();
        service.updateUser(userDto);
        session.invalidate();
        log.info("데이터넘어가냐...?" + userDto);
        return "redirect:";
    }

    @GetMapping(value = "/update")
    public String updateUser2() {
        return "/update";
    }




}




