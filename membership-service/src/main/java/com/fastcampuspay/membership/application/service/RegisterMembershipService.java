package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.adapter.out.persistence.jpa.entity.MembershipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.jpa.mapper.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.in.command.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import com.fastcampuspay.membership.domain.Membership.MembershipAddress;
import com.fastcampuspay.membership.domain.Membership.MembershipEmail;
import com.fastcampuspay.membership.domain.Membership.MembershipIsCorp;
import com.fastcampuspay.membership.domain.Membership.MembershipIsValid;
import com.fastcampuspay.membership.domain.Membership.MembershipName;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RegisterMembershipService implements RegisterMembershipUseCase {

	private final RegisterMembershipPort registerMembershipPort;
	private final MembershipMapper membershipMapper;

	@Override
	public Membership register(RegisterMembershipCommand command) {

		MembershipJpaEntity jpaEntity = registerMembershipPort.create(
			new MembershipName(command.getName()),
			new MembershipEmail(command.getEmail()),
			new MembershipAddress(command.getAddress()),
			new MembershipIsValid(command.isValid()),
			new MembershipIsCorp(command.isCorp())
		);

		return membershipMapper.mapToDomainEntity(jpaEntity);
	}
}
