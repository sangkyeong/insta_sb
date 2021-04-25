<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pagetitle" value="<span><i class='far fa-clipboard'></i></span> <span>${board.name} 게시물 리스트 </span>"/>

<%@ include file="../common/header.jspf" %>

		<div class="total-items">
			<span>TOTAL ITEMS : </span>
			<span>${totalItemsCount}</span>
		</div>

		<div class="total-pages">
			<span>TOTAL PAGES : </span>
			<span>${totalPage}</span>
		</div>

		<div class="page">
			<span>CURRENT PAGE : </span>
			<span>${page}</span>
		</div>
		
		<div class="plain-link-wrap gap-3 mt-4">
            <a href="write?boardId=${board.id}" class="plain-link">
                <span><i class="fas fa-edit"></i></span>
                <span>글 작성</span>
            </a>
        </div>

		<hr />
		<hr />
	<c:if test="${articles == null || articles.size() == 0}">
				검색결과가 존재하지 않습니다.
			</c:if>
		<div class="articles">
			<c:forEach items="${articles}" var="article">
				<div>
					ID : ${article.id}<br>
					REG DATE : ${article.regDate}<br>
					UPDATE DATE : ${article.updateDate}<br>
					TITLE : ${article.title}<br>
					
					
				</div>
				<hr />
			</c:forEach>
			
			

		</div>
		
		<div class="pages" align="center" >
		
		<c:set var="pageMenuArmSize" value="4"	/>
			<c:set var="startPage" value="${page - pageMenuArmSize >= 1 ? page - pageMenuArmSize : 1}"	/>
			<c:set var="endPage" value="${page + pageMenuArmSize <= totalPage ? page + pageMenuArmSize : totalPage}"	/>
			
				<c:set var="url" value="?boardId=${board.id}" />
				<c:set var="url" value="${url}&searchKeywordType=${param.searchKeywordType}" />
				<c:set var="url" value="${url}&searchKeyword=${param.searchKeyword}" />
				
				<c:set var="aClassStr"	value="px-2 inline-block border border-gray-200 rounded text-lg hover:bg-gray-200" />
				
			<c:if test="${startPage > 1}">
			<a class="${aClassStr}" href="${url}&page=1">◀◀</a>
			<a class="${aClassStr}" href="${url}&page=${startPage - 1}">◀</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">

				
				<a class="${aClassStr} ${page == i ? 'text-red-500' : ''}" href="${url}&page=${i}">${i}</a>
				
				
			</c:forEach>
			

			
			<c:if test="${endPage < totalPage}">
			<a class="${aClassStr}" href="${url}&page=${endPage + 1}">▶</a>
			<a class="${aClassStr}" href="${url}&page=${totalPage}">▶▶</a>
			
			</c:if>
			
			
			
			
		</div>
		

	



<%@ include file="../common/footer.jspf" %>
