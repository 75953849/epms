$(function(){
$(".panel-heading").click(function(e){
    /*切换折叠指示图标*/
    $(this).find("span").toggleClass("glyphicon-menu-down");
    $(this).find("span").toggleClass("glyphicon-menu-up");
    /* $("*").removeClass("in"); */
});
$("li > button").click(function(e){
     console.log($(this).attr("data-target"));
     /* $("#content").load($(this).attr("data-target")); */
     window.location.href=$(this).attr("data-target");
});
$(".target").click(function(e){
    console.log($(this).attr("data-target"));
    /* $("#content").load($(this).attr("data-target")); */
    window.location.href=$(this).attr("data-target");
});
});