package com.xilidou.do4j.auth;

import com.xilidou.do4j.entity.RoleEntity;
import com.xilidou.do4j.entity.UserEntity;
import com.xilidou.do4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetails implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() ->
						new UsernameNotFoundException("User '" + username + "' not found")
				);

		Set<RoleEntity> roles = user.getRoles();

		List<SimpleGrantedAuthority> authorities = roles.stream().map(t -> new SimpleGrantedAuthority(t.getName().name())).collect(Collectors.toList());

		return User.withUsername(username)
				.password(user.getPassword())
				.authorities(authorities)
				.accountExpired(false)
				.accountLocked(false)
				.credentialsExpired(false)
				.disabled(false)
				.build();
	}

}
