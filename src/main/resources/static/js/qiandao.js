var calUtil = {  
      //当前日历显示的年份  
      showYear:new Date().getFullYear(),  
      //当前日历显示的月份  
      showMonth:new Date().getMonth()+1,  
      //当前日历显示的天数  
      showDays:new Date().getDate(),  
      eventName:"load",  
      //初始化日历  
      init:function(signList){  
        calUtil.setMonthAndDay();  
        calUtil.draw(signList);  
        calUtil.bindEnvent();  
      },  
      draw:function(signList){  
        //绑定日历  
        var str = calUtil.drawCal(calUtil.showYear,calUtil.showMonth,signList);  
        $("#calendar").html(str);  
        //绑定日历表头  
        var calendarName=calUtil.showYear+"年"+calUtil.showMonth+"月";  
        $(".calendar_month_span").html(calendarName);    
      },  
      //绑定事件  
      bindEnvent:function(){  
        //绑定上个月事件  
        $(".calendar_month_prev").click(function(){  
          //ajax获取日历json数据  
        	  var signList = [];
			  var year = calUtil.showYear;
			  var month = calUtil.showMonth-1;
			  if(month == 0){
				  month = 12;
				  year = year - 1
			  }
			    $.ajax({
					url:"getSignDay",
					type:"post",
					data:JSON.stringify({year:year,month:month}),
					contentType:"application/json;charset=UTF-8",
					dataType:"json",
					success:function(data){
						for(i in data){
							var a={"signDay":data[i].signDay,"status":data[i].status};
							signList.push(a);
						}
						calUtil.eventName="prev";  
				        calUtil.init(signList);  
					},
					error:function(){
					alert("error");
			
					}
				
				});    
          
        });  
        //绑定下个月事件  
        $(".calendar_month_next").click(function(){  
          //ajax获取日历json数据  
        	var signList = [];
        	 var year = calUtil.showYear;
			  var month = calUtil.showMonth+1;
			  if(month == 13){
				  month = 1;
				  year = year + 1
			  }
		    $.ajax({
				url:"getSignDay",
				type:"post",
				data:JSON.stringify({year:year,month:month}),
				contentType:"application/json;charset=UTF-8",
				dataType:"json",
				success:function(data){
					for(i in data){
						var a={"signDay":data[i].signDay,"status":data[i].status};
						signList.push(a);
					}
					calUtil.eventName="next";  
			        calUtil.init(signList);  
				},
				error:function(){
				alert("error");
		
				}
			
			});    
        });  
      },  
      //获取当前选择的年月  
      setMonthAndDay:function(){  
        switch(calUtil.eventName)  
        {  
          case "load":  
            var current = new Date();  
            calUtil.showYear=current.getFullYear();  
            calUtil.showMonth=current.getMonth() + 1;  
            break;  
          case "prev":  
            var nowMonth=$(".calendar_month_span").html().split("年")[1].split("月")[0];  
            calUtil.showMonth=parseInt(nowMonth)-1;  
            if(calUtil.showMonth==0)  
            {  
                calUtil.showMonth=12;  
                calUtil.showYear-=1;  
            }  
            break;  
          case "next":  
            var nowMonth=$(".calendar_month_span").html().split("年")[1].split("月")[0];  
            calUtil.showMonth=parseInt(nowMonth)+1;  
            if(calUtil.showMonth==13)  
            {  
                calUtil.showMonth=1;  
                calUtil.showYear+=1;  
            }  
            break;  
        }  
      },  
      getDaysInmonth : function(iMonth, iYear){  
       var dPrevDate = new Date(iYear, iMonth, 0);  
       return dPrevDate.getDate();  
      },  
        
      qiandao:function(){  
          
          var signList = [];
		    
		    $.ajax({
				url:"ajaxQianDao",
				type:"post",
				data:JSON.stringify({year:calUtil.showYear,month:calUtil.showMonth}),
				contentType:"application/json;charset=UTF-8",
				dataType:"json",
				success:function(data){
					for(i in data){
						var a={"signDay":data[i].signDay,"status":data[i].status};
						signList.push(a);
					}
					 alert("签到成功"); 
					calUtil.init(signList); 
				},
				error:function(){
				alert("error");
		
				}
			
			});
          calUtil.init(signList);  
      },  
        
      bulidCal : function(iYear, iMonth) {  
       var aMonth = new Array();  
       aMonth[0] = new Array(7);  
       aMonth[1] = new Array(7);  
       aMonth[2] = new Array(7);  
       aMonth[3] = new Array(7);  
       aMonth[4] = new Array(7);  
       aMonth[5] = new Array(7);  
       aMonth[6] = new Array(7);  
       var dCalDate = new Date(iYear, iMonth - 1, 1);  
       var iDayOfFirst = dCalDate.getDay();  
       var iDaysInMonth = calUtil.getDaysInmonth(iMonth, iYear);  
       var iVarDate = 1;  
       var d, w;  
       aMonth[0][0] = "日";  
       aMonth[0][1] = "一";  
       aMonth[0][2] = "二";  
       aMonth[0][3] = "三";  
       aMonth[0][4] = "四";  
       aMonth[0][5] = "五";  
       aMonth[0][6] = "六";  
       for (d = iDayOfFirst; d < 7; d++) {  
        aMonth[1][d] = iVarDate;  
        iVarDate++;  
       }  
       for (w = 2; w < 7; w++) {  
        for (d = 0; d < 7; d++) {  
         if (iVarDate <= iDaysInMonth) {  
          aMonth[w][d] = iVarDate;  
          iVarDate++;  
         }  
        }  
       }  
       return aMonth;  
      },  
      ifHasSigned : function(signList,day){  
       var signed = 0;  
       $.each(signList,function(index,item){  
        if(item.signDay == day) {  
         signed = item.status;
         return signed;  
        }  
       });  
       return signed ;  
      },  
      drawCal : function(iYear, iMonth ,signList) {  
       var myMonth = calUtil.bulidCal(iYear, iMonth);  
       var htmls = new Array();  
       htmls.push("<div class='sign_main' id='sign_layer'>");  
       htmls.push("<div class='sign_succ_calendar_title'>");  
       htmls.push("<div class='calendar_month_next btn btn-primary'>下月</div>");  
       htmls.push("<div class='calendar_month_prev btn btn-primary'>上月</div>");  
       htmls.push("<div class='calendar_month_span'></div>");  
       htmls.push("</div>");  
       htmls.push("<div class='sign' id='sign_cal'>");  
       htmls.push("<table>");  
       htmls.push("<tr>");  
       htmls.push("<th>" + myMonth[0][0] + "</th>");  
       htmls.push("<th>" + myMonth[0][1] + "</th>");  
       htmls.push("<th>" + myMonth[0][2] + "</th>");  
       htmls.push("<th>" + myMonth[0][3] + "</th>");  
       htmls.push("<th>" + myMonth[0][4] + "</th>");  
       htmls.push("<th>" + myMonth[0][5] + "</th>");  
       htmls.push("<th>" + myMonth[0][6] + "</th>");  
       htmls.push("</tr>");  
       var d, w;  
       for (w = 1; w < 7; w++) {  
        htmls.push("<tr>");  
        for (d = 0; d < 7; d++) {  
         var ifHasSigned = calUtil.ifHasSigned(signList,myMonth[w][d]);  
         if(myMonth[w][d]==new Date().getDate()&&new Date().getMonth()+1==calUtil.showMonth&&!ifHasSigned){  
             //当前月当前天，允许签到  
             htmls.push("<td><button onclick='calUtil.qiandao()' class='btn btn-success'>签到</button></td>");  
         }else{  
             if(ifHasSigned==1){  
                 htmls.push("<td class='on'>" + (!isNaN(myMonth[w][d]) ? myMonth[w][d] : " ") + "</td>");  
             }else if(ifHasSigned==2){  
                 htmls.push("<td class='holidy'>" + (!isNaN(myMonth[w][d]) ? myMonth[w][d] : " ") + "</td>");  
             } else {  
                 htmls.push("<td>" + (!isNaN(myMonth[w][d]) ? myMonth[w][d] : " ") + "</td>");  
             }  
         }  
          
        }  
        htmls.push("</tr>");  
       }  
       htmls.push("</table>");  
       htmls.push("</div>");  
       htmls.push("</div>");  
       return htmls.join('');  
   }  
};  