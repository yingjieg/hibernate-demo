<%@page import="code.demo.model.Platform"%>
<%@page import="code.demo.model.TestRecord"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Platform> platforms = (List<Platform>) request
			.getAttribute("platforms");
	List<TestRecord> records = (List<TestRecord>) request
			.getAttribute("records");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#main {
	width: 600px;
	height: 400px;
	margin: 0 auto;
}

#filterBar {
	height: 40px;
}
</style>
</head>
<body>
	<div id="main">
		<div id="filterBar">
			<form action="./index" method="post" name="demoform">
				Platforms: <select id="sltPlatform" name="sltPlatform">
					<%
						for (Platform p : platforms) {
					%>
					<option value="<%=p.getId()%>"><%=p.getPlatformName()%></option>
					<%
						}
					%>
				</select>
				<button onclick="submit();">filter</button>
			</form>
		</div>
		<div id="recordlist">
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Test Phase</th>
						<th>Platform</th>
						<th>Result</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (TestRecord r : records) {
					%>
					<tr>
						<td><%=r.getId()%></td>
						<td><%=r.getTestPhase().getTestphase()%></td>
						<td><%=r.getPlatform().getPlatformName()%></td>
						<td><%=r.getResult().getResult()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>