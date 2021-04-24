<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="../common/header.jspf"%>
<script>
let join__submitFormDone = false;
function join__submitForm(form) {
    if ( join__submitFormDone ) {
        return;
    }
    form.loginId.value = form.loginId.value.trim();
    if ( form.loginId.value.length == 0 ) {
        alert('아이디를 입력해주세요.');
        form.loginId.focus();
        return;
    }
    form.loginPw.value = form.loginPw.value.trim();
    if ( form.loginPw.value.length == 0 ) {
        alert('비밀번호를 입력해주세요.');
        form.loginPw.focus();
        return;
    }
    form.name.value = form.name.value.trim();
    if ( form.name.value.length == 0 ) {
        alert('이름을 입력해주세요.');
        form.name.focus();
        return;
    }
    form.nickname.value = form.nickname.value.trim();
    if ( form.nickname.value.length == 0 ) {
        alert('닉네임을 입력해주세요.');
        form.nickname.focus();
        return;
    }
    form.email.value = form.email.value.trim();
    if ( form.email.value.length == 0 ) {
        alert('이메일을 입력해주세요.');
        form.email.focus();
        return;
    }
    form.cellphoneNo.value = form.cellphoneNo.value.trim();
    if ( form.cellphoneNo.value.length == 0 ) {
        alert('휴대폰번호를 입력해주세요.');
        form.cellphoneNo.focus();
        return;
    }
    form.submit();
    join__submitFormDone = true;
}
</script>
<div class="section section-article-list">
	<div class="container mx-auto">
	    <form method="POST" action="dojoin" onsubmit="join__submitForm(this); return false;">
	    
	        <div class="form-control">
                <label class="label">
                    아이디
                </label>
                <input class="input input-bordered w-full" type="text" maxlength="100" name="loginId" placeholder="아이디를 입력해주세요." />
            </div>

            <div class="form-control">
                <label class="label">
                    비밀번호
                </label>
                <input class="input input-bordered w-full" type="password" maxlength="100" name="loginPw" placeholder="비밀번호를 입력해주세요." />
            </div>
            
            <div class="form-control">
                <label class="label">
                    이름
                </label>
                <input class="input input-bordered w-full" type="text" maxlength="100" name="name" placeholder="이름을 입력해주세요." />
            </div>
            
            <div class="form-control">
                <label class="label">
                    닉네임
                </label>
                <input class="input input-bordered w-full" type="text" maxlength="100" name="nickname" placeholder="닉네임을 입력해주세요." />
            </div>
            
            <div class="form-control">
                <label class="label">
                    이메일
                </label>
                <input class="input input-bordered w-full" type="email" maxlength="100" name="email" placeholder="이메일을 입력해주세요." />
            </div>
            
            <div class="form-control">
                <label class="label">
                    휴대폰번호
                </label>
                <input class="input input-bordered w-full" type="tel" maxlength="100" name="cellphoneNo" placeholder="휴대폰번호를 입력해주세요." />
            </div>
            
            
            <div class="mt-4 btn-wrap gap-1">
                <button type="submit" href="#" class="btn btn-primary btn-sm mb-1">
                    <span><i class="fas fa-check"></i></span>
                    &nbsp;
                    <span>가입</span>
              </button>

                <a href="#" title="초기화">
                <button type="reset">
                    <span><i class="fas fa-redo"></i></span>
                    &nbsp;
                    <span>초기화</span>
                </a>
                </button>
            </div>
	    </form>
	</div>
</div>

<%@ include file="../common/footer.jspf"%> 