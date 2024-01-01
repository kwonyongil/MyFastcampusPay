package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.jpa.entity.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership;

public interface FindMembershipPort {

	MembershipJpaEntity find(Membership.MembershipId membershipId);
}
