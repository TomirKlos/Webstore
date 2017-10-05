package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.User;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-10-02.
 */
public interface UserRepository {

    User findById(int id);

    User findBySSO(String sso);

    void save(User user);

    void saveCustomerAccount(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();

}
