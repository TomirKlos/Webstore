package com.klaster.webstore.converter;

import com.klaster.webstore.domain.UserProfile;
import com.klaster.webstore.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
/**
 * Created by MSI DRAGON on 2017-10-02.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{

    static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);

    @Autowired
    UserProfileService userProfileService;
    /**
     * Gets UserProfile by Id
     * @see //org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UserProfile convert(Object element) {
        System.out.println("Jestem w converteerze"); ///////////////////////////
        Integer id = Integer.parseInt((String)element);
        UserProfile profile= userProfileService.findById(id);
        logger.info("Profile : {}",profile);
        return profile;
    }

}
