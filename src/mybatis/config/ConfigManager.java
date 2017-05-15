package mybatis.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import app.emp.Emp;

/**
 * @author user1 config.xml�� �о�鿩 � dbms�� ����� �������� �����Ѵ�. db�� ���� �۾��� ����ϴ� ��ü��
 *         SqlSession��ü�� ��ȯ���ִ� SqlSessionFactory�� ��������.
 *
 *         �ѹ��� �о ��� DAO���� �̿��� �� �ְ� singleton���� ������.
 */
public class ConfigManager {
	private static ConfigManager instance;
	SqlSessionFactory factory;

	private ConfigManager() {
		// ��Ű���� ����ִ� ������ Ŭ������ �ƴ�, �Ϲ������� ���
		// ��Ʈ�� �ƴ� �׳� /�� �����ؾ� �Ѵ�.
		String resource = "mybatis/config/config.xml";
		InputStream inputStream = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// jdbc�������� �������� �����ϱ� ���� preparedStatement��ü�� �����ؾ� �ߴ�
		// ������ mybatis�� �̿��ϸ� ���� SqlSession�̶�� ��ü�� ����ϸ� �ȴ�.
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();

		}

		return instance;
	}

	// dao���� ���� SqlSession�� ��ȯ�� �δ� �޼ҵ� ����
	public SqlSession getSession() {
		SqlSession session = null;
		session = factory.openSession();
		return session;
	}

	// �ٻ���� ���� ��ȯ
	public void close(SqlSession session) {
		session.close();
	}

	/*
	 * public static void main(String[] args) { //��Ű���� ����ִ� ������ Ŭ������ �ƴ�, �Ϲ�������
	 * ��� //��Ʈ�� �ƴ� �׳� /�� �����ؾ� �Ѵ�. String resource = "mybatis/config/config.xml";
	 * InputStream inputStream = null;
	 * 
	 * try { inputStream = Resources.getResourceAsStream(resource); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }
	 * 
	 * //jdbc�������� �������� �����ϱ� ���� preparedStatement��ü�� �����ؾ� �ߴ� //������ mybatis�� �̿��ϸ�
	 * ���� SqlSession�̶�� ��ü�� ����ϸ� �ȴ�. SqlSessionFactory factory = new
	 * SqlSessionFactoryBuilder().build(inputStream);
	 * 
	 * SqlSession session=factory.openSession();
	 * 
	 * //�������� �����ϴ� mapper xml�� ���̵� ��ȸ�Ͽ� �������� ���� List
	 * list=session.selectList("selectAll");
	 * System.out.println("�ѻ������ "+list.size());
	 * 
	 * }
	 */

}
