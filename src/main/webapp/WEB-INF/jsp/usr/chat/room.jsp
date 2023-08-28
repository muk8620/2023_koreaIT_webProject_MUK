<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Chatting" />
<%@ include file="../common/header.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.6.1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

	<script>
		$(document).ready(function(){
		
		    let roomName = '${room.name}';
		    let roomId = '${room.id}';
		    let username = '${loginedMember.nickname}';
		
		    console.log(roomName + ", " + roomId + ", " + username);
		
		    let sockJs = new SockJS("/chatting");
		    //1. SockJS를 내부에 들고있는 stomp를 내어줌
		    let stomp = Stomp.over(sockJs);
			
		    //2. connection이 맺어지면 실행
		    stomp.connect({}, function (){
		       console.log("STOMP Connection")
		
		       //4. subscribe(path, callback)으로 메세지를 받을 수 있음
		       
		       function showMessage(content) {
	        	   let writer = content.writer;
		           let message = content.message;
		           let str = '';
		           
		           if(writer === username){
		               str = "<div class='col-6'>";
		               str += "<div class='alert alert-secondary'>";
		               str += "<b>" + writer + " : " + message + "</b>";
		               str += "</div></div>";
		               $("#msgArea").append(str);
		           } else{
		               str = "<div class='col-6'>";
		               str += "<div class='alert alert-warning'>";
		               str += "<b>" + writer + " : " + message + "</b>";
		               str += "</div></div>";
		               $("#msgArea").append(str);
		           }
		       }
		       
		       stomp.subscribe("/sub/usr/chat/room?id=" + roomId, function (chat) {
		           let contents = JSON.parse(chat.body);
		           
		           if (Array.isArray(contents)) {
		        	   contents.forEach(element => {
		        	   		showMessage(element);
		        	   });
		           } else {
		        	   showMessage(contents);
		           }
		       });
		
		       //3. send(path, header, message)로 메세지를 보낼 수 있음
		       stomp.send('/pub/chat/enter', {}, JSON.stringify({roomId: roomId, memberId:${loginedMember.id}, writer: username}))
		    });
		    
	        stomp.send('/pub/chat/messageList', {}, JSON.stringify({roomId: roomId}))
	        
		    function sendMessage() {
		    	let msg = $('#msg');
		    	
		    	if (msg.val().trim() === '') {
		    		return;
		    	}
		    	
		        console.log(username + ":" + msg.val());
		        stomp.send('/pub/chat/message', {}, JSON.stringify({roomId: roomId, memberId:${loginedMember.id}, message: msg.val(), writer: username}));
		        msg.val('');
		    }
		
		    $("#button-send").on("click", function(e){
		        sendMessage();
		    });
		    
		    $(document).on("keydown", function(e){
		    	if (e.keyCode === 13) {
		    		sendMessage();
		    	}
		    })
		});	
	</script>

	<div class="container">
	    <div class="col-6">
	        <h1>${room.name }</h1>
	    </div>
	    <div>
	        <div id="msgArea" class="col"></div>
	        <div class="col-6">
	            <div class="input-group mb-3">
	                <input type="text" id="msg" class="form-control">
	                <div class="input-group-append">
	                    <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="col-6"></div>
	</div>
<%@ include file="../common/footer.jsp"%>
