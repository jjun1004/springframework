<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class = "card m-2">
			<div class = "card-header">
					FileUpload & FileDownload
			</div>
			<div class="card-body">
					<div class = "card">
						<div class = "card-header">
								Form 태그를 이용한 FileUpload
						</div>
						<div class="card-body">
								<form method="post" enctype = "multipart/form-data" action = "fileupload">
									<div class="form-group">
										    <label for="title">File Title</label>
										    <input type="text" class="form-control" id="title" name="title" placeholder="제목">
									  </div>
									  <div class="form-group">
										    <label for="desc">File Description</label>
										    <input type="text" class="form-control" id="desc" name="desc" placeholder="설명">
									  </div>
									  <div class="form-group">
										    <label for="attach">Example file input</label>
										    <input type="file" class="form-control-file" id="attach" name="attach" multiple>
										   <!--  여러개 파일 선택: multiple -->
									  </div>
									  <button class="btn btn-info btn-sm">Form 파일 업로드</button>
									  <a href="javascript:fileupload()" class="btn btn-info btn-sm">AJAX 파일 업로드</a>
								</form>
						</div>
						<script>
							function fileupload() {
								//입력된 정보를 얻기
								const title = $("#title").val();
								const desc = $("#desc").val();
								const attach = document.querySelector("#attach").files[0];
								
								//Multipart/form-data
								const formData = new FormData();
								formData.append("title", title);
								formData.append("desc", desc);
								formData.append("attach", attach);
								
								//Ajax로 서버로 전송
								$.ajax({
									url: "fileuploadAjax",
									method: "post",
									data: formData,
									cache: false,    // 브라우저가 요청된 페이지를 캐싱해야 하는 지 여부를 나타냄
									processData: false, // 요청으로 보낸 데이터를 query string 형태로 변환할지 여부를 나타냄.
									contentType: false // 서버로 보내지는 데이터의content-type. 기본 값은 application/x-www-form-urlencoded"
								}).done((data) => {
									console.log(data);
									if(data.result === "success") {
										window.alert("파일 전송이 성공됨");
									}
								});
							}
						</script>
				</div>
				<div class="card">
					<div class="card-header">
							File Download
					</div>
					<div class="card-body">
							<a href="filedownload?fileNo=1"
								class = "btn btn-info btn-sm"> 파일 다운로드</a>
							<hr/>
							<img src="filedownload?fileNo=1" width= "200px"/>
					</div>
				</div>
		</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>