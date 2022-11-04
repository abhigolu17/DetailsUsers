package com.users.details.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.users.details.Model.User;
import com.users.details.MongoRepository.UserRepository;

@Service
@Component
public class UserServiceImpl implements UserService{

	User user;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(int roll, User user) {
		Optional<User> findById = userRepository.findById(roll);
		if (findById.isPresent()) {
			User userEntity = findById.get();
			if (user.getName() != null)
				userEntity.setName(user.getName());
			if (user.getAge() != null)
				userEntity.setAge(user.getAge());
//			if (user.getAddress() != null)
//				userEntity.setAddress(user.getAddress());
			if (user.getPassword() != null)
				userEntity.setPassword(user.getPassword());
			return userRepository.save(userEntity);
		}
		return null;
	}

	@Override
	public void deleteUser(Integer roll) {
		try {
		userRepository.deleteById(roll);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Optional<User> getOneUser(int roll) {	
		return userRepository.findById(roll);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String checkUser(String name, String password){
		try {
		if(userRepository.equals(user.getPassword()!=null) && userRepository.equals(user.getName()!=null)) {
			return "Login Successfull";
		}
		else {
			return "somthing wrong";
		}}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public User findByNameAndPassword(String name, String password) {
//		return userRepository.findLogin(name,password);		
//	}

	
//	@Override
//	public void loginUser(User user) {
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
//        if (user.getName().length() < 6 || user.getName().length() > 32) {
//            errors.rejectValue("name", "Size.userForm.username");
//        }
//
//        if (!user.getPassword().equals(user.getPassword())) {
//            errors.rejectValue("PassowordConfirm", "Diff.user.PasswordConfirm");
//        }
//	}

}
