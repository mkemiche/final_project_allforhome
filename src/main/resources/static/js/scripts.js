$(document).ready(function(){
    formatDate();
    verifyRadioIfChecked();
    verifyCheckboxesIfChecked();
    manageStepTemplate();
    uploadImage();
    formatCurrency();
});

var manageStepTemplate = function() {
    var current_fs, next_fs, previous_fs; //fieldsets
    var opacity;
    var current = 1;
    var steps = $("fieldset").length;

    setProgressBar(current);

    $(".next").click(function(){
        if(failed){
            verifyRadioIfChecked();
            verifyCheckboxesIfChecked();
            return false;
        }
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
//}

$(".previous").click(function(){
    verifyRadioIfChecked();
    verifyCheckboxesIfChecked();
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
});*/

sendFile = function(file){
    var formData = new FormData();
    var request = new XMLHttpRequest();
    var ref = $("#label-ref").val();
    formData.set('file', file);
    formData.set('ref', ref);
    request.open('POST', 'http://localhost:8080/uploadFile');
    request.send(formData);
}


function uploadImage() {
      var button = $('.images .pic')
      var uploader = $('<input type="file" enctype="multipart/form-data"/>')
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
          sendFile(uploader[0].files[0]);
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





var failed = false;
$(".next:eq(0)").each(function(){
    $(this).on('click', function(){
        var isChecked = $('input[type*="radio"]').is(':checked');
        var isTitleFilled = $('#label-title').val() === '';
        var radioBtnList = $('.intro .btn');

        $('#label-title').removeClass('is-invalid');
        radioBtnList.removeClass('btn-outline-danger').addClass('btn-outline-warning');
        failed = false;

        if(!isChecked && isTitleFilled){
            $('#label-title').addClass('is-invalid');
            radioBtnList.removeClass('btn-outline-warning').addClass('btn-outline-danger');
            failed = true;
            return false;
        }
        if(!isChecked || isTitleFilled){
            if(!isChecked){
                radioBtnList.removeClass('btn-outline-warning').addClass('btn-outline-danger');
            }
            if(isTitleFilled){
                $('#label-title').addClass('is-invalid');
            }
            failed = true;
            return false;
        }
    })
});

$(".next:eq(1)").each(function(){
    $(this).on('click', function(){
        var status = $('#label-status option').filter(':selected').text() === '';
        var type = $('#label-type').val() === '';
        var description = $('#label-descrip').val() === '';

        $('#label-status').removeClass('is-invalid');
        $('#label-type').removeClass('is-invalid');
        $('#label-descrip').removeClass('is-invalid');
        failed = false;

        if(status && type && description){
           $('#label-status').addClass('is-invalid');
           $('#label-type').addClass('is-invalid');
           $('#label-descrip').addClass('is-invalid');
           failed = true;
           return false;
        }
        if(status || type || description){
            if(status)
                $('#label-status').addClass('is-invalid');
            if(type)
                $('#label-type').addClass('is-invalid');
            if(description)
                $('#label-descrip').addClass('is-invalid');

            failed = true;
            return false;
        }


    })
});

$(".next:eq(2)").each(function(){
    $(this).on('click', function(){
        var bedrooms = $('#bedrooms option').filter(':selected').text() === '';
        var bathrooms = $('#bathrooms option').filter(':selected').text() === '';
        var area = $('#label-area').val() === '';
        var price = $('#label-price').val() === '';

        $('#bedrooms').removeClass('is-invalid');
        $('#bathrooms').removeClass('is-invalid');
        $('#label-area').removeClass('is-invalid');
        $('#label-price').removeClass('is-invalid');
        failed = false;

        if(bedrooms && bathrooms && area && price){
            $('#bedrooms').addClass('is-invalid');
            $('#bathrooms').addClass('is-invalid');
            $('#label-area').addClass('is-invalid');
            $('#label-price').addClass('is-invalid');
            failed = true;
            return false;
        }
        if(bedrooms || bathrooms || area || price){
            if(bedrooms)
                $('#bedrooms').addClass('is-invalid');
            if(bathrooms)
                $('#bathrooms').addClass('is-invalid');
            if(area)
                $('#label-area').addClass('is-invalid');
            if(price)
                $('#label-price').addClass('is-invalid');

            failed = true;
            return false;
        }
    })
});

$(".next:eq(3)").each(function(){
    $(this).on('click', function(){
        var address = $('#pLocation-adress').val() === '';
        var city = $('#pLocation-city').val() === '';
        var state = $('#pLocation-state').val() === '';
        var zcode = $('#pLocation-zipcode').val() === '';

        $('#pLocation-adress').removeClass('is-invalid');
        $('#pLocation-city').removeClass('is-invalid');
        $('#pLocation-state').removeClass('is-invalid');
        $('#pLocation-zipcode').removeClass('is-invalid');
        failed = false;

        if(address && city && state && zcode){
           $('#pLocation-adress').addClass('is-invalid');
           $('#pLocation-city').addClass('is-invalid');
           $('#pLocation-state').addClass('is-invalid');
           $('#pLocation-zipcode').addClass('is-invalid');
           failed = true;
           return false;
        }
        if(address || city || state || zcode){
            if(address)
                $('#pLocation-adress').addClass('is-invalid');
            if(city)
                $('#pLocation-city').addClass('is-invalid');
            if(state)
                $('#pLocation-state').addClass('is-invalid');
            if(zcode)
                $('#pLocation-zipcode').addClass('is-invalid');
            failed = true;
            return false;
        }
    })
});

var verifyCheckboxesIfChecked = function(){
    $('.more-details input[type*="checkbox"]').each(function(){
        $(this).parent().removeClass('btn-warning').addClass('btn-outline-warning');
        if($(this).is(':checked')){
            $(this).parent().removeClass('btn-outline-warning').addClass('btn-warning');
        }
    });
}


$('.more-details input[type*="checkbox"]').each(function(){
    $(this).on('click', function(){
         if($(this).is(':checked')){
            $(this).parent().removeClass('btn-outline-warning').addClass('btn-warning');
         }else{
            $(this).parent().removeClass('btn-warning').addClass('btn-outline-warning');
         }

    })
});

var verifyRadioIfChecked = function(){
    $('input[type*="radio"]').each(function(){
         if($(this).is(':checked')){
            $(this).parent().parent().removeClass('btn-outline-warning').addClass('btn-warning');
         }
    });
}

var uncheckedAllRadios = function(){
    $('input[type*="radio"]').each(function(){
         $(this).parent().parent().removeClass('btn-outline-danger').removeClass('btn-warning').addClass('btn-outline-warning');
    });
}

$('input[type*="radio"]').each(function(){
    $(this).on('change', function(){
    uncheckedAllRadios();
     if($(this).is(':checked')){
        $(this).parent().parent().removeClass('btn-outline-warning').removeClass('btn-outline-danger').addClass('btn-warning');
     }

    })
});

var formatDate = function(){
    var options = {
            day: 'numeric',
            year: 'numeric',
            month: 'long',
            hour: 'numeric',
            minute: 'numeric'
    }
    $('.registration-date').each(function() {
        var text = $(this).text();
        var date = new Date(text);
        $(this).text(date.toLocaleString('en-US', options))

    });
}

var formatCurrency = function() {
    var options = {
          style: 'currency',
          currency: 'USD',
        }
    $('.price').each(function() {
        var price = parseInt($(this).text());
        $(this).text(price.toLocaleString('en-US', options));
    });
}

//images gallery animation
const imgs = document.querySelectorAll('.img-select a');
const imgBtns = [...imgs];
let imgId = 1;

imgBtns.forEach((imgItem) => {
    imgItem.addEventListener('click', (event) => {
        event.preventDefault();
        imgId = imgItem.dataset.id;
        slideImage();
    });
});

function slideImage(){
    const displayWidth = document.querySelector('.img-showcase img:first-child').clientWidth;

    document.querySelector('.img-showcase').style.transform = `translateX(${- (imgId - 1) * displayWidth}px)`;
}

window.addEventListener('resize', slideImage);

//reset password block display
/*var displayResetPasswordBlock = function() {
    $('.container.reset-block').hide();
    $('#btn-reset-pass').on('click', function(){
        $('.container.reset-block').toggle();
    })
}*/

$(".search-form .dropdown#category").on('click', function(){
        $(".search-form #category .dropdown-list ul").toggle();
    });

    $(".search-form #category .dropdown-list ul li").on('click', function(){
        var icon_text = $(this).html();
        $(".search-form #category .default-option").html(icon_text);
    });

    $(document).on('click', function(event){
        if(!$(event.target).closest(".search-form .dropdown#category").length){
            $(".search-form #category .dropdown-list ul").hide();
        }
    });

    $(".search-form .dropdown#location").on('click', function(){
            $(".search-form #location .dropdown-list ul").toggle();
        });

        $(".search-form #location .dropdown-list ul li").on('click', function(){
            var icon_text = $(this).html();
            $(".search-form #location .default-option").html(icon_text);
        });

        $(document).on('click', function(event){
            if(!$(event.target).closest(".search-form .dropdown#location").length){
                $(".search-form #location .dropdown-list ul").hide();
            }
        });

function displayFilterBlock(){
    $('.filter').toggle();
}

$('#cat-select').bind('DOMSubtreeModified', function(){
   $('#selected-category').val($(this).html());
});

$('#loc-select').bind('DOMSubtreeModified', function(){
   $('#selected-location').val($(this).html());
});