package com.authentication.domain.services;

import com.authentication.domain.entity.User;
import com.authentication.domain.exception.UserException;
import com.authentication.domain.interfaces.IUserService;
import com.authentication.infrastructure.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserService implements IUserService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  UserRepository userRepository;

  @Override
  public Page<User> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  public User findById(Long userId) {
    log.info("[Authentication Service] - Finding a user by userId={}", userId);
    return userRepository.findById(userId)
        .map(user -> modelMapper.map(user, User.class))
        .orElseThrow(() -> new UserException(String.format("User not found")));
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(User user) {
    userRepository.delete(user);
  }
}
