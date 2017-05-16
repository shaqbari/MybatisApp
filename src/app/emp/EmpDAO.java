package app.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.ConfigManager;

/**
 * @author user1
 *	MyBatis��?
 * �����ڰ� �����ͺ��̽� ���� ���α׷� �ۼ���
 * jdbc�� ������ �ڵ带 �ۼ����� �ʾƵ� �Ǵ�, SQL�����̴�.
 * Mybatis�� �̿��ϸ�, �����ڴ� �������� ������ �� �����Ƿ�, ������ ȿ������ ��������.
 */
public class EmpDAO {
	ConfigManager manager=ConfigManager.getInstance();
	//jdbc ������ �ڵ�
	/*public List<Emp> select() {
		
		
	}*/	
	
	public List select(){		
		List list=null;
		SqlSession session=manager.getSession();
		/*list=session.selectList("app.emp.Emp.selectAll"); config���� allias�����ϸ� ª��  namaspace������ �� �ִ�.*/
		//list=session.selectList("Emp.selectAll");
		list=session.selectList("Emp.empDeptJoin");
		manager.close(session);
		return list;
	}
	
	//���ڵ� �Ѱ� ��������
	public Emp select(int empno) {
		Emp emp=null;
		SqlSession session=manager.getSession();
		emp=session.selectOne("Emp.select", empno );
		manager.close(session);
		return emp;
	}
	
	
	
	
	
}




