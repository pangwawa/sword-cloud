package fun.codenow.sword.services.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/5 10:44
 **/
@Configuration
@EnableResourceServer
public class ResouceSecurityConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    AuthorizationCodeResourceDetails authorizationCodeResourceDetails;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /*@Autowired
    CustomAcessDeniedHandler customAcessDeniedHandler;*/

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(authorizationCodeResourceDetails.getClientId());
        /*resources.accessDeniedHandler(customAcessDeniedHandler);*/
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //设置创建session策略
       /* http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);*/
        http
                /*.addFilterBefore()*/
                .authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                /*.antMatchers("/auth/**").authenticated()*/
                .antMatchers("/doc.html","/v2/api-docs","/swagger-ui.html","/**/springfox-swagger-ui","/swagger-resources","/swagger-resources/configuration/ui","/webjars/**").permitAll()
                .anyRequest().authenticated()
        /*.anyRequest().access("")*/;
    }
}
