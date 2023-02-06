let tap = 0;
let tlp = 0;
let totalm2 = 0;
let totaltr = 0;
$(function(){
    $('#name').on('blur', function(){
        if($(this).val().match('^[a-zA-Z]{3,16}$')){

            $(this).css("border", "1px solid green");
        }else{

            $(this).css("border", "1px solid red");
        }
    });
});
$(function(){
    $('#lastname').on('blur', function(){
        if($(this).val().match('^[a-zA-Z]{3,16}$')){

            $(this).css("border", "1px solid green");
        }else{
            
            $(this).css("border", "1px solid red");

        }
    });
});

$(function(){
    $('#usuario').on('blur', function(){
       value = $(this).val();
       if (value == null){
        alert('Campo no puede estar vacio');
       }
    });
    $('#contrasenia').on('blur', function(){
        tlp = $(this).val();
        totalm2 = (tap * tlp);
        totaltr = (totalm2 * 900); 
     });
});

    
$(document).ready(function(){
    $("#button").on("click", function(){
        $('#total').text(totalm2);
    });
    $("#button").on("click", function(){
        $('#trtotal').text(totaltr);
    });
});