package top.marching.service;


import top.marching.model.User;

public interface IUserService {

    public User selectUser(long userId);

    void addUser(User user);
}
