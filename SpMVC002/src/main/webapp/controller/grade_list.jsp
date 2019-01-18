<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		Connection  dbConn;
		String dbDriver = "oracle.jdbc.driver.OracleDriver";

		String sql = " SELECT * FROM tbl_student ";
		PreparedStatement ps;

		try {
			/*
			 * Driver를 Loading하여 실행
			 */
			Class.forName(dbDriver);

			/*
			 * DB에 접속할 profile변수 선언
			 */
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "gradeUser";
			String password = "1234";

			dbConn = DriverManager.getConnection(url, user, password);

			ps = dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String st_num = rs.getString("st_num");
				String st_name = rs.getString("st_name");
				String st_tel = rs.getString("st_tel");
				String st_addr = rs.getString("st_addr");
	%>

	<p><%=st_num%>&nbsp;&nbsp;&nbsp;
		<%=st_name%>&nbsp;&nbsp;&nbsp;
		<%=st_tel%>&nbsp;&nbsp;&nbsp;
		<%=st_addr%>



		<%
			}
				rs.close();
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		%>
	
</body>
</html>