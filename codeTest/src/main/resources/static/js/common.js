/**
 * targetrl로 submit
 * @param targetUrl
 * @returns
 */
function goAjaxSubmit(targetUrl){
	loadingAjaxImage();
	document.actionForm.action = targetUrl;
	document.actionForm.submit();	
}

/**
 * 
 * @param json
 * @param isSearchReset
 * @param reloadingUrl
 * @param failMsg
 * @returns
 */
function onAjaxSubmitSuccess(json, isSearchReset, reloadingUrl, failMsg){
	if(json.status == "success"){
		//검색 조건 초기화			
		if(isSearchReset){
			$("#p_MyPage").val("1");
			$('[name*=src_]').each(function(){
				$(this).val("");	
			});	
		}		
		goAjaxSubmit(reloadingUrl);
	}
	else{
		if(json.msg != null && !json.msg.isEmpty()){
			alert(json.msg);
		}
		else{
			alert(failMsg);
		}
		hideAjaxImage();
	}
}

/**
 * AJAX Error 처리
 */
(function($) {
	$.ajaxSetup({
		beforeSend: function(xhr) {
			xhr.setRequestHeader("AJAX", true);
		},
		error: function(request, status, error) {
			if(request.status == "403"){
				alert("Session TimeOut or Session invalid");
				document.location.href = "logout"
			}
			else{				
				alert("code : "+request.status+"\n"
						//+ "message:"+request.responseText
						+ "\n"+"error : "+error);
			}
			$("#ajaxLoadingImage").hide();
		}
	});
})(jQuery);