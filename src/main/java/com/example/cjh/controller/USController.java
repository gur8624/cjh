package com.example.cjh.controller;



import com.example.cjh.dto.userDto;
import com.example.cjh.service.ExService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequiredArgsConstructor
@Controller
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
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginForm() {
        return "/login";
    }

    @PostMapping(value = "/login")
    public String signIn(String email, String password) {
        log.info("아아아아이디" + email);
        log.info("비미미미밀번호" + password);
        service.loginUser(email, password);
        return "redirect:/";
    }

//    @GetMapping(value = "/users")
//    public String list(Model model, userDto userDto) {
//
//        userDto = service.findByUser(userDto.getEmail());
//        model.addAttribute("users", userDto);
//        return "/users";
//    }

}




