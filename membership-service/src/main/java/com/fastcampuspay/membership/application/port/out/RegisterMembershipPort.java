package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.jpa.entity.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership;

public interface RegisterMembershipPort {

	MembershipJpaEntity create(
		Membership.MembershipName membershipName,
		Membership.MembershipEmail membershipEmail,
		Membership.MembershipAddress membershipAddress,
		Membership.MembershipIsValid membershipIsValid,
		Membership.MembershipIsCorp membershipIsCorp
	);
}
