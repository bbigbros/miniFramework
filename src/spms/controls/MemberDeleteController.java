package spms.controls;

import java.util.Map;

import spms.dao.MySqlMemberDao;

public class MemberDeleteController implements Controller {
	MySqlMemberDao memberDao;
	
	public MemberDeleteController setMemberDao(MySqlMemberDao memberDao) {
		System.out.println("setMemberDao in MemberDeleteController()");
		this.memberDao = memberDao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[]{ "no", Integer.class };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int no = (Integer)model.get("no");
		memberDao.delete(no);
		
		return "redirect:list.do";
	}
}
