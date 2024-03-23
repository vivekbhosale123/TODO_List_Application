package org.todo.service;
import org.todo.repository.*;
import org.todo.controllerr.register;
import org.todo.module.RegisterModel;
public class registeraddserviceimple implements registeraddservice{
	registeraddrepository rRepo=new registeraddrepositoryimple();
	public boolean isAddRegister(RegisterModel rm) {
		return rRepo.isAddRegister(rm);
	}

}
