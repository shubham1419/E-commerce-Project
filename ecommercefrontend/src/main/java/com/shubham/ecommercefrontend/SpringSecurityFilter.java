package com.shubham.ecommercefrontend;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityFilter extends AbstractSecurityWebApplicationInitializer {
	
	
}

/***
Similar to


<filter>
    <filter-name>springSecurityFilterChain</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
 
<filter-mapping>
    <filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>

in xml

***/