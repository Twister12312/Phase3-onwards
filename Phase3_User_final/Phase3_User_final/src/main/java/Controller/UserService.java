package Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import entities.UserLog;

@Service
public class UserService {

	  RestTemplate restTemplate = new RestTemplate(); // to exchange information
      
	   
	    public void addUser(UserLog pe){
	    	/*final String uri = "http://localhost:8080/api/info";
	        //Prepare parameter to pass
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	         //Find Record of a Person
	         
	         HttpEntity<UserLog> httpEntity = new HttpEntity<>(pe, headers);

	     	RestTemplate restTemplate = new RestTemplate();
	     	UserLog obj = restTemplate.postForObject(uri, httpEntity, UserLog.class);*/}

	     	
}
