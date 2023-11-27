<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }  
   
	#wrap {
    	position: absolute;
    	left:50%;
    	top: 50%;
    	transform:translate(-50%,-50%);
	}
	
	div.photos {
		float: left;
		width: 150px;
		height: 150px;
		margin-left: 7px;
	}
	
	div.photos img {
		width: 130px;
		height: 130px;
		border: 1px solid gray;
		box-shadow: 3px 3px 3px gray;
	}
	
	div.photos .photodel {
		position: relative;
		cursor: pointer;	
	}
	
	div.photos .photodel:hover {
		color: red;
	}
	
    #previewContainer {
        display: flex;
        flex-direction: column;
        overflow-x: auto;
        margin-top: 10px;
        right: 44px;
        top: 80px;
        position: absolute;
    }

    .preview {
        width: 130px;
        height: 130px;
        margin-right: 10px;
        margin-top: 10px;
    }
    
    h6.newPhotoPreview {
        position: absolute;
        right: 55px;
        top: 52px;
        color: orange;
    }
    
    #photosContainer {
        max-height: 300px; /* 최대 높이를 설정, 필요에 따라 조절 가능 */
        overflow-y: auto; /* 세로 스크롤 적용 */
    }
</style>
</head>
<body>
	<!-- 로그인 안했을 경우 -->
	<c:if test="${sessionScope.loginok == null}">
		<br><br><br><br><br><br>
		<h3 style="color: red;">로그인을 해야만 수정이 가능합니다.</h3>
	</c:if>
	
	<!-- 로그인 했을 경우 -->
	<c:if test="${sessionScope.loginok != null}"> <!-- 로그인을 해야만 글쓰기 버튼이 보이게끔 처리 -->
		<div id="wrap">
			<form action="./updateboard" method="post" enctype="multipart/form-data">
				<!-- hidden -->
				<input type="hidden" name="currentPage" value="${currentPage}">
				<input type="hidden" name="num" value="${dto.num}">
			
				<table class="table table-bordered" style="width: 500px;">
					<caption align="top">
						<b>글 수정</b>
					</caption>
					<tr>
						<th width="100">제목</th>
						<td>
							<input type="text" name="subject" class="form-control" required autofocus value="${dto.subject}">
						</td>
					</tr>
					<tr>
						<th width="100">사진</th>
						<td>
							<input type="file" name="upload" multiple class="form-control">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div id="photosContainer">
								<textarea name="content" class="form-control" required style="width: 100%; height: 100px;">${dto.content}</textarea>
								<br>
								<c:forEach var="fdto" items="${file_list}">
									<div class="photos">
										<img src="../res/upload/${fdto.photoname}">
										<i class="bi bi-x-circle photodel" idx="${fdto.idx}"></i>
										<script>
											$(document).on("click", ".photodel", function(){
												let idx = $(this).attr("idx");
												let $photodel = $(this);
												$.ajax({
													type: "get",
													dataType: "text",
													url: "./delphoto",
													data: {"idx":idx},
													success: function (res) {
														// 사진 삭제 : 삭제 아이콘의 부모 태그 제거
														$photodel.parent().remove();
													},
													statusCode: {
														404: function () {
															alert("Can't find json file!");
														},
														500: function () {
															alert("server error. one more view your code.");
														}
													}
												});
											});
										</script>
									</div>
								</c:forEach>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" style="text-align: center;">
							<button type="submit" class="btn btn-outline-success">수정</button>
							<button type="button" class="btn btn-outline-success" onclick="history.back()">이전</button>
						</td>
					</tr>
				</table>
				
			</form>
		</div>
		<!-- 신규 사진 미리보기 컨테이너 -->
		<h6 class="newPhotoPreview">추가된 사진 미리보기</h6>
		<div id="previewContainer"></div>
		
		<!-- 추가된 스크립트 -->
        <script>
            $(function () {
            	// 초기에는 미리보기 텍스트 숨기기
            	const $newPhotoPreview = $('.newPhotoPreview');
            	$newPhotoPreview.css("display", "none");
            	
                // 파일 선택 시 미리보기 기능
                $('input[name="upload"]').on('change', function (e) {
                    const input = e.target;
                    const $previewContainer = $('#previewContainer');
                    
                 	// 기존 미리보기 초기화
                    $previewContainer.empty(); 

                    for (let i = 0; i < input.files.length; i++) {
                        const file = input.files[i];
                        const reader = new FileReader();

                        reader.onload = function (e) {
                            const $img = $('<img>').attr('src', e.target.result).addClass('preview');
                            $previewContainer.append($img);

                            // 추가된 사진이 있을 때에만 미리보기 텍스트 표시
                    		$newPhotoPreview.css("display", input.files.length > 0 ? 'block' : 'none');
                        };

                        reader.readAsDataURL(file);
                    }
                    
                });

                // 이미지 삭제 이벤트
                $(document).on("click", ".photodel", function () {
                    let idx = $(this).attr("idx");
                    let $photodel = $(this);

                    $.ajax({
                        type: "get",
                        dataType: "text",
                        url: "./delphoto",
                        data: { "idx": idx },
                        success: function (res) {
                            // 사진 삭제 : 삭제 아이콘의 부모 태그 제거
                            $photodel.parent().remove();
                        
                            // 미리보기에서도 삭제
                            $(`.preview[data-idx="${idx}"]`).remove();
                            
                            // 추가된 사진이 없을 때에는 미리보기 텍스트 숨김
                            $newPhotoPreview.css('display', $("#previewContainer img").length > 0 ? 'blick' : 'none');
                        },
                        statusCode: {
                            404: function () {
                                alert("Can't find json file!");
                            },
                            500: function () {
                                alert("server error. one more view your code.");
                            }
                        }
                    });
                });
            });
        </script>
	</c:if>
</body>
</html>
