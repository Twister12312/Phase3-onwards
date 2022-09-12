package com.mphasis3._User_Authentication;

public class Validate {
public boolean isUser(String user, String pass) {
	if(user.equals("Admin")&&pass.equals("123"))return true;
	
	return false;
}
}
