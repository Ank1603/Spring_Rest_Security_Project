package example.spring.rest.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityRestController {
@GetMapping("/doGreet")//this resource does not security
public String getGreeting() {
	return "Welcome to the Spring security";
}
@GetMapping("/doAdminWork")//This resource is accessible only to ADMIN users
public String doAdminWork() {
	return "Doing admin work";
}
@GetMapping("/doRegularWork")//This resource is accessible to ADMIN as well as RGULARE users
public String doRegularWork() {
	return "Doing regular work";
}

}
