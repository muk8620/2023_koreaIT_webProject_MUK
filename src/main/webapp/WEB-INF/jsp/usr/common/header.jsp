<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html data-theme="light">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/resource/images/favicon.ico" />
<!-- 테일윈드 불러오기 -->
<!-- 노말라이즈, 라이브러리 -->
<link href="https://cdn.jsdelivr.net/npm/daisyui@3.6.1/dist/full.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.tailwindcss.com"></script>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- 폰트어썸 불러오기 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<!-- 내부CSS/JS 불러오기 -->
<link rel="stylesheet" href="/resource/common.css" 	/>	
<script src="/resource/common.js" defer="defer"></script>
<title>${pageTitle }</title>
</head>

<script>
	$(document).ready(function(){
		$('li > a.header')
			.filter(function(index, selector){
				return '${pageTitle}' === selector.textContent;
			})
			.addClass('active');
	})
</script>
<body>
	<div class="h-20 flex container mx-auto mt-4 text-3xl">
		<a class="px-3 flex items-center" href="/"><img class="inline-block" src="/resource/images/logo.png" width="100px" alt="❌" /> &nbsp;${pageTitle }</a>
		<div class="flex-grow"></div>
		<ul class="flex menu menu-horizontal bg-base-200">
			<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl header" href="/">HOME</a></li>
			<c:if test="${rq.getLoginedMemberId() == 0}">
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl header" href="/usr/member/join">회원가입</a></li>
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl header" href="/usr/member/login">로그인</a></li>
			</c:if>
			<c:if test="${rq.getLoginedMemberId() != 0}">
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl header" href="/usr/member/myPage">회원정보</a></li>
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl header" href="/usr/member/doLogout">로그아웃</a></li>
			</c:if>
<!-- 			<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl" href="/usr/api/APITest">API</a></li> -->
<!-- 			<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl" href="/usr/api/APITest2">API2</a></li> -->
		</ul>
	</div>
	
	<section class="my-3 text-2xl">
		<div class="container mx-auto px-3">
			<ul class="flex menu menu-horizontal bg-base-200">
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl header" href="/usr/calendar/list">일정</a></li>
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl header" href="/usr/chat/rooms">채팅</a></li>
<!-- 				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl" href="/usr/map/list">지도</a></li> -->
<!-- 				<li class="hover:underline"><a class="h-full px-3 flex items-center text-3xl" href="/usr/album/list">앨범</a></li> -->
			</ul>
		</div>
	</section>
	