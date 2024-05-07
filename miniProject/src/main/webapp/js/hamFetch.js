const svc = {
	// 목록.
	hamList: function(successCall, errorCall) {
		fetch("../hamList.json")
			.then(result => result.json())
			.then(successCall)
			.catch(errorCall);
	}
}