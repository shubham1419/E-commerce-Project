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
		
		
	//bootbox for activate/deactivate product by admin
		

		// data table for admin (all products)

		var $adminProductTable=$('#adminProductsTable');
		// execute if table is exist
		
		if($adminProductTable.length)
			{
			
			
			var jsonUrl = window.contextRoot +'/json/data/admin/all/products';
			
			//console.log("in table working");
			$adminProductTable.DataTable({
				lengthMenu:[[5,10,20,-1],['5 Products','10 Products','20 Products','All Products']],
				pageLength:10,
				ajax: {
					url: jsonUrl,
					dataSrc: ''	
				},
				columns: [
					{
						data:'id'
					},
										
					{
						data: 'code',
						mRender: function(data,type,row)
						{
							return '<img src ="'+contextRoot+'/resources/images/'+data+'.jpg" class="img adminDataTableImg">';
						}
					},
					{
						data: 'name'
					},
					{
						data: 'brand'
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
						data: 'unitPrice',
						mRender: function(data,type,row)
						{
							return '&#8377; ' +data	
						}
					},
					{
						data: 'active',
						bSortable:false,
						mRender: function(data,type,row)
						{
							var str='';
							
							str+= '<label class="switch">';
							if(data)
								{
								str+= '<input type="checkbox" checked="checked" value="'+row.id+'" />';

								}
							else
								{
								str+= '<input type="checkbox" value="'+row.id+'" />';
								}
							str+= '<div class="slider round"></div>	</label>';
							return str;
						}

					},
					{
						data:'id',
						bSortable:false,
						mRender: function(data,type,row)
						{
							var str='';
							str+= '<a href="${contextRoot}/manage/'+data+'/product" class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i></a>';
							return str;
						}	
						
					}
				],
				initComplete: function()
				{
					var api = this.api();
					api.$('.switch input[type="checkbox"]').on('change',function(){
						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var msg = (checked)?"Do you want to activate the product?":"Do you want to deactivate the product?";
						var value = checkbox.prop('value');
						bootbox.confirm({
							size:'medium',
							title:'Product Activation & Deactivation',
							message:msg,
							callback:function(confirmed){
								
								if(confirmed)
									{
									console.log(value);
									bootbox.alert({
										size:'medium',
										title:'Information',
										message:"You are performing operation on " +value
									});
									}
								else
								{
									checkbox.prop('checked', !checked);
								}
							}
							
							
						});
						
						
						
					});
					
				}
				
				
				
			});
			}
	
});