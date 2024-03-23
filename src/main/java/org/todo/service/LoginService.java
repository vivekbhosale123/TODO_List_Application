package org.todo.service;

import org.todo.module.RegisterModel;

public interface LoginService {
	public RegisterModel isValidate(RegisterModel rm);
	public boolean isUpdate(RegisterModel rm);
}
