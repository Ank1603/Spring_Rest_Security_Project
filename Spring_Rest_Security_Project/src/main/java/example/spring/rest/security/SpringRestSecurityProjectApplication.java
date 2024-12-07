package example.spring.rest.security;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class SpringRestSecurityProjectApplication {
@Bean
public SecurityFilterChain getSEcurityFilterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(auth -> {
	auth.requestMatchers("/doGreet").permitAll();
	auth.requestMatchers("/doAdminWork");
	auth.requestMatchers("/ADMIN");
	auth.requestMatchers("/doRegularWork").hasAnyRole("ADMIN","REGULAR");
	});
	http.csrf(null);
	http.formLogin(Customizer.withDefaults());
	http.httpBasic(Customizer.withDefaults());
	return http.build();
	
	
}
@Bean
public UserDetailsService getUserDetailsService() {
	
	UserDetails adminUser = 
			User.withUsername("ricky").
			password(encoder().encode("reset123")).
			authorities("ADMIN").
			build();

	
	UserDetails regularUser = 
			User.withUsername("tim").
			password(encoder().encode("reset456")).
			authorities("REGULAR").
			build();
	
	UserDetailsService userDetailsServiceRef = new InMemoryUserDetailsManager()
}



	public static void main(String[] args) {
		SpringApplication.run(SpringRestSecurityProjectApplication.class, args);
	}

}
