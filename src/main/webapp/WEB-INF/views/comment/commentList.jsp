<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<table>
		<thead>
			<tr>
				<th>번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cmnt}" var="cmnt">
				<tr>
					<td><c:out value="${cmnt.cmntSeq}" /></td>
					<td><c:out value="${cmnt.rgtrId}" /></td>
					<td><c:out value="${cmnt.rgtrDt}" /></td>
					<td><c:out value="${cmnt.cmntCn}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>