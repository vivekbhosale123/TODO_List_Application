package org.todo.service;

import java.util.List;

import org.todo.module.todoModule;

public interface TodoAddService {
	public boolean isTodoAdd(todoModule tm);
	public List<todoModule> ViewAllTodo();
	public List<todoModule> getByname(String name);
	public boolean isupdate(todoModule tm);
	public boolean isDelete(int id);
}
