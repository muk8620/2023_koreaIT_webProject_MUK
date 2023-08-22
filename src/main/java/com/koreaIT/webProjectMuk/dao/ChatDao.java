package com.koreaIT.webProjectMuk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.koreaIT.webProjectMuk.dto.ChatRoomDTO;

@Mapper
public interface ChatDao {

    @Select("""
    		
    		""")
    public List<ChatRoomDTO> getRooms();
		/*
		 * //채팅방 생성 순서 최근 순으로 반환 List<ChatRoomDTO> result = new
		 * ArrayList<>(chatRoomDTOMap.values()); Collections.reverse(result);
		 * 
		 * return result;
		 */
    
    @Select("""
    		
    		""")
    public ChatRoomDTO getRoomById(String id);
//        return chatRoomDTOMap.get(id);

    @Insert("""
    		
    		""")
    public void createChatRoom(String name);
//        ChatRoomDTO room = ChatRoomDTO.create(name);
//        chatRoomDTOMap.put(room.getRoomId(), room);
//
//        return room;
}