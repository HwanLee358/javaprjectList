/**
 * 
 */
//수정버튼
document.querySelector('#modBtn').addEventListener('click',function(){
	document.forms.myFrm.action = "modBoardForm.do";
	document.forms.myFrm.submit();
})

//삭제버튼
document.querySelector('.btn-danger').addEventListener('click',function(){
	document.forms.myFrm.action = "deleteForm.do";
	document.forms.myFrm.submit();
})