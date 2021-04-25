package com.sbs.untact.dto;

import com.sbs.untactTeacher.util.Util;

public class Rq {
	   private member loginedMember;
	   private String currentUrl;

	    public Rq(member loginedMember, String currentUrl) {
	        this.loginedMember = loginedMember;
	        this.currentUrl = currentUrl;
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
	
	    public String getEncodedCurrentUrl() {
	        return Util.getUrlEncoded(getCurrentUrl());
	    }

	    private String getCurrentUrl() {
	        return currentUrl;
	    }
	    
	    public String getLoginPageUrl() {
	        return "../member/login?afterLoginUrl=" + getEncodedCurrentUrl();
	    }
}
