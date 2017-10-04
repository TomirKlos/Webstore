package com.klaster.webstore.service;

import com.klaster.webstore.domain.UserProfile;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-10-02.
 */
public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}
