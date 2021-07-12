<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>    
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="게시판"/>
</jsp:include>
<style>
	button#btn-add{
		float:right;
		margin:0 0 15px;
	}
</style>
<section id="content">
		<button id="btn-add"  class="btn btn-outline-success" 
		onclick="location.assign('${path}/board/boardForm.do')">글쓰기</button>
        <p>총 ${totalData }건의 게시물이 있습니다.</p>
        
        <table id="tbl-board" class="table table-striped table-hover">
            <tr>
                <th class="cols">번호</th>
                <th class="cols">제목</th>
                <th class="cols">작성자</th>
                <th class="cols">작성일</th>
                <th class="cols">첨부파일</th>
                <th class="cols">조회수</th>
            </tr>
          	<c:choose> 
   				<c:when test="${not empty list }">
   					<c:forEach var="b" items="${list }">
   						<tr>
   							<td class="cols"><c:out value="${b.boardNo }"/></td>
   							<td class="cols">
   								<a href="${path }/board/boardView.do?no=${b.boardNo}">
   									<c:out value="${b.boardTitle }"/>
   								</a>
   							</td>
   							<td class="cols"><c:out value="${b.boardWriter }"/></td>
   							<td class="cols"><c:out value="${b.boardDate }"/></td>
   							<td class="cols"><c:out value="${b.attachments.size() }"/></td>   							
   							<td class="cols"><c:out value="${b.boardCount }"/></td>
   						</tr>
   					</c:forEach>
   				</c:when>
   				<c:otherwise>
   					<tr>
   					<td colspan="6">조회된 자료가 없습니다</td>
   					</tr>
   				</c:otherwise>       		
          	</c:choose>
        </table> 
        <div id="pagebar-container">
        	${pageBar }
        </div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>