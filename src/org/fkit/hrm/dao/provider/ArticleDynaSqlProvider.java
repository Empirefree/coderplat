package org.fkit.hrm.dao.provider;

import static org.fkit.hrm.util.common.HrmConstants.ARTICLETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Article;

/**
* @author Empirefree 胡宇乔:
* @version 创建时间：2019年1月28日 下午3:34:34
*/
public class ArticleDynaSqlProvider {
	// 分页动态查询
	//按照article的title和content查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(ARTICLETABLE);
				if(params.get("article") != null){
					Article article = (Article)params.get("article");
					if(article.getTitle() != null && !article.getTitle().equals("")){
						WHERE("title LIKE CONCAT ('%',#{article.title},'%') ");
					}
					if(article.getContent() != null && !article.getContent().equals("")){
						WHERE("content LIKE CONCAT ('%',#{article.content},'%') ");
					}
				}
			}
		}.toString();
		//实现分页效果
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(ARTICLETABLE);
				if(params.get("article") != null){
					Article article = (Article)params.get("article");
					if(article.getTitle() != null && !article.getTitle().equals("")){
						WHERE(" title LIKE CONCAT ('%',#{article.title},'%') ");
					}
					if(article.getContent() != null && !article.getContent().equals("")){
						WHERE(" content LIKE CONCAT ('%',#{article.content},'%') ");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertArticle(Article article){
		return new SQL(){
			{
				INSERT_INTO(ARTICLETABLE);
				if(article.getUser() != null && !article.getUser().getId().equals("")){
					VALUES("user_id", "#{user.id}");
				}
				if(article.getTitle() != null && !article.getTitle().equals("")){
					VALUES("title", "#{title}");
				}
				if(article.getContent() != null && !article.getContent().equals("")){
					VALUES("content", "#{content}");
				}
				if(article.getView_count() != null && !article.getView_count().equals("")){
					VALUES("view_count", "#{view_count}");
				}
				if(article.getComment_count() != null && !article.getComment_count().equals("")){
					VALUES("comment_count", "#{comment_count}");
				}
				if(article.getLike_count() != null && !article.getLike_count().equals("")){
					VALUES("like_count", "#{like_count}");
				}
				if(article.getIs_comment() != null && !article.getIs_comment().equals("")){
					VALUES("is_comment", "#{is_comment}");
				}
				if(article.getStatus() != null && !article.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(article.getOrder() != null && !article.getOrder().equals("")){
					VALUES("order", "#{order}");
				}
				if(article.getUpdate_time() != null && !article.getUpdate_time().equals("")){
					VALUES("update_time", "#{update_time}");
				}
				if(article.getCreate_time() != null && !article.getCreate_time().equals("")){
					VALUES("create_time", "#{create_time}");
				}
			}
		}.toString();
	}
	// 动态更新
		public String updateArticle(Article article){
			
			return new SQL(){
				{
					UPDATE(ARTICLETABLE);
					if(article.getTitle() != null){
						SET(" title = #{title} ");
					}
					if(article.getContent()!= null){
						SET(" content = #{content} ");
					}
					if(article.getIs_comment() != null){
						SET("is_comment", "#{is_comment}");
					}
					if(article.getStatus() != null){
						SET("status", "#{status}");
					}
					if(article.getUpdate_time() != null){
						SET("update_time", "#{update_time}");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
