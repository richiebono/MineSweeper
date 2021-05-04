package com.authentication.repository;

import com.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Richard Bono
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 *
	 * @param username
	 * @return @{@link User}
	 */
	User findOneByUsername(String username);
}
