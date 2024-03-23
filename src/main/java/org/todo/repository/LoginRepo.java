package org.todo.repository;
import org.todo.module.RegisterModel;
public interface LoginRepo {
public RegisterModel isValidate(RegisterModel rm);
public boolean isUpdate(RegisterModel rm);
}
