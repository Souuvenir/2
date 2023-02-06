$('#myCarousel').carousel({
    interval: false
  });
  $('#carousel-thumbs').carousel({
    interval: false
  });
  

  $('[id^=carousel-selector-]').click(function() {
    var id_selector = $(this).attr('id');
    var id = parseInt( id_selector.substr(id_selector.lastIndexOf('-') + 1) );
    $('#myCarousel').carousel(id);
  });
  if ($(window).width() < 575) {
    $('#carousel-thumbs .row div:nth-child(4)').each(function() {
      var rowBoundary = $(this);
      $('<div class="row mx-0">').insertAfter(rowBoundary.parent()).append(rowBoundary.nextAll().addBack());
    });
    $('#carousel-thumbs .carousel-item .row:nth-child(even)').each(function() {
      var boundary = $(this);
      $('<div class="carousel-item">').insertAfter(boundary.parent()).append(boundary.nextAll().addBack());
    });
  }
  if ($('#carousel-thumbs .carousel-item').length < 2) {
    $('#carousel-thumbs [class^=carousel-control-]').remove();
    $('.machine-carousel-container #carousel-thumbs').css('padding','0 5px');
  }
  $('#myCarousel').on('slide.bs.carousel', function(e) {
    var id = parseInt( $(e.relatedTarget).attr('data-slide-number') );
    $('[id^=carousel-selector-]').removeClass('selected');
    $('[id=carousel-selector-'+id+']').addClass('selected');
  });

  $('#myCarousel').swipe({
    fallbackToMouseEvents: true,
    swipeLeft: function(e) {
      $('#myCarousel').carousel('next');
    },
    swipeRight: function(e) {
      $('#myCarousel').carousel('prev');
    },
    allowPageScroll: 'vertical',
    preventDefaultEvents: false,
    threshold: 75
  });
  
  $('#myCarousel .carousel-item img').on('click', function(e) {
    var src = $(e.target).attr('data-remote');
    if (src) $(this).ekkoLightbox();
  });

function validateRut() {
    let rut = document.getElementById('rut').value;
    rut = rut.replaceAll('.', '');
    rut = rut.split('-');
    rutPreGuion = rut[0];
    dvInput = rut[1];
    dv = dgv(rutPreGuion);
    if(dv != dvInput) alert('El digito verificador es incorrecto')
    console.log(rut, dv);
    if(rutPreGuion.length !=8 && rutPreGuion.length !=7){
        alert('Largo de RUT incorrecto')
    }
  }

function dgv(T)   {  
var M=0,S=1;
	for(;T;T=Math.floor(T/10))
    S=(S+T%10*(9-M++%6))%11;
	  return S?S-1:'k';
 }
