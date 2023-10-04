package com.ducs.service;

import com.ducs.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public void saveUser(User user);
	public boolean checkUser(String uname, String pwd);
	public boolean checkUsername(String uname , String pwd);
}
