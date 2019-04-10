package top.marching.service.impl;

import org.springframework.stereotype.Service;
import top.marching.dao.IUserDao;
import top.marching.model.User;
import top.marching.service.IUserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
