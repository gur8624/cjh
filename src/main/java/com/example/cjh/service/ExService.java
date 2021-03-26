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
	loginmapper loginmapper;

	@Autowired
	public ExService(loginmapper loginmapper) {
		this.loginmapper = loginmapper;
	}

	public userDto insertUser(userDto userDto) {
		log.info("인서트유저확인" + userDto.getEmail());
		log.info("인서트유저확인2" + userDto.getPassword());
		loginmapper.insertUser(userDto);
		return userDto;
	}

	public userDto loginUser(userDto userDto) {
		log.info("아이디" + userDto);

		return loginmapper.loginUser(userDto);
	}

	public void updateUser(userDto dto) {
		loginmapper.loginUser(dto);
		log.info("dto찍히냐??" + dto);
		loginmapper.updateUser(dto);
		log.info("userdto찍히냐?" + dto);
		log.info("아이디" + dto.getEmail());
		log.info("비밀번호" + dto.getPassword());
	}





}

