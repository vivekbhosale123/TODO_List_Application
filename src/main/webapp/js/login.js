function nameValidation(str)
{
	let RegExp=/^[a-zA-z ' ']+$/;
	let result=RegExp.test(str);
	if(result)
	{
	   document.getElementById("v").innerHTML=""
	}
	else
	{
	  document.getElementById("v").innerHTML="Invalid username";
	}
}
function PasswordValidation(str)
{
	let RegExp=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8}$/;
	let result=RegExp.test(str);
	if(result)
	{
	   document.getElementById("v").innerHTML=""
	}
	else
	{
	  document.getElementById("v").innerHTML="Invalid Password";
	}
}
function searchCategory(str)
{
    //let name=str;
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function()
	{
		if(xhttp.readyState==4 && xhttp.status==200)
		{
			document.getElementById("v").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","TodoAddSearch?todoName="+str,true);
	xhttp.send();
}
/*function search(str)
{
	console.log("i am here");
}*/
