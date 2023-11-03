<%@page import="findLost.data.findLostDto"%>
<%@page import="findLost.data.findLostDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String search = request.getParameter("search");
	
	findLostDao dao = new findLostDao();
	
	List<findLostDto> list = dao.getSearchName(search);
	
	JSONArray arr = new JSONArray();
	for(findLostDto dto : list){
		JSONObject ob = new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("name", dto.getName());
		ob.put("photo", dto.getPhoto());
		ob.put("lostplace", dto.getLostplace());
		ob.put("lostday", dto.getLostday());
		ob.put("money", dto.getMoney());
		
		arr.add(ob);
	}
%>

<%=arr.toString() %>