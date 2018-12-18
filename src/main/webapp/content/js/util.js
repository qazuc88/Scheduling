
if(!window.util){
	window.util=new Object();
}
util.getformDataToJson=function(formid){
	var arr=$(formid).serializeArray();
    var obj=new Object();
     for(var i=0,j=arr.length;i<j;i++){
   	  var item=arr[i];
   	  obj[item.name]=item.value;
    }
     return obj;
   };
   util.showmsg=function(msg){
	   layui.use("layer",function(){
		   layer.msg(msg);
	   });
   };
   util.showloading=function(msg){
	   layui.use("layer",function(){
		   layer.load(2);
	   });
   };
   util.hideloading=function(msg){
	   layui.use("layer",function(){
		   layer.closeAll('loading');
	   });
   };
   util.ajax=function(parms){
	  if(parms.formid){
		  parms.data=$("#"+parms.formid).serialize();
	  } 
	 if(parms.beforeSend){
		 var a=parms.beforeSend;
		 parms.beforeSend=function(p1,p2,p3,p4){a(p1,p2,p3,p4);util.showloading();}
	 }else{
		 parms.beforeSend=function(){util.showloading();}
	 }
	 if(parms.complete){
		 var a=parms.complete;
		 parms.complete=function(p1,p2,p3,p4){a(p1,p2,p3,p4);util.showloading();}
	 }else{
		 parms.complete=function(p){util.hideloading();}
	 }

	 if(parms.error){
		 var a=parms.complete;
		 parms.error=function(p1,p2,p3,p4){a(p1,p2,p3,p4);util.showmsg("网络错误,请稍后重试");}
	 }else{
		 parms.error=function(p){util.showmsg("网络错误,请稍后重试");}
	 }
	 $.ajax(parms);
   };