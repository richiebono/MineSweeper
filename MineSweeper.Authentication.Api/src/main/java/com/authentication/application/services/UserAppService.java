package com.authentication.application.services;


import com.authentication.application.interfaces.IUserAppService;
import com.authentication.application.models.UserViewModel;
import com.authentication.domain.entity.User;
import com.authentication.domain.interfaces.IUserService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Slf4j
public class UserAppService implements IUserAppService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IUserService userService;

	@Override
	public Page<UserViewModel> findAll(Pageable pageable) {
		return userService.findAll(pageable).map(this::convertToViewModel);
	}

	@Override
	public UserViewModel save(UserViewModel userViewModel ) {
		User user = modelMapper.map(userViewModel, User.class);
		return convertToViewModel(userService.save(user));
	}

	@Override
	public UserViewModel findById(Long userId) {
		return convertToViewModel(userService.findById(userId));


	}

	@Override
	public void delete(UserViewModel userViewModel) {
		User user = modelMapper.map(userViewModel, User.class);
		userService.delete(user);
	}

	public UserViewModel convertToViewModel(User user) {
		return modelMapper.map(user, UserViewModel.class);
	}

}
