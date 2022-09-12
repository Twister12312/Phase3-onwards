package Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import entities.User;


@Service
public class UserService {
	 RestTemplate restTemplate = new RestTemplate(); // to exchange information
     
	   
	    public void addUser(User pe){
	    	final String uri = "http://localhost:8080/api/info";
	        //Prepare parameter to pass
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	         //Find Record of a Person
	         
	         HttpEntity<User> httpEntity = new HttpEntity<>(pe, headers);

	     	RestTemplate restTemplate = new RestTemplate();
	     	User obj = restTemplate.postForObject(uri, httpEntity, User.class);}
}
