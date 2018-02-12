package com.shubham.ecommercefrontend;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	  private DataSource dataSource;


@SuppressWarnings("deprecation")
@Bean
public static NoOpPasswordEncoder passwordEncoder() {
return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
}
	

/*@Override
public void configure(AuthenticationManagerBuilder builder)
        throws Exception {
    builder.jdbcAuthentication()
           .dataSource(dataSource)
           .withDefaultSchema()
           .withUser("admin@admin.com").password("12345").roles("ADMIN")
           .and()
           .withUser("sh@gmail.com").password("12345").roles("USER");
}
*/


	/*@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email, password, enabled from user_detail where email=?")
				.authoritiesByUsernameQuery("select email,role from user_detail where email=?");
	}*/
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	        .inMemoryAuthentication()
	            .withUser("admin@admin.com").password("admin").roles("USER");
	
	  /*auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery("select email, password, enabled from user_detail where email=?")
	  .authoritiesByUsernameQuery("select email,role from user_detail where email=?");
		*/
	}
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		/*for admin*/
		.antMatchers("/admin/**").access("hasAuthority('ADMIN')")
		/*for users*/
		.antMatchers("/cart/**").access("hasAuthority('USER'))")
		/*for all*/
		.antMatchers("/**").permitAll()
		.and().formLogin()
		.and()
	    .exceptionHandling().accessDeniedPage("/access-denied");
	   
	  }
 
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
	}*/
	
	
	
	
	
	
	
	
	/*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin@admin.com").password("admin").roles("USER");
		
		  auth.jdbcAuthentication().dataSource(dataSource)
          .usersByUsernameQuery("select email, password, enabled from user_detail where email=?")
          .authoritiesByUsernameQuery("select email,role from user_detail where email=?");
		
    }*/
	
	
/*	 @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery("select email, password, enabled"
	            + " from user_detail where email=?")
	        .authoritiesByUsernameQuery("select email, role "
	            + " from user_detail where email=?");
	        
	  }
	 
	 
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
	    .and()
	    .httpBasic(); // Authenticate users with HTTP basic authentication
	  }*/
	
	 
	
/*	@Override
	  protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
	    .and().formLogin()
		.loginPage("/login") 
		.permitAll();
	   
	  }
	*/
     
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
   
      http.authorizeRequests()
      	.antMatchers("/**").access("hasRole('USER')") 
        .and().formLogin()
		.loginPage("/login") 
		.permitAll(); 
       
      //http.csrf().disable();
    }  */
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }
    
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      auth.jdbcAuthentication().dataSource(dataSource)
          .usersByUsernameQuery("select email, password, enabled from user_detail where email=?")
          .authoritiesByUsernameQuery("select email,role from user_detail where email=?");
    }
*/
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {

      http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
      .and()
      .httpBasic(); // Authenticate users with HTTP basic authentication
    }*/
	
}


/****
 * 
 
 Similar to 
 
 <http auto-config="true">
    <intercept-url pattern="/admin**" access="hasRole('ADMIN')" />
    <csrf disabled="true" />
</http>
 
<authentication-manager>
    <authentication-provider>
        <user-service>
            <user name="admin" password="nimda" authorities="ADMIN" />
        </user-service>
    </authentication-provider>
</authentication-manager>
 
 in xml
 *
 * 
 * */
 
/**more for example**
 
 .java
 @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();

	}
	
	equivalent to .xml
	
	<http auto-config="true">
	<intercept-url pattern="/admin**" access="ROLE_ADMIN" />
	<intercept-url pattern="/dba**" access="ROLE_ADMIN,ROLE_DBA" />
</http>

<authentication-manager>
  <authentication-provider>
    <user-service>
	<user name="mkyong" password="123456" authorities="ROLE_USER" />
	<user name="admin" password="123456" authorities="ROLE_ADMIN" />
	<user name="dba" password="123456" authorities="ROLE_DBA" />
    </user-service>
  </authentication-provider>
</authentication-manager>
 
 * 
 * 
 */

