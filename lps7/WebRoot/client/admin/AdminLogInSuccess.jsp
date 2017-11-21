<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	/* 	request.setCharacterEncoding("utf-8");
		boolean isError = false;
		String action = request.getParameter("action");
		if (action != null && action.equals("logIn")) {
			Connection conn = DBService.getConn();
			String idAdmin = request.getParameter("idAdmin");
			String password = request.getParameter("password");
			
	// 		System.out.println(idAdmin + password);
			try {
				AdminService.checkLogIn(idAdmin, password);
			} catch (AdminInformationErrorException e) {
				isError = true;
	// System.out.println("Catch AdminInformationErrorException");
				System.out.println(e.getMessage());
			}
			if (isError == false) { //信息没有错误，登入成功
				Admin user = new Admin(idAdmin);
				session.setAttribute(idAdmin, user);
				response.sendRedirect("AdminOrder.jsp?idAdmin=" + user.getIdAdmin());
			}
		} */
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Animated Form Switching with jQuery</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<meta name="description"
	content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
<meta name="keywords"
	content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/reg_ajax.js"></script>

</head>
<body>
	success
</body>
</html>