package fun.codenow.sword.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 11:35
 **/
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorityList=new ArrayList<>();
        GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ROLE_ADMIN");
        grantedAuthorityList.add(grantedAuthority);
        User user=new User(account,passwordEncoder.encode("123456"),true,true,true,true,grantedAuthorityList);
        return user;
    }
}
