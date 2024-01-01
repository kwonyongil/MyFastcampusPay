package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.application.port.in.command.RegisterMembershipCommand;
import com.fastcampuspay.membership.domain.Membership;

public interface RegisterMembershipUseCase {

	Membership register(RegisterMembershipCommand command);
}
