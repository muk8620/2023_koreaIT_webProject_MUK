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
            initialDate: '2023-01-12',
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
            events: $.get('../reactionPoint/getReactionPoint', {
				relTypeCode : 'article',
				relId : ${article.id}
			}, function(data){
				
				console.log(data);
				
				console.log($('#goodBtn').attr('href'));
				console.log($('#badBtn').prop('href'));
				
				if (data.data1.sumReactionPoint == 1) {
					let goodBtn = $('#goodBtn');
					goodBtn.removeClass('btn-outline');
					goodBtn.attr('href', '../reactionPoint/doDeleteReactionPoint?relTypeCode=article&relId=${article.id }&point=1');
				} else if (data.data1.sumReactionPoint == -1) {
					let badBtn = $('#badBtn');
					badBtn.removeClass('btn-outline');
					badBtn.attr('href', '../reactionPoint/doDeleteReactionPoint?relTypeCode=article&relId=${article.id }&point=-1');
				}
				
			}, 'json')
			
		}
		
		$(function(){
			getReactionPoint();
		})
            	
            	[
              {
                title: 'All Day Event',
                start: '2023-01-01',
                display: 'background'
              },
              {
                title: 'Long Event',
                start: '2023-01-07',
                end: '2023-01-10'
              },
              {
                groupId: 999,
                title: 'Repeating Event',
                start: '2023-01-09T16:00:00'
              },
              {
                groupId: 999,
                title: 'Repeating Event',
                start: '2023-01-16T16:00:00'
              },
              {
                title: 'Conference',
                start: '2023-01-11',
                end: '2023-01-13'
              },
              {
                title: 'Meeting',
                start: '2023-01-12T10:30:00',
                end: '2023-01-12T12:30:00'
              },
              {
                title: 'Lunch',
                start: '2023-01-12T12:00:00'
              },
              {
                title: 'Meeting',
                start: '2023-01-12T14:30:00'
              },
              {
                title: 'Happy Hour',
                start: '2023-01-12T17:30:00'
              },
              {
                title: 'Dinner',
                start: '2023-01-12T20:00:00'
              },
              {
                title: 'Birthday Party',
                start: '2023-01-13T07:00:00'
              },
              {
                title: 'Click for Google',
                url: 'http://google.com/',
                start: '2023-01-28'
              }
            ]
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