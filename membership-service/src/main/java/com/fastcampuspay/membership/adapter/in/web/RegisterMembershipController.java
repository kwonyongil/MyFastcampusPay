package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.adapter.in.web.request.dto.RegisterMembershipRequest;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.in.command.RegisterMembershipCommand;
import com.fastcampuspay.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

	private final RegisterMembershipUseCase registerMembershipUseCase;

	@PostMapping(path= "/membership/register")
	Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
		RegisterMembershipCommand command = RegisterMembershipCommand.builder()
			.name(request.getName())
			.email(request.getEmail())
			.address(request.getAddress())
			.isCorp(request.isCorp())
			.isValid(true)
			.build();

		return registerMembershipUseCase.register(command);
	}
}
