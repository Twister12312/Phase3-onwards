package com.mphasis3._User_Authentication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(ParamResolve.class)
class Authentication_test {

	
	@Test
    @Tag("my-tag")
    void test(Validate v) {
		String user="Admin";
		String password="12";
		assertEquals(true,v.isUser(user, password));
	}
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

}
