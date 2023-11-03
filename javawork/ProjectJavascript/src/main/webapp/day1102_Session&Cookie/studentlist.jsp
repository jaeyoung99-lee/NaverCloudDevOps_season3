<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="student_강사.data.StudentDto"%>
<%@page import="java.util.List"%>
<%@page import="student_강사.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String search=request.getParameter("search");
	StudentDao dao=new StudentDao();
	List<StudentDto> list=dao.getSearchStudent(search);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	JSONArray arr=new JSONArray();
	for(StudentDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("name",dto.getName());
		ob.put("blood",dto.getBlood());
		ob.put("phone",dto.getPhone());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		//배열에 추가
		arr.add(ob);		
	}
%>
<%=arr.toString()%>