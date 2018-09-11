package com.myapp.SpringMVCApp.dao;

import com.myapp.SpringMVCApp.model.Login;
import com.myapp.SpringMVCApp.model.User;
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
}