package com.oauth2.oauth2api.repositories;

import com.oauth2.oauth2api.domains.SecurityRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRoleRepository extends JpaRepository<SecurityRole, Long> {
}
