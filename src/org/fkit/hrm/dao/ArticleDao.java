package org.fkit.hrm.dao;

import static org.fkit.hrm.util.common.HrmConstants.ARTICLETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.ArticleDynaSqlProvider;
import org.fkit.hrm.domain.Article;

/**
* @author Empirefree 胡宇乔:
* @version 创建时间：2019年1月28日 下午3:32:22
*/
public interface ArticleDao {
	// 根据id查询文章
	@Select("select * from "+ARTICLETABLE+" where ID = #{id}")
	Article selectById(Integer id);
	
	
	// 根据id删除文章
	@Delete(" delete from "+ARTICLETABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	
	// 根据用户id查询文章
	@Select("select * from "+ARTICLETABLE+" where user_id = #{user.id}")
	Article selectByUserId(Integer id);
	
	
	// 根据用户id删除文章
	@Delete(" delete from "+ARTICLETABLE+" where user_id = #{user.id} ")
	void deleteByUserId(Integer id);
	
		
	// 动态修改文章
	@SelectProvider(type=ArticleDynaSqlProvider.class,method="updateArticle")
	void update(Article article);
		
	// 动态查询
	@SelectProvider(type=ArticleDynaSqlProvider.class,method="selectWhitParam")
	List<Article> selectByPage(Map<String, Object> params);
	
	// 根据参数查询文章总数
	@SelectProvider(type=ArticleDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	// 动态插入文章
	@SelectProvider(type=ArticleDynaSqlProvider.class,method="insertArticle")
	void save(Article article);
	
}
