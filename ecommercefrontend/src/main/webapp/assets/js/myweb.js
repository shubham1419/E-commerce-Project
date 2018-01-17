$(function(){
	//for active menu
	switch(menu){	
	case 'About Us':
		$( "#about" ).addClass( "active" );
		//$('.py-5.bg-dark').hide();
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#allproducts').addClass('active');
		break;	
	default:
		if(menu=="Home") break;
		$('#allproducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
});