package com.klaster.webstore.domain.repository.impl;

import java.util.List;

import com.klaster.webstore.domain.UserProfile;
import com.klaster.webstore.domain.repository.AbstractRepository;
import com.klaster.webstore.domain.repository.UserProfileRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 * Created by MSI DRAGON on 2017-10-02.
 */
@Repository("userProfileDao")
public class UserProfileRepositoryImpl extends AbstractRepository<Integer, UserProfile> implements UserProfileRepository {

    public UserProfile findById(int id) {
        return getByKey(id);
    }

    public UserProfile findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (UserProfile) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<UserProfile>)crit.list();
    }

}