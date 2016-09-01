'use strict';
$(document).ready(function(){
		$(".nav-link").mouseover(changeblue);
		$(".nav-link").mouseleave(changeColor);

		function changeblue(event) {
			$(this).css("background-color", "lightblue");
		}

		function changeColor(event) {
			$(this).css("background-color", "#eee");
		}

		$("#Asking").click(function () {
			$.get('http://jsonplaceholder.typicode.com/posts')
			.done(loadPost)
			.fail(ajaxFailure);
  		});

  	function loadPost(data){
  		$('#post').empty();
	 for (var i = 0; i < data.length; i++) {
		$('<li>')
        .text(data[i].userId)
        .appendTo('#post');

        $('<span>')
         .text(data[i].body)
         .appendTo('#post');
        
        $('<br/>')
        .appendTo('#post');
        
        
        $('<img alt="" data-id=' + data[i].id + ' src="./image/Comment.ico" style="width:25px; height:25px">')
        .addClass("mycomment")
        .appendTo('#post');
        
        $('<img alt="" class= "like" src="./image/Like.ico" style="width:25px; height:25px">')
        .addClass("mylike")
        .appendTo('#post');
        $('<p>')
        .addClass("comment")
        .appendTo('#post');
	   }

	 $("img").wrap('<a href="#"></a>');
	 
	  $(".mycomment").on("click", function () {
		    var postid = $(this).data("id");
		    var url = 'http://jsonplaceholder.typicode.com/comments?postId=' + postid;
		    $.get(url)
		      .done(getComment)
		      .fail(ajaxFailure);
		  });
	  
	  $(".mylike").on("click", function () {
		    var postid = $(this).data("id");
		    var url = 'http://jsonplaceholder.typicode.com/comments?postId=' + postid;
		    $.get(url)
		      .done(getlike)
		      .fail(ajaxFailure);
		  });
	 
	 
  	}
  	
  	function getComment(data) {
  	      for (var i = 0; i < data.length; i++) {
  	      $('<li>')
  	        .text(data[i].name)
  	        .appendTo($('.comment').eq(0));
  	      $('<span>')
  	        .text(data[i].body)
  	        .appendTo($('.comment').eq(0));

  	    }
  	  }
  	
  	function getLike(data) {
	      for (var i = 0; i < data.length; i++) {
	      $('<span>')
	        .text(data[i].like + 1)
	        .appendTo($('img.like').eq(0));

	    }
	  }

	  function ajaxFailure(){}

});




