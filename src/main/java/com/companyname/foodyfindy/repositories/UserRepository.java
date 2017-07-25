package com.companyname.foodyfindy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.companyname.foodyfindy.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
