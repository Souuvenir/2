$(function(){
    $('#email').on('blur', function(){
        if($(this).val() == ""){
            alert("este campo no puede estar vacio");
            $('#buttons').prop('disabled', true);
        }else{
            $('#buttons').prop('disabled', false);
        }
    });
});
$(function(){
    $('#password').on('blur', function(){
        if($(this).val() == ""){
            alert("este campo no puede estar vacio");
            $('#buttons').prop('disabled', true);
        }else{
            $('#buttons').prop('disabled', false);
        }
    });
});
$(function(){
    $('#chat').on('click', function(){
        alert("Opcion en construccion");      
    });
});
$(function(){
    $('#usernamer').on('blur', function(){
        if($(this).val() == ""){
            alert("este campo no puede estar vacio");
            $('#registro').prop('disabled', true);
        }else{
            $('#registro').prop('disabled', false);
        }
    });
});
$(function(){
    $('#emailr').on('blur', function(){
        if($(this).val() == ""){
            alert("este campo no puede estar vacio");
            $('#registro').prop('disabled', true);
        }else{
            $('#registro').prop('disabled', false);
        }
    });
});
$(function(){
    $('#passr').on('blur', function(){
        if($(this).val() == ""){
            alert("este campo no puede estar vacio");
            $('#registro').prop('disabled', true);
        }else{
            $('#registro').prop('disabled', false);
        }
    });
});