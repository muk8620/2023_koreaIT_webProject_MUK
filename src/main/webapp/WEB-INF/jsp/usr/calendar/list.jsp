@@ -0,0 +1,29 @@
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Calendar" />
<%@ include file="../common/header.jsp" %>
	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
	<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/google-calendar@6.1.8/index.global.min.js"></script>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
          , googleCalendarApiKey: '<api Key>'
          , events: {
		       	googleCalendarId: '<calenderId>'
		       	, className: 'gcal-event'
          }
        });
        calendar.render();
      });

    </script>

	<section class="mt-8">
    	<div id='calendar'></div>
	</section>
	
<%@ include file="../common/footer.jsp" %>