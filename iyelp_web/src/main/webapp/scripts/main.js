/**
 * 
 */
require.config({
    paths: {
        jquery: 'libs/jquery-1.11.1.min'
    }
});
require(['jquery',"xx"], function( $,xx ) {
    console.log( $ ) // OK
    //alert("ada");
	
   $("#xx").click(function(){
	   xx.show();
   });
});

require(['xx'], function(xx ) {
});