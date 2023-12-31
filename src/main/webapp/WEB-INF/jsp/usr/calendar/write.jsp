<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="일정" />
<%@ include file="../common/header.jsp" %>

	<script>
		$(document).ready(function(){
			function timeDisable(){
				if ($('input[name=allDay]').prop('checked')) {
					$('input[type=time]').addClass('hidden');
					return;
				}
				$('input[type=time]').removeClass('hidden');
			}
			
			$('input[name=allDay]').on('click', function(){
				timeDisable();
			})
			
			timeDisable();
		})
		
		function submitForm(form){
			form.title.value = form.title.value.trim();
		  
			if(form.title.value.length === 0){
			  alert('제목을 입력해주세요');
			  form.title.focus();
			  return;
		    }
			
			let start = form.querySelector('input[name=start]');
			let startTime = form.querySelector('input[name=startTime]');
			let end = form.querySelector('input[name=end]');
			let endTime = form.querySelector('input[name=endTime]');
			
			if (start.value > end.value) {
				alert('종료날짜가 시작날짜보다 빠릅니다.');
				end.focus();
				return;
			}
			
			if (!form.allDay.checked) {
				if (start.value === end.value) {
					if (startTime.value > endTime.value) {
						alert('종료시간이 시작시간보다 빠릅니다.');
						endTime.focus();
						return;
					}
				}
			}
			form.submit();
		}
			
	</script>

    <section class="mt-8">
		<div class="container mx-auto">
			<form action="doWrite" method="GET" onsubmit="submitForm(this); return false;">
				<div class="table-box-type-1">
					<table class="table">
						<colgroup>
							<col width="200" />
						</colgroup>
						<tbody>
							<tr>
								<th>제목</th>
								<td><input class="input input-bordered input-accent w-full" type="text" name="title" placeholder="제목을 입력해주세요." /></td>
							</tr>
							<tr>
								<th>일시</th>
								<td>
									<input class="input input-bordered input-accent" type="date" name="start" value="${date }"/>
									<input class="input input-bordered input-accent" type="time" name="startTime" value="${time }:00"/>
									&nbsp;-&nbsp;
									<input class="input input-bordered input-accent" type="date" name="end" value="${date }"/>
									<input class="input input-bordered input-accent" type="time" name="endTime" value="${time + 1}:00"/>
									&nbsp;
									<label>
										<input type="checkbox" name="allDay"/> 종일
									</label>
								</td>
							</tr>
							<tr>
								<td colspan="2"><button class="btn btn-active btn-neutral" >저장</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
			<div>
				<button class="btn btn-active btn-neutral" onclick="history.back();">뒤로가기</button>
<%-- 				<a class="btn btn-active btn-neutral" href="doDelete?id=${article.id}" onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;">삭제</a> --%>
			</div>
		</div>
	</section>
	
<%@ include file="../common/footer.jsp" %>