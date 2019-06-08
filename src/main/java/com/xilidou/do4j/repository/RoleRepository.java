package com.xilidou.do4j.repository;

import com.xilidou.do4j.entity.RoleEntity;
import com.xilidou.do4j.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

	Optional<RoleEntity> findByName(RoleName name);
}
