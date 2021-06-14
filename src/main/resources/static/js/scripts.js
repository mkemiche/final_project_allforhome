$(document).ready(function(){
    manageStepTemplate();
    uploadImage();
});

function manageStepTemplate() {
    var current_fs, next_fs, previous_fs; //fieldsets
    var opacity;
    var current = 1;
    var steps = $("fieldset").length;

    setProgressBar(current);

    $(".next").click(function(){

    current_fs = $(this).parent();
    next_fs = $(this).parent().next();

    //Add Class Active
    $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

    //show the next fieldset
    next_fs.show();
    //hide the current fieldset with style
    current_fs.animate({opacity: 0}, {
        step: function(now) {
        // for making fielset appear animation
        opacity = 1 - now;

        current_fs.css({
            'display': 'none',
            'position': 'relative'
        });
        next_fs.css({'opacity': opacity});
        },
        duration: 500
    });
    setProgressBar(++current);
});

$(".previous").click(function(){

    current_fs = $(this).parent();
    previous_fs = $(this).parent().prev();

//Remove class active
    $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

//show the previous fieldset
    previous_fs.show();

//hide the current fieldset with style
    current_fs.animate({opacity: 0}, {
    step: function(now) {
// for making fielset appear animation
    opacity = 1 - now;

    current_fs.css({
        'display': 'none',
        'position': 'relative'
    });
    previous_fs.css({'opacity': opacity});
},
    duration: 500
    });
    setProgressBar(--current);
});

function setProgressBar(curStep){
    var percent = parseFloat(100 / steps) * curStep;
    percent = percent.toFixed();
    $(".progress-bar")
    .css("width",percent+"%")
}

$(".submit").click(function(){
    return false;
    })
}

/* upload multi file management */
/*var files = [];

$("#input-file").change(function(){
    for (var i = 0; i < this.files.length; i++) {
        files.push(this.files[i]);
        var nb = files.length;
        var card = document.getElementById("card"+nb);
        card.src = URL.createObjectURL(this.files[i])
        sendFile(this.files[i]);
    }
});


*//*$("#form-file").on('submit', function(event){
    event.preventDefault();
    sendFile(files);
   *//**//* files.forEach(function(file){
        sendFile(file);
    })*//**//*
});*//*

sendFile = function(file){
    var formData = new FormData();
    var request = new XMLHttpRequest();
    var ref = $("#ref").text();
    formData.set('file', file);
    formData.set('pReference', ref);
    request.open('POST', 'http://localhost:8080/uploadFile');
    request.send(formData);
}*/


function uploadImage() {
      var button = $('.images .pic')
      var uploader = $('<input type="file" accept="image/*" />')
      var images = $('.images')
      var filesUploaded = [];
      button.on('click', function () {
        uploader.click()
      })

      uploader.on('change', function () {
          var reader = new FileReader()
          filesUploaded.push(uploader[0].files[0]);
          reader.onload = function(event) {
            images.prepend('<div id="'+filesUploaded.length+'" class="img" style="background-image: url(\'' + event.target.result + '\');" rel="'+ event.target.result  +'"><span>remove</span></div>')
          }
          reader.readAsDataURL(uploader[0].files[0])

       })

      images.on('click', '.img', function () {
        var id = parseInt($(this).attr("id"));
        filesUploaded.splice((id-1), 1);
        $(this).remove()
        updateImgId(images);
      })
    }

 function updateImgId(images){
    var imgs = document.querySelectorAll('.images .img');
    for(var i = imgs.length; i>0; i--){
        imgs[i].id = i;
    }
 }