package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Auto implemented by Spring into a bean
 */
public interface UserRepository extends CrudRepository <User, Integer>, UserRepositoryCustom{
}
