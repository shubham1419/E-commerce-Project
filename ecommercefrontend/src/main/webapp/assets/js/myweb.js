$(function(){
	//for active menu
	alert(menu);
	switch(menu){	
	case 'About Us':
		$('#about').addclass('active');
		break;
	case 'Contact Us':
		$('#contact').addclass('active');
		break;
	default:
		$('#home').addclass('active');
		break;
	}
});