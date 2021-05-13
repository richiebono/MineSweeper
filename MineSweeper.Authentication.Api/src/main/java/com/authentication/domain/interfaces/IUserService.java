package com.authentication.domain.interfaces;

import com.authentication.domain.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {


  Page<User> findAll(Pageable pageable);

  User findById(Long userId);

  User save(User user);

  void delete(User user);
}
