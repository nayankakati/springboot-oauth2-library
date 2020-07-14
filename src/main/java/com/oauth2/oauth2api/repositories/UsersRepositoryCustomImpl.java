package com.oauth2.oauth2api.repositories;

import com.oauth2.oauth2api.domains.Users;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersRepositoryCustomImpl implements UsersRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Users findByUsername(String username) throws RuntimeException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> query = cb.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(root.get("username"), username));
        CriteriaQuery<Users> criteriaQuery = query.select(root).where(predicates.toArray(new Predicate[]{}));
        TypedQuery<Users> scanDetailsTypedQuery = entityManager.createQuery(criteriaQuery);
        return scanDetailsTypedQuery.getSingleResult();
    }
}
