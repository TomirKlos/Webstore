package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.UserProfile;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-10-02.
 */
public interface UserProfileRepository {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}
