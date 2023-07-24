package com.koreaIT.webProjectMuk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.webProjectMuk.vo.Article;
import com.koreaIT.webProjectMuk.vo.ResultData;

@Mapper
public interface ArticleDao {
	
	public void writeArticle(int loginedMemberId, int boardId, String title, String body);
	
	public Article getArticleById(int id);
	
	public void modifyArticle(int id, String title, String body);

	public void deleteArticle(int id); 
	
	public List<Article> getArticles(int boardId, int limitStart, int itemsInAPage, String searchKeywordType, String searchKeyword);

	public int getLastInsertId();

	public Article getForPrintArticle(int id);

	public int getArticlesCnt(int boardId, String searchKeyword, String searchKeywordType);

	public int increaseHitCnt(int id);
	
}
