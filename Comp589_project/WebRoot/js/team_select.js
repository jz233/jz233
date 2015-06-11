$(function(){
        function objInit(obj){
        	$(obj).empty();
            return $(obj).html('<option>Please Select</option>');
        }
        var arrData={
	            West:{SouthWest:'Dallas Mavericks,Houston Rockets,Memphis Grizzlies,New Orleans Pelicans, San Antonio Spurs',
	                    NorthWest:'Denver Nuggets,Minnesota Timbervolves,Oklahoma City Thunder,Portland Trail Blazers,Utah Jazz',
	                    Pacific:'Golden State Warriors,Los Angeles Lakers,Los Angeles Clippers,Phoenix Suns,Sacramento Kings'},
	            East:{Atlantic:'Boston Celtics,Brooklyn Nets,New York Knicks, Philadelphia 76ers,Toronto Raptors',
	                    Central:'Chicago Bulls,Cleveland Cavaliers,Detroit Pistons,Indiana Pacers,Milwaukee Bucks',
	                    SouthEast:'Atlanta Hawks,Charlotte Hornets,Miami Heat,Orlando Magic,Washington Wizards'}
        };
        $.each(arrData,function(pF){	/* pF为key */
            $('#hmSelect .hselC, #awSelect .aselC').append('<option>'+pF+'</option>');
        });
        $('#hmSelect .hselC').change(function(){
            objInit('#hmSelect .hselD');	
            objInit('#hmSelect .hm_name');
            $.each(arrData,function(pF,pS){	/* pF:key   pS:value */
                if($('#hmSelect .hselC option:selected').text()==pF){
                    $.each(pS,function(pT,pC){		/* 将pS(之前的value)作为key，继续取出下一级的value值 */
                        $('#hmSelect .hselD').append('<option>'+pT+'</option>');
                    });
                    $('#hmSelect .hselD').change(function(){
                        objInit('#hmSelect .hm_name');
                        $.each(pS,function(pT,pC){
                            if($('#hmSelect .hselD option:selected').text()==pT){
                                $.each(pC.split(","),function(){
                                    $('#hmSelect .hm_name').append('<option>'+this+'</option>');
                                });
                            }
                        });
                        
                    });
                }
            });
        });
        $('#awSelect .aselC').change(function(){
        	objInit('#awSelect .aselD');	
        	objInit('#awSelect .aw_name');
        	$.each(arrData,function(pF,pS){	/* pF:key   pS:value */
        		if($('#awSelect .aselC option:selected').text()==pF){
        			$.each(pS,function(pT,pC){		/* 将pS(之前的value)作为key，继续取出下一级的value值 */
        				$('#awSelect .aselD').append('<option>'+pT+'</option>');
        			});
        			$('#awSelect .aselD').change(function(){
        				objInit('#awSelect .aw_name');
        				$.each(pS,function(pT,pC){
        					if($('#awSelect .aselD option:selected').text()==pT){
        						$.each(pC.split(","),function(){
        							$('#awSelect .aw_name').append('<option>'+this+'</option>');
        						});
        					}
        				});
        				
        			});
        		}
        	});
        });
    });