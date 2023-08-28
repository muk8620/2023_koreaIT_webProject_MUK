<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Chatting" />
<%@ include file="../common/header.jsp"%>

	<script>
		function isEmpty(form) {
			
			form.name.value = form.name.value.trim();
			
			if (!form.name.value) {
				alert('방 이름을 입력해주세요.');
				return;
			}
			
			form.submit();
		}
	</script>

	<section class="mt-8">
		<div class="container mx-auto">
			<div class="table-box-type-1">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="room" items="${rooms }" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td><a class="hover:underline" href="room/${room.id }">${room.name }</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${rq.getLoginedMemberId() != 0}">
					<form action="doCreate" class="mt-1 flex justify-end" onsubmit="isEmpty(this); return false;">
					    <input type="text" name="name" class="form-control">
					    <button class="btn btn-active btn-neutral">개설하기</button>
					</form>
				</c:if>	
			</div>
			
<!-- 			<div class="join mt-1 flex justify-center"> -->
<!-- 				<div> -->
<%-- 					<c:set var="pageMenuLen" value="10" /> --%>
<%-- 					<c:set var="startPage" value="${page - pageMenuLen >= 1 ? page - pageMenuLen : 1 }" /> --%>
<%-- 					<c:set var="endPage" value="${page + pageMenuLen <= pagesCnt ? page + pageMenuLen : pagesCnt }" /> --%>
					
<%-- 					<c:set var="pageBaseUri" value="?boardId=${board.id }&searchKeywordType=${searchKeywordType }&searchKeyword=${searchKeyword }" /> --%>
					
<%-- 					<c:if test="${page == 1 }"> --%>
<!-- 						<a class="join-item btn btn-disabled" >«</a> -->
<!-- 						<a class="join-item btn btn-disabled" >&lt;</a> -->
<%-- 					</c:if> --%>
<%-- 					<c:if test="${page > 1 }"> --%>
<%-- 						<a class="join-item btn" href="${pageBaseUri }&page=1">«</a> --%>
<%-- 						<a class="join-item btn" href="${pageBaseUri }&page=${page - 1}">&lt;</a> --%>
<%-- 					</c:if> --%>
<%-- 					<c:forEach begin="${startPage }" end="${endPage }" var="i"> --%>
<%-- 						<a class="join-item btn ${page == i ? 'btn-active' : '' }" href="${pageBaseUri }&page=${i }">${i }</a> --%>
<%-- 					</c:forEach> --%>
<%-- 					<c:if test="${page == pagesCnt }"> --%>
<!-- 						<a class="join-item btn btn-disabled" >&gt;</a> -->
<!-- 						<a class="join-item btn btn-disabled" >»</a> -->
<%-- 					</c:if> --%>
<%-- 					<c:if test="${page < pagesCnt }"> --%>
<%-- 						<a class="join-item btn" href="${pageBaseUri }&page=${page + 1}">&gt;</a> --%>
<%-- 						<a class="join-item btn" href="${pageBaseUri }&page=${pagesCnt }">»</a> --%>
<%-- 					</c:if> --%>
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
	</section>
<%@ include file="../common/footer.jsp"%>
