package org.fkit.hrm.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.User;
import static org.fkit.hrm.util.common.HrmConstants.USERTABLE;

public class UserDynaSqlProvider {
	// 分页动态查询
	//按照user的nickname和status查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getNickname() != null && !user.getNickname().equals("")){
						WHERE("nickname LIKE CONCAT ('%',#{user.nickname},'%') ");
					}
					if(user.getStatus() != null && !user.getStatus().equals("")){
						WHERE("status LIKE CONCAT ('%',#{user.status},'%') ");
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
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getNickname() != null && !user.getNickname().equals("")){
						WHERE(" nickname LIKE CONCAT ('%',#{user.nickname},'%') ");
					}
					if(user.getStatus() != null && !user.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertUser(User user){
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getLoginname() != null && !user.getLoginname().equals("")){
					VALUES("loginname", "#{loginname}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
				if(user.getNickname() != null && !user.getNickname().equals("")){
					VALUES("nickname", "#{nickname}");
				}
				if(user.getEamil() != null && !user.getEamil().equals("")){
					VALUES("email", "#{email}");
				}
				if(user.getUrl() != null && !user.getUrl().equals("")){
					VALUES("url", "#{url}");
				}
				
				if(user.getAvatar() != null && !user.getAvatar().equals("")){
					VALUES("avatar", "#{avatar}");
				}
				if(user.getLast_login_ip() != null && !user.getLast_login_ip().equals("")){
					VALUES("last_login_ip", "#{last_login_ip}");
				}
				if(user.getRegister_time() != null && !user.getRegister_time().equals("")){
					VALUES("register_time", "#{register_time}");
				}
				if(user.getLast_login_time() != null && !user.getLast_login_time().equals("")){
					VALUES("last_login_time", "#{last_login_time}");
				}
				if(user.getStatus() != null && !user.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
			}
		}.toString();
	}
	// 动态更新
		public String updateUser(User user){
			
			return new SQL(){
				{
					UPDATE(USERTABLE);
					if(user.getLoginname() != null){
						SET(" loginname = #{loginname} ");
					}
					if(user.getPassword()!= null){
						SET(" password = #{password} ");
					}
					if(user.getNickname() != null){
						SET(" nickname = #{nickname} ");
					}
					if(user.getEamil() != null){
						SET("email", "#{email}");
					}
					if(user.getUrl() != null){
						SET("url", "#{url}");
					}
					
					if(user.getAvatar() != null){
						SET("avatar", "#{avatar}");
					}
					if(user.getLast_login_ip() != null){
						SET("last_login_ip", "#{last_login_ip}");
					}
					if(user.getRegister_time() != null){
						SET("register_time", "#{register_time}");
					}
					if(user.getLast_login_time() != null){
						SET("last_login_time", "#{last_login_time}");
					}
					if(user.getStatus()!= null){
						SET(" status = #{status} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
