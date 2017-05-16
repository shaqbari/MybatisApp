<%@page import="app.dept.Dept"%>
<%@page import="app.emp.Emp"%>
<%@page import="app.emp.EmpDAO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.ibatis.io.Resources"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	EmpDAO empDAO=new EmpDAO();
%>
<%
	List<Emp> list=empDAO.select();
	out.print("dao이용한 사원수는 "+list.size()+"<br>");
	
	/* Emp emp=empDAO.select(7369);
	out.print("7369 사원 이름은"+emp.getEname()); */
	
	
	
	
%>
<table width="100%" border="1px">
	<tr>
		<td>EMPNO</td>
		<td>ENAME</td>
		<td>SAL</td>
		<td>HIREDATE</td>
		<td>COMM</td>
		<td>MGR</td>
		<td>DEPTNO</td>
		<td>DNAME</td>
		<td>LOC</td>
	<tr>
	<%for(int i=0; i<list.size(); i++){ %>
		<%Emp emp=list.get(i); %>
		<%Dept dept=emp.getDept(); %>	
		<tr>
			<td><%=emp.getEmpno() %></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getSal() %></td>
			<td><%=emp.getHiredate() %></td>
			<td><%=emp.getComm() %></td>
			<td><%=emp.getMgr() %></td>
			<td><%=dept.getDeptno()%></td>
			<td><%=dept.getDname() %></td>
			<td><%=dept.getLoc()%></td>
		<tr>
	<%} %>
</table>
	
	
	
	
	
	
	
	
	
	
	
<%







	//패키지에 들어있는 파일이 클래스가 아닌, 일반파일인 경우
	//도트가 아닌 그냥 /로 접근해야 한다.
	/* String resource = "mybatis/config/config.xml";
	InputStream inputStream = null;

	try {
		inputStream = Resources.getResourceAsStream(resource);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	//jdbc시절에는 쿼리문을 수행하기 위해 preparedStatement객체를 생성해야 했다
	//하지만 mybatis를 이용하면 오직 SqlSession이라는 객체만 사용하면 된다.
	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

	//SqlSession session = factory.openSession(); 내장객체로 sesseion이 있다.
	SqlSession ss = factory.openSession();

	//쿼리문이 존재하는 mapper xml의 아이디를 조회하여 쿼리문을 수행
	List list = ss.selectList("selectAll");
	out.print("사원수는 "+list.size()); */
%>
