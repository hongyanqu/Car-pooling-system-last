
$("#addPost").click(function () {
    $.post("AddPost",
            {
                post: $("textarea#postText").val(),
                postType: $("select#type").val()
            }, function () {
                $("textarea#postText").text("");
            });
            
}
       
);
