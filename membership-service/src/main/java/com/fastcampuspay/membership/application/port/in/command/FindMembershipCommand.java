package com.fastcampuspay.membership.application.port.in.command;

import common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

	private final String membershipId;
}
