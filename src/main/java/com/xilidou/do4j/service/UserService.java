package com.xilidou.do4j.service;

import com.google.common.collect.Sets;
import com.xilidou.do4j.auth.JwtTokenProvider;
import com.xilidou.do4j.entity.RoleEntity;
import com.xilidou.do4j.entity.RoleName;
import com.xilidou.do4j.entity.UserEntity;
import com.xilidou.do4j.exception.CustomException;
import com.xilidou.do4j.repository.RoleRepository;
import com.xilidou.do4j.repository.UserRepository;
import com.xilidou.do4j.vo.UserRequestVo;
import com.xilidou.do4j.vo.UserResponseVo;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Transactional
	public UserResponseVo signIn(UserRequestVo vo){

		String username = vo.getUsername();
		String password = vo.getPassword();

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		UserEntity user = userRepository.findByUsername(username).get();
		String token = tokenProvider.createToken(username, user.getRoles());
		UserResponseVo userResponseVo = new UserResponseVo();
		userResponseVo.setToken(token);
		userResponseVo.setUsername(username);
		return userResponseVo;

	}

	@Transactional
	public UserResponseVo signUp(UserRequestVo vo){

		Optional<UserEntity> byUsernameOrEmail = userRepository.findByUsernameOrEmail(vo.getUsername(), vo.getEmail());

		if(byUsernameOrEmail.isPresent()){
			throw new CustomException("用户已经存在", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		RoleEntity roleByName = roleRepository.findByName(RoleName.ROLE_USER_FREE)
				.orElseThrow(() -> new CustomException("role not set",HttpStatus.UNPROCESSABLE_ENTITY));

		UserEntity userEntity = new UserEntity();





		BeanUtils.copyProperties(vo,userEntity);

		userEntity.setPassword(passwordEncoder.encode(vo.getPassword()));
		userEntity.setRoles(Sets.newHashSet(roleByName));

		UserEntity save = userRepository.save(userEntity);

		String token = tokenProvider.createToken(save.getUsername(), save.getRoles());
		UserResponseVo userResponseVo = new UserResponseVo();
		userResponseVo.setToken(token);
		userResponseVo.setUsername(save.getUsername());
		return userResponseVo;





	}



}
