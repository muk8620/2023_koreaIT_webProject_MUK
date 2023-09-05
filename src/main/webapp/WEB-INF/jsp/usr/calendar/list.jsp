<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Calendar" />
<%@ include file="../common/header.jsp" %>
<!-- 	fullcalendar 불러오기 -->
	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script> 
<!-- 	fullcalendar 언어(한국어)설정 -->
	<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/core@6.1.8/locales/ko.global.min.js'></script>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
        let calendarEl = document.getElementById('calendar');
        let calendar = new FullCalendar.Calendar(calendarEl, {
            headerToolbar: {	
              left: 'prev,next today',
              center: 'title',
              right: 'multiMonthYear,dayGridMonth,timeGridWeek,timeGridDay,listMonth'
            },
            locale: 'ko',
            buttonText: {
            	year: '연',
            	list: '목록'
            },
            navLinks: true, // can click day/week names to navigate views
            navLinkDayClick: function(date, jsEvent) {
                console.log('day', date.toISOString());
                console.log('coords', jsEvent.pageX, jsEvent.pageY);
            },
            editable: true, 
            selectable: true,
            selectMirror: true,	
            dayMaxEvents: true, // allow "more" link when too many events
            select: function(arg) {
            	location.href = 'write?date=' + arg.startStr;
            },
            eventClick: function(arg) {
              if (confirm('이 이벤트를 수정하시겠습니까?')) {
            	location.href = 'modify?id=' + arg.event.id;
              }
            },
            events: function(info, successCallback, failureCallback){
          	  // ajax 처리로 데이터를 로딩 시킨다.
          	  $.ajax({
          		 type:"get",
          		 url:"getCalendarList",
          		 dataType:"json",
	          	 success: function(data){
	          		successCallback(data);
	             },
	             error: function(){
	               alert("캘린더를 불러오지 못했습니다.");
	             }	
          	  })
            }
		});
        
        calendar.render();
//         $('div').on('click', function(){
// 	      	console.log(calendar.getEventById(3));
//         })
        
      });

     </script>
     <style>

       body {
         margin: 40px 10px;
         padding: 0;
       }

       #calendar {
         max-width: 1100px;
         margin: 0 auto;
       }

     </style>

	<section class="mt-8">
    	<div id='calendar'></div>
	</section>
	
<%@ include file="../common/footer.jsp" %>