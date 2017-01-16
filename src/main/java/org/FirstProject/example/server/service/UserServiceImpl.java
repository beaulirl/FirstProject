package org.FirstProject.example.server.service;

import org.FirstProject.example.server.model.User;

/**
 * Created by Admin on 14.12.2016.
 */
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    public boolean removeUser(User user) {
        genericDao.delete(user);
        return true;
    }
}
