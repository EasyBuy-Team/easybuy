    function $(id){
    	return document.getElementById(id);
    }
    
    function tijiao() {
		var question=$("question");
		if(question.value==""){
			alert("必须填写问题!");
			return false;
		}
		return true;
	}   