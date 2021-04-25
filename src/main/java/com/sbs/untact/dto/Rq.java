package com.sbs.untact.dto;

public class Rq {
	   private member loginedMember;

	    public Rq(member loginedMember) {
	        this.loginedMember = loginedMember;
	    }

	    public boolean isLogined() {
	        return loginedMember != null;
	    }

	    public boolean isNotLogined() {
	        return isLogined() == false;
	    }

	    public int getLoginedMemberId() {
	        if (isNotLogined()) return 0;

	        return loginedMember.getId();
	    }

	    public member getLoginedMember() {
	        return loginedMember;
	    }

	    public String getLoginedMemberNickname() {
	        if (isNotLogined()) return "";

	        return loginedMember.getNickname();
	    }
	
}
