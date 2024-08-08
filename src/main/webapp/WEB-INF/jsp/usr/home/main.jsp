<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Main" />
<%@ include file="../common/header.jsp" %>
	
	<section class="mt-8">
		<div class="container mx-auto">
			<div class="card w-96 glass">
				<div class="card-body">
			  		<h2 class="card-title">소통 자국</h2>
<!-- 			    	<p>How to park your car at your garage?</p> -->
			    	<div class="card-actions justify-end">
			    		<c:if test="${rq.getLoginedMemberId() == 0}">
				    		<a class="btn btn-primary" href="/usr/member/login">로그인</a>
			    		</c:if>
			    		<c:if test="${rq.getLoginedMemberId() != 0}">
				    		<a class="btn btn-primary" href="/usr/member/doLogout">로그아웃</a>
			    		</c:if>
			    	</div>
			    </div>
			</div>
<!-- 			<div> -->
<!-- 				<span class="modal-exam">모달예시</span> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<span class="popUp-exam">팝업예시</span> -->
<!-- 			</div> -->
			
<!-- 			<div class="layer-bg"></div> -->
<!-- 			<div class="layer"> -->
<!-- 				<h1>MODAL</h1> -->
<!-- 				<span class="close-x-btn">&times;</span> -->
<!-- 				<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis culpa nobis reprehenderit quam veritatis tenetur ex possimus aliquam officia at iste odio impedit ipsum dicta eaque harum maxime voluptatibus hic.</div> -->
<!-- 				<button id="closeBtn" class="btn btn-accent btn-sm">CLOSE</button> -->
<!-- 			</div> -->
		</div>
	</section>

<%@ include file="../common/footer.jsp" %>