package top.marching.dao;


import top.marching.model.User;

public interface IUserDao {

    User selectUser(long id);
}