package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.adapter.out.persistence.jpa.entity.MembershipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.jpa.repository.SpringDataMembershipRepository;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import com.fastcampuspay.membership.domain.Membership.MembershipId;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

	private final SpringDataMembershipRepository membershipRepository;

	@Override
	public MembershipJpaEntity create(
		Membership.MembershipName membershipName,
		Membership.MembershipEmail membershipEmail,
		Membership.MembershipAddress membershipAddress,
		Membership.MembershipIsValid membershipIsValid,
		Membership.MembershipIsCorp membershipIsCorp
	) {
		return membershipRepository.save(
			new MembershipJpaEntity(
				membershipName.getMembershipName(),
				membershipEmail.getMembershipEmail(),
				membershipAddress.getMembershipAddress(),
				membershipIsValid.isValidValue(),
				membershipIsCorp.isCorpValue()
			)
		);
	}

	@Override
	public MembershipJpaEntity find(MembershipId membershipId) {
		return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
	}
}
