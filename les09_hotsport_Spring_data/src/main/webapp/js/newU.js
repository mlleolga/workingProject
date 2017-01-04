$(document).ready(function(){
  //Don't add any useless code here, 
});

//this function to applay your animate style
function animate_Me(target, moveMe){
  $(target).focus(function(){
	  $(moveMe).animate({
			"marginLeft":"266px"
		});
	});
}
//--------------------

animate_Me("input[type='text']", ".fa-user");
animate_Me("input[placeholder='Your Last Name']", ".fa-user-plus");
animate_Me("input[type='email']", ".fa-envelope");
animate_Me("input[type='password']", ".fa-lock");
animate_Me("input[placeholder='Confirm Password']", ".fa-refresh");



// $("input[type='text']").focus(function(){
// 		$(".fa-user").animate({
// 			"marginLeft":"266px"
// 		});
// 	});


	// $("input[placeholder='Your Last Name']").focus(function(){
	// 	$(".fa-user-plus").animate({
	// 		"marginLeft":"266px"
	// 	});
	// });