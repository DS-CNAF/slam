package pl.cyfronet.indigo.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import pl.cyfronet.indigo.bean.Role;
import pl.cyfronet.indigo.bean.Team;
import pl.cyfronet.indigo.bean.User;
import pl.cyfronet.indigo.security.PortalUser;
import pl.cyfronet.indigo.security.UserInfo;

public class AuthenticationMocks {

    private AuthenticationMocks() {
    }

    public static Authentication userAuthentication(Long id) {
        Team team = new Team();
        team.setName("test");
        Role role = new Role();
        role.setName("manager");
        User user = User.builder().id(id).name("user").teams(Arrays.asList(team)).roles(Arrays.asList(role)).build();
        team.setMembers(Arrays.asList(user));
        role.setUsers(Arrays.asList(user));
        List<GrantedAuthority> auth = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        PortalUser pu = PortalUser.builder().principal(UserInfo.fromUser(user)).user(user).authorities(auth).isAuthenticated(true).build();
        return pu;
    }

    public static Authentication adminAuthentication(Long id) {
        User user = User.builder().id(id).build();
        List<GrantedAuthority> auth = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        PortalUser pu = PortalUser.builder().principal(UserInfo.fromUser(user)).user(user).authorities(auth).isAuthenticated(true).build();
        return pu;
    }

}
