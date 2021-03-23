package com.example.cjh.service;


import com.example.cjh.dto.userDto;
import com.example.cjh.mapper.loginmapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExService {
	@Autowired(required = false)
	loginmapper loginmapper;

	public userDto insertUser(userDto userDto) {
		log.info("인서트유저확인" + userDto.getEmail());
		log.info("인서트유저확인2" + userDto.getPassword());
		loginmapper.insertUser(userDto);
		return userDto;
	}

	public userDto loginUser(String email, String password ) {
		log.info("아이디" + email,password);
		userDto Dto = loginmapper.loginUser(email, password);
		return Dto;
	}


//	public userDto findByUser(String email) {
//
//		return loginmapper.findByUser(email);
//	}


}

