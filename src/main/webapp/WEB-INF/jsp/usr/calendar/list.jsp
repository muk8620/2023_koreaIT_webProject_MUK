<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Calendar" />
<%@ include file="../common/header.jsp" %>
	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            headerToolbar: {
              left: 'prev,next today',
              center: 'title',
              right: 'multiMonthYear,dayGridMonth,timeGridWeek,timeGridDay,list'
            },
            initialDate: '2021-05-12',
            locale: 'ko',
            navLinks: true, // can click day/week names to navigate views
            editable: true,
            selectable: true,
            selectMirror: true,	
            dayMaxEvents: true, // allow "more" link when too many events
            select: function(arg) {
              var title = prompt('Event Title:');
              if (title) {
                calendar.addEvent({
                  title: title,
                  start: arg.start,
                  end: arg.end,
                  allDay: arg.allDay
                })
              }
              calendar.unselect()
            },
            eventClick: function(arg) {
              if (confirm('Are you sure you want to delete this event?')) {
                arg.event.remove()
              }
            },
            events: function(info, successCallback, failureCallback){
          	  // ajax 처리로 데이터를 로딩 시킨다.
          	  $.ajax({
          		 type:"get",
          		 url:"getCalendarList",
          		 dataType:"json",  
	          	 success: function(data){
	          		 console.log(data);
	          		successCallback(data);
	             },
	             error: function(){
	               alert("simpleWithObject err");
	             }
          	  })
            }
		});
        calendar.render();
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