package com.companyname.foodyfindy.service;

import com.companyname.foodyfindy.domain.User;
import com.companyname.foodyfindy.exception.FoodyFindyException;

public interface UserService {

	void save(User user) throws FoodyFindyException;

	/**`
	 * @param user
	 * @throws FoodyFindyException 
	 */
	void update(User user) throws FoodyFindyException;

	/**
	 * @param userId
	 * @return
	 * @throws FoodyFindyException 
	 */
	User get(String userId) throws FoodyFindyException;

	/**
	 * @param userId
	 * @throws FoodyFindyException 
	 */
	void delete(String userId) throws FoodyFindyException;
	

}
