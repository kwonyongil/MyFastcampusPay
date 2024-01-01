package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.adapter.out.persistence.jpa.entity.MembershipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.jpa.mapper.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.FindMembershipUseCase;
import com.fastcampuspay.membership.application.port.in.command.FindMembershipCommand;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class FindMembershipService implements FindMembershipUseCase {

	private final FindMembershipPort findMembershipPort;
	private final MembershipMapper membershipMapper;

	@Override
	public Membership find(FindMembershipCommand command) {
		MembershipJpaEntity membershipJpaEntity = findMembershipPort.find(new Membership.MembershipId(command.getMembershipId()));
		return membershipMapper.mapToDomainEntity(membershipJpaEntity);
	}
}
