<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="../common/header.jspf"%>
<div class="section section-article-list">
	<div class="container mx-auto">
	    <form method="POST" action="main" >
	    
	        <div class="form-control">
                <label class="label">
                    아이디
                </label>
                <a class="label" >
                	<span>${loginId}</span>
                </a>
            
            </div>
            
            <div class="form-control">
                <label class="label">
                    이름
                </label>
                <a class="label" >
                	<span>${name}</span>
                </a>
            </div>
            
            <div class="form-control">
                <label class="label">
                    닉네임
                </label>
                <a class="label" >
                	<span>${nickname}</span>
                </a>
            </div>
            
            <div class="form-control">
                <label class="label">
                    이메일
                </label>
                <a class="label" >
                	<span>${email}</span>
                </a>
            </div>
            
            <div class="form-control">
                <label class="label">
                    휴대폰번호
                </label>
                <a class="label" >
                	<span>${cellphoneNo}</span>
                </a>
            </div>
            
            
            <div class="mt-4 btn-wrap gap-1">
            
                <button type="submit" href="../mpaUsr/home/main" class="btn btn-primary btn-sm mb-1">
                    <span><i class="fas fa-check"></i></span>
                    &nbsp;
                    <span>확인</span>
              </button>

            </div>
            
	    </form>
	</div>
</div>

<%@ include file="../common/footer.jspf"%> 