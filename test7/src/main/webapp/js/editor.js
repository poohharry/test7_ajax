$(document).ready(function() {
    $('#summernote').summernote({
        minWidth: null,             // 최소 높이
        maxWidth: null,             // 최대 높이
        minHeight: 500,             // 최소 높이
        maxHeight: 500,             // 최대 높이
        focus: false,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",					// 한글 설정
        placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
        disableResizeEditor: true,	//높이 조절 불가
        toolbar: [
            // [groupName, [list of button]]
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
        ],
    });
    $('.note-statusbar').hide();	// 높이조절 바 삭제
});