package com.cts.user.security;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.user.entities.User;
import com.cts.user.repositories.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = usersDao.findByEmail(username);

		if (user.isPresent()) {
			List<SimpleGrantedAuthority> authorities = Collections
					.singletonList(new SimpleGrantedAuthority(user.get().getRole()));
			return new org.springframework.security.core.userdetails.User(user.get().getEmail(),
					user.get().getPassword(), authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
