package com.sbs.untact.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public @AllArgsConstructor
@Data
class member {
	private int id;
	private String regDate;
	private boolean blindStatus;
    private String blindDate;
    private boolean delStatus;
    private String loginId;
    private String loginPw;
    private String name;
    private String nickname;
    private String email;
    private String cellphoneNo;
} 