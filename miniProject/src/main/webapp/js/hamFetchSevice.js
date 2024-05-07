document.addEventListener("DOMContentLoaded", initForm);

function initForm() {
	svc.hamList((result) => {
		result.forEach(ham => {
			let tr = makeRow(ham);
			document.querySelector('#hlist').appendChild(tr);
		}) // end of forEach.
	}, // successCall
		(err) => console.log(err)
	); // errorCall
}

function makeRow(ham = {}){
	let props = ['ham_No','ham_Name','ham_Kcal','ham_Price','ham_Stuff'];
	let tr = document.createElement('tr');
	props.forEach(prop => {
		let td = document.createElement('td');
		td.innerHTML = ham[prop];
		tr.appendChild(td);
	})
	
	return tr;
}