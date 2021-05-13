package com.authentication.application.interfaces;

import com.authentication.application.models.UserViewModel;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserAppService {


  Page<UserViewModel> findAll(Pageable pageable);

  UserViewModel save(UserViewModel user);

  UserViewModel findById(Long userId);

  void delete(UserViewModel user);
}
