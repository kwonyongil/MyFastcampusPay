package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.application.port.in.command.FindMembershipCommand;
import com.fastcampuspay.membership.domain.Membership;

public interface FindMembershipUseCase {
	Membership find(FindMembershipCommand command);

}
