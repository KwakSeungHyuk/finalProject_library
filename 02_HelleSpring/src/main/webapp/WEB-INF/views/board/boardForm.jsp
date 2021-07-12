<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>    
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="게시글작성"/>
</jsp:include>
    <style>
    	div#board-container{width:400px; margin:0 auto; text-align:center;}
    	div#board-container input{margin-bottom:15px;}
    </style>
<section id="container">
<h1 style="text-align:center;">글쓰기</h1>
<div id="board-container">
        <form name="boardFrm" action="${path }/board/insertBoard.do" 
        method="post" enctype="multipart/form-data" >
            <input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle" required>
            <input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="boardWriter" value="${loginMember.userId}" readonly required>
            <div class="input-group mb-3" style="padding:0px;">
                <div class="input-group-prepend" style="padding:0px;">
                    <span class="input-group-text">첨부파일1</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="upFile" id="upFile1">
                    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
                </div>
            </div>
            <div class="input-group mb-3" style="padding:0px;">
                <div class="input-group-prepend" style="padding:0px;">
                    <span class="input-group-text">첨부파일2</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="upFile" id="upFile1">
                    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
                </div>
            </div>
            <textarea class="form-control" name="boardContent" placeholder="내용" required></textarea>
            <br />
            <input type="submit" class="btn btn-outline-success" value="저장" >
        </form>
    </div>


</section>
	<script>
		$(function(){
			$("[name=upFile]").change(e=>{
				const fileName=$(e.target).prop('files')[0].name;
				$(e.target).next(".custom-file-label").html(fileName);
			});
		})
	
	</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>










