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
	
	// for data Table plugin
	
/*	
 * dummydata
 * var product = [
		
		['1','prd1'],
		['2','prd2'],
		['3','prd3'],
		['4','prd4'],
		['5','prd5'],
		['6','prd6'],
		['7','prd7'],
		['8','prd8']
	]*/
	
	var $table=$('#productTable');
	// execute if table is exist
	
	if($table.length)
		{
		
		var jsonUrl = '';
		if(window.categoryId=='')
		{
			jsonUrl = window.contextRoot +'/json/data/all/products';
		}
		if(window.categoryId!='')
		{
			jsonUrl = window.contextRoot +'/json/data/category/'+ window.categoryId +'/products';
		}
		
		//console.log("in table working");
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Products','5 Products','10 Products','All Products']],
			pageLength:5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''	
			},
			columns: [
				
				{
					data: 'code',
					mRender: function(data,type,row)
					{
						return '<img src ="'+contextRoot+'/resources/images/'+data+'.jpg" class="img img-responsive prd-img">';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data,type,row)
					{
						return '&#8377; ' +data	
					}
				},
				{
					data: 'quantity',
					mRender: function(data, type, row) 
					{
						if(data<1){
							return '<span style="color:red">Out of Stock!</span>';
						}
						return data;
					}
					
				},
				{
					data: 'id',
					mRender: function(data,type,row)
					{
						var str ='';
						str+= '<a href="'+window.contextRoot+ '/show/'+data+'/products" class= "btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a>&#160;';
						
						if(row.quantity<1)
							{
							str+= '<a href="javascriptscript(void)" class= "btn btn-success disabled"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>';
							}
						else
						{
							str+= '<a href="'+window.contextRoot+ '/cart/add/'+data+'/products" class= "btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>';
						}
						
						return str;
					}
				},
			]
			
			
			
		});
		}
	// dissimissing alert message

	var $alert =$(".alert");

	if($alert.lenght)
		console.log("in table working");
		{
			setTimeout(
				function(){
					$alert.fadeOut("slow");
				}	
					,2000)
		}
	
});