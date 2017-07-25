/**
 * 
 */
package com.companyname.foodyfindy.serviceimpl;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.companyname.foodyfindy.domain.User;
import com.companyname.foodyfindy.exception.FoodyFindyException;
import com.companyname.foodyfindy.repositories.UserRepository;
import com.companyname.foodyfindy.service.UserService;

/**
 * @author lingadal
 *
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	SecureRandom random = new SecureRandom();

	@Override
	public void save(User user) throws FoodyFindyException {
		// user.setId(new BigInteger(130, random).toString(32));
		validateRequest(user);
		userRepository.save(user);
	}

	@Override
	public void update(User user) throws FoodyFindyException {
		User dbUser = userRepository.findOne(user.getId());
		if (dbUser == null) {
			throw new FoodyFindyException(HttpStatus.NOT_FOUND, 1005,
					"cannot update user details as user doesn't exit in db");
		} else {
			userRepository.save(user);
		}

	}

	@Override
	public User get(String userId) throws FoodyFindyException {
		User user = userRepository.findOne(userId);
		if (user == null) {
			throw new FoodyFindyException(HttpStatus.NOT_FOUND, 1004, "user doesn't exit");
		}
		return user;
	}

	@Override
	public void delete(String userId) throws FoodyFindyException {
		try {
			userRepository.delete(userId);
		} catch (Exception e) {
			throw new FoodyFindyException(HttpStatus.NOT_FOUND, 1004, "user doesn't exit");
		}

	}

	/**
	 * @param user
	 */
	private void validateRequest(User user) throws FoodyFindyException {
		String userIdRegex = "^[a-zA-Z0-9]*$";
		Pattern emailregex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailregex.matcher(user.getEmail());
		if (user.getId() == null || !(user.getId().matches(userIdRegex))) {
			throw new FoodyFindyException(HttpStatus.BAD_REQUEST, 1001, "wrong userid : expected alphanumeric pattern");
		} else if (!matcher.find()) {
			throw new FoodyFindyException(HttpStatus.BAD_REQUEST, 1002, "wrong email");
		} else if (StringUtils.isEmpty(user.getPassword())) {
			throw new FoodyFindyException(HttpStatus.BAD_REQUEST, 1003, "Password incorrect");
		}
	}

}
