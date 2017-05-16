package app.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.ConfigManager;

/**
 * @author user1
 *	MyBatis란?
 * 개발자가 데이터베이스 연동 프로그램 작성시
 * jdbc의 상투적 코드를 작성하지 않아도 되는, SQL매퍼이다.
 * Mybatis를 이용하면, 개발자는 쿼리문에 집중할 수 있으므로, 개발의 효율성이 높아진다.
 */
public class EmpDAO {
	ConfigManager manager=ConfigManager.getInstance();
	//jdbc 상투적 코드
	/*public List<Emp> select() {
		
		
	}*/	
	
	public List select(){		
		List list=null;
		SqlSession session=manager.getSession();
		/*list=session.selectList("app.emp.Emp.selectAll"); config에서 allias설정하면 짧게  namaspace설정할 수 있다.*/
		//list=session.selectList("Emp.selectAll");
		list=session.selectList("Emp.empDeptJoin");
		manager.close(session);
		return list;
	}
	
	//레코드 한건 가져오기
	public Emp select(int empno) {
		Emp emp=null;
		SqlSession session=manager.getSession();
		emp=session.selectOne("Emp.select", empno );
		manager.close(session);
		return emp;
	}
	
	
	
	
	
}




