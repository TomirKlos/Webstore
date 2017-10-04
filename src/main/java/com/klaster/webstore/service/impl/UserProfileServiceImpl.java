package com.klaster.webstore.service.impl;

import java.util.List;

import com.klaster.webstore.domain.UserProfile;
import com.klaster.webstore.domain.repository.UserProfileRepository;
import com.klaster.webstore.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by MSI DRAGON on 2017-10-02.
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public UserProfile findById(int id) {
        return userProfileRepository.findById(id);
    }

    public UserProfile findByType(String type){
        return userProfileRepository.findByType(type);
    }

    public List<UserProfile> findAll() {return userProfileRepository.findAll();}
}
