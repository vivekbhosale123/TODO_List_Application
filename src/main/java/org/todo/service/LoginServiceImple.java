package org.todo.service;

import org.todo.module.RegisterModel;
import org.todo.repository.*;
public class LoginServiceImple implements LoginService{
	LoginRepo lRepo=new LoginRepoImple();
	public RegisterModel isValidate(RegisterModel rm) {
		return lRepo.isValidate(rm);
	}
	@Override
	public boolean isUpdate(RegisterModel rm) {
		return lRepo.isUpdate(rm);
	}

}
