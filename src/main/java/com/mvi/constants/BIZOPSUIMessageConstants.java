package com.mvi.constants;

public final class BIZOPSUIMessageConstants {

	public static final String BILLING_ORGANIZATION_MAKER_SUCCESS_MSG;
	public static final String BILLING_ORGANIZATION_DETAILS_ACTIVE_REQUEST_SUBMITTED_SUCCESSFULLY_MSG;
	public static final String BILLING_ORGANIZATION_CHECKER_SUCCESS_MSG;
	public static final String BILLING_ORGANIZATION_CHECKER_REJECT_MSG;
	
	

	static {
		BILLING_ORGANIZATION_MAKER_SUCCESS_MSG = "Create Billing Organization - Billing Organization Request Submitted Successfully";
		BILLING_ORGANIZATION_CHECKER_SUCCESS_MSG = "Review Billing Organization - APPROVE Request Submitted Successfully";
		BILLING_ORGANIZATION_DETAILS_ACTIVE_REQUEST_SUBMITTED_SUCCESSFULLY_MSG = "Billing Organization Details- ACTIVE Request Submitted Successfully";
		BILLING_ORGANIZATION_CHECKER_REJECT_MSG ="Review Billing Organization - REJECT Request Submitted Successfully";
	}
}
