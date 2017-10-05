package com.klaster.webstore.service;

import com.klaster.webstore.domain.User;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-10-02.
 */
public interface UserService {

    User findById(int id);

    User findBySSO(String sso);

    void saveUser(User user);

    void saveCustomerAccount(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    List<User> findAllUsers();

    boolean isUserSSOUnique(Integer id, String sso);

}
