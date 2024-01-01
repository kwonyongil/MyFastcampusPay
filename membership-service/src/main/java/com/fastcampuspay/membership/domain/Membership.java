package com.fastcampuspay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Membership {

	private final String membershipId;
	private final String name;
	private final String email;
	private final String address;
	private final boolean isValid;
	private final boolean isCorp;

	public static Membership generateMember(
		MembershipId membershipId,
		MembershipName name,
		MembershipEmail email,
		MembershipAddress address,
		MembershipIsValid isValid,
		MembershipIsCorp isCorp
	) {
		return new Membership(
			membershipId.membershipId,
			name.membershipName,
			email.membershipEmail,
			address.membershipAddress,
			isValid.isValidValue,
			isCorp.isCorpValue
		);
	}
	@Value
	public static class MembershipId {

		String membershipId;

		public MembershipId(String value) {
			this.membershipId = value;
		}
	}

	@Value
	public static class MembershipName {

		String membershipName;

		public MembershipName(String value) {
			this.membershipName = value;
		}
	}

	@Value
	public static class MembershipEmail {

		String membershipEmail;

		public MembershipEmail(String value) {
			this.membershipEmail = value;
		}
	}

	@Value
	public static class MembershipAddress {

		String membershipAddress;

		public MembershipAddress(String value) {
			this.membershipAddress = value;
		}
	}

	@Value
	public static class MembershipIsValid {

		boolean isValidValue;

		public MembershipIsValid(boolean value) {
			this.isValidValue = value;
		}
	}

	@Value
	public static class MembershipIsCorp {

		boolean isCorpValue;

		public MembershipIsCorp(boolean value) {
			this.isCorpValue = value;
		}
	}
}
