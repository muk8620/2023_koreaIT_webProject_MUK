package com.koreaIT.webProjectMuk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.koreaIT.webProjectMuk.dto.ChatMessageDTO;
import com.koreaIT.webProjectMuk.dto.ChatRoomDTO;

@Mapper
public interface ChatDao {

    @Select("""
			SELECT * FROM chatRoom
    		""")
    public List<ChatRoomDTO> getRooms();
    
    @Insert("""
    		INSERT INTO chatRoom
				SET regDate = NOW()
					, name = #{roomName}
					, creatorId = #{creatorId}
    		""")
    public void createChatRoom(String roomName, int creatorId);
    
    @Select("""
    		SELECT * 
    			FROM chatRoom	
    			WHERE id = #{id}
    		""")
    public ChatRoomDTO getRoomByRoomId(int id);
    
    @Select("""
    		SELECT regDate 
				FROM chatRoomParticipant
				WHERE chatRoomId = #{roomId}
				AND memberId = #{memberId};
    		""")
	public String getRegDateByRoomIdAndMemberId(int roomId, int memberId);
    
    @Insert("""
    		INSERT INTO chatRoomParticipant
				SET regDate = #{regDate}
					, chatRoomId = #{roomId}
					, memberId = #{memberId}
    		""")
	public void doIncreaseParticipant(String regDate, int roomId, int memberId);
    
    @Insert("""
    		INSERT INTO reply
				SET regDate = #{regDate}
					, updateDate = NOW()
					, memberId = #{memberId}
					, relTypeCode = 'chat'
					, relId = #{roomId}
					, `body` = #{body}
    		""")
	public int doInsertMessage(String regDate, int memberId, int roomId, String body);
    
    @Select("""
    		SELECT r.regDate 
					, r.body message
					, m.nickname writer
				FROM reply r
				INNER JOIN `member` m
				ON r.memberId = m.id
				WHERE r.relTypeCode = 'chat'
				AND r.relId = #{id}
				AND r.regDate >= STR_TO_DATE(#{userCheckRegDate}, '%Y-%m-%d %H:%i:%s')
    		""")
	public List<ChatMessageDTO> getMessagesByRegDate(int id, String userCheckRegDate);
    
    @Delete("""
    		DELETE FROM chatRoomParticipant  
				WHERE chatRoomId = #{roomId}
				AND memberId = #{memberId}
    		""")
	public void doDeleteParticipant(int roomId, int memberId);
    
}