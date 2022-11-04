package com.users.details.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.users.details.Model.Admin;
import com.users.details.Model.User;
import com.users.details.MongoRepository.AdminRepository;
import com.users.details.Service.UserService;


@RestController
@CrossOrigin
public class MyController {

	@Autowired
	private UserService userService;
	
	@Autowired
	AdminRepository adminRepo;
	
	@PostMapping("/register")
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "Data Successfully Submit";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/update/{roll}")
	public String updateUser(@RequestBody User user, @PathVariable("roll") int roll) {
		userService.updateUser(roll, user);
		return "Your Data Successfully Updated";
	}
	
	@DeleteMapping("/delete/{roll}")
	public String deleteUser(@PathVariable("roll") int roll) {
		 userService.deleteUser(roll);
		 return "deleted succesfully.";
	}
	
	@GetMapping("/findById/{roll}")
	public Optional<User> getOneUser(@PathVariable("roll") int roll){
		return userService.getOneUser(roll);
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam String password, @RequestParam String name) {
		userService.checkUser(password,name);
		return "Login Successfull";
	}
	
	@PostMapping("/loginAdminPage")
	public ResponseEntity<?> loginAdmin(@RequestBody Admin adminData){
		Admin admin=adminRepo.findByName(adminData.getName());
		if(admin.getPassword().equals(adminData.getPassword()))
			return ResponseEntity.ok(admin);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();		
	}
	
	@PostMapping("/loginAdmin/{name}")
	public int getAdminById(@PathVariable String name,@RequestBody Admin admin) {
		int flag =0;
		Admin adminObj =adminRepo.findById(name).orElseThrow(()-> new ResourceAccessException("User Not Found !! "+name));
		if(admin.getName().equals(admin.getName()) && admin.getPassword().equals(admin.getPassword())) {
			flag=1;
		}
		return flag;
	}
	
//	@PostMapping("/adminLogin/{name}")
//	public int getAdminById(@PathVariable String name,@RequestBody Admin admin) {
//		int flag=0;
//		Admin adminObj= amdinRepo.findById(name).orElseThrow(()-> new ResourceAccessException("User Not Found !!"+name));
//		
//		if(admin.getName().equals(admin.getName()) && admin.getPassword().equals(admin.getPassword())) {
//			flag=1;
//		}
//		return flag;
//	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/loginPage")
//	public String loginPage(Admin login ,@RequestParam String name ,@RequestParam String password) {
//		
//		
////		if(password.equals("1234") && name.equals("Abhi")) {
//		 if (login.getPassword().equals("1234") && login.getName().equals("Abhishek")) {
//	//	if(login.getName().equals(name) && login.getPassword().equals(password)) {
//			
////		if(login.getName().equals("Abhi") && login.getPassword().equals("1234")) {
//			return "welcome !! User Login Successfull";
//		}else {
//			return "Oops !! Sorry !! Please Correct Password ";
//		}
//	}
	
//	@PostMapping("/userLogin")
//	public User userLogin(@RequestBody User user) throws Exception {
//		String name=user.getName();
//		String password=user.getPassword();
//		User userObj=null;
//		if(name!=null && password!=null) { 
//		//	userObj=userService.findByNameAndPassword(name,password);
//		}
//		if(userObj==null) {
//			throw new Exception("Invalid Opreation");
//		}
//		return userObj;
//	}
//	

