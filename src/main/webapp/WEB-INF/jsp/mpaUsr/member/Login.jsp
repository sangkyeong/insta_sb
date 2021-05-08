<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="../common/header.jspf"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>

<script>
let login__submitFormDone = false;
function login__submitForm(form) {
    if ( login__submitFormDone ) {
        return;
    }
    form.loginId.value = form.loginId.value.trim();
    if ( form.loginId.value.length == 0 ) {
        alert('아이디를 입력해주세요.');
        form.loginId.focus();
        return;
    }
    form.loginPwInput.value = form.loginPwInput.value.trim();
    if ( form.loginPwInput.value.length == 0 ) {
        alert('비밀번호를 입력해주세요.');
        form.loginPwInput.focus();
        return;
    }
    form.loginPw.value = sha256(form.loginPwInput.value);
    form.loginPwInput.value = '';
    
    form.submit();
    login__submitFormDone = true;
}
</script>
<div class="section section-login px-2">
	<div class="container mx-auto">
	<c:if test="${rq.isNotLogined()}">
	    <form method="POST" action="dologin" onsubmit="login__submitForm(this); return false;">
	    <input type="hidden" name="loginPw" />
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
                <input class="input input-bordered w-full" type="password" maxlength="100" name="loginPwInput" placeholder="비밀번호를 입력해주세요." />
            </div>

            <div class="mt-4 btn-wrap gap-1">
                <button type="submit" href="${param.afterLoginUrl}" class="btn btn-primary btn-sm mb-1">
                    <span><i class="fas fa-check"></i></span>
                    &nbsp;
                    <span>로그인</span>
              </button>

                <a href="#" title="초기화">
                <button type="reset">
                    <span><i class="fas fa-redo"></i></span>
                    &nbsp;
                    <span>초기화</span>
                </a>
                </button>
                
                <a href="../member/findLoginId" type="submit" href="#" class="btn btn-link btn-sm mb-1">
                    <span><i class="fas fa-sign-in-alt"></i></span>
                    &nbsp;
                    <span>아이디 찾기</span>
                </a>

                <a href="../member/findLoginPw" type="submit" href="#" class="btn btn-link btn-sm mb-1">
                    <span><i class="fas fa-sign-in-alt"></i></span>
                    &nbsp;
                    <span>비밀번호 찾기</span>
                </a>

                
            </div>
	    </form>
	    </c:if>

	    
	</div>
</div>

<%@ include file="../common/footer.jspf"%> 