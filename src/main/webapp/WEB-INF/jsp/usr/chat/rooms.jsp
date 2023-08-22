<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Chatting" />
<%@ include file="../common/header.jsp"%>

	<script>
		$(document).ready(function(){
		
		    let roomName = `${roomName}`;
		
		    if(roomName != null)
		        alert(roomName + "방이 개설되었습니다.");
		
		    $(".btn-create").on("click", function (e){
		        e.preventDefault();
		
		        let name = $("input[name='name']").val();
		
		        if(name == "")
		            alert("Please write the name.")
		        else
		            $("form").submit();
		    });
		});
	</script>

<div class="container">
    <div>
        <ul>
        	<c:forEach var="room" items="${rooms }">
	            <li><a href="/chat/room?roomId=${room.roomId}">${room.name }</a></li>
        	</c:forEach>
        </ul>
    </div>
</div>
<form action="/chat/room" method="post">
    <input type="text" name="name" class="form-control">
    <button class="btn btn-secondary">개설하기</button>
</form>
<%@ include file="../common/footer.jsp"%>
