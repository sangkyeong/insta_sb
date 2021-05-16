package com.sbs.untact.dto;

import java.util.Map;

import com.sbs.untactTeacher.util.Util;

import lombok.Getter;

public class Rq {
	   private member loginedMember;
	   private String currentUrl;
	   @Getter
	   private Map<String, String> paramMap;
	   private String currentUri;

	    public Rq(member loginedMember, String currentUrl, Map<String, String> paramMap) {
	        this.loginedMember = loginedMember;
	        this.currentUrl = currentUrl;
	        this.paramMap = paramMap;
	        this.currentUri = currentUrl.split("\\?")[0];
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
	
	    public String getEncodedCurrentUrl() {
	        return Util.getUrlEncoded(getCurrentUrl());
	    }

	    public String getCurrentUrl() {
	        return currentUrl;
	    }
	    
	    public String getLoginPageUrl() {
	    	 String afterLoginUrl;

	         if (isLoginPage()) {
	             afterLoginUrl = Util.getUriEncoded(paramMap.get("afterLoginUrl"));
	         } else {
	             afterLoginUrl = getEncodedCurrentUrl();
	         }

	         return "../member/Login?afterLoginUrl=" + afterLoginUrl;
	     }

	     private boolean isLoginPage() {
	         return currentUrl.equals("/mpaUsr/member/Login");
	     }
	    
}
