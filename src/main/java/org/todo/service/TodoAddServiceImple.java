package org.todo.service;

import java.util.List;

import org.todo.module.todoModule;
import org.todo.repository.*;
public class TodoAddServiceImple implements TodoAddService{
	TodoAddRepository tRepo=new TodoAddRepositoryImple();
	public boolean isTodoAdd(todoModule tm) {
			return tRepo.isTodoAdd(tm);
	}
	@Override
	public List<todoModule> ViewAllTodo() {
		
		return tRepo.ViewAllTodo();
	}
	@Override
	public List<todoModule> getByname(String name) {
	    List<todoModule> list=tRepo.getByname(name);
	    System.out.println(list);
		return tRepo.getByname(name);
	}
	@Override
	public boolean isupdate(todoModule tm) {
		
		return tRepo.isupdate(tm);
	}
	@Override
	public boolean isDelete(int id) {
		return tRepo.isDelete(id);
	}

}
