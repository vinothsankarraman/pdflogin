package com.pdf.login.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdf.login.entity.LoginEntity;
import com.pdf.login.model.LoginModel;
import com.pdf.login.repository.LoginRepo;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepo repo;
	
	String regex="^[a-zA-Z0-9+_.-]+@(.+)$";
	
	public boolean isvalidemail (String userid)
	{
		System.out.println(userid);
		boolean valid = false;
				
		Pattern patternemail = Pattern.compile(regex);
		Matcher matcheremail = patternemail.matcher(userid);
		if(matcheremail.matches())
			valid=true;
		System.out.println(valid);
		
		return valid;
		
	}
	
	public boolean validateInputs(String userid, String password)
	{
		LoginEntity entity = new LoginEntity();
		LoginModel model = new LoginModel();
		boolean valid = false;
		
		if (!isvalidemail(userid))
			return valid;
		
		if(repo.existsByUserid(userid))
		{			
			entity=repo.findByUserid(userid);
			model.setUserid(entity.getUserid());
			model.setPassword(entity.getPassword());
			String pwd =  model.getPassword();
			
			if(pwd.equals(password))
				valid=true;
			System.out.println("Validate inputs login service.. " + valid);
		}
		return valid;
	}
	
	public boolean addUser(String userid, String password)	
	{
		LoginEntity entity = new LoginEntity();
		boolean valid = false;
		
		if (!isvalidemail(userid))
			return valid;
		
		if (repo.existsByUserid(userid))
			return valid;
		
		entity.setUserid(userid);
		entity.setPassword(password);
		repo.save(entity);
		valid=true;
		return valid;
	}
	

}
