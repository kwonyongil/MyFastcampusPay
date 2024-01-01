package com.fastcampuspay.membership.adapter.out.persistence.jpa.repository;

import com.fastcampuspay.membership.adapter.out.persistence.jpa.entity.MembershipJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {

}
