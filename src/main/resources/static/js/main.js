function cadastro(){
    //máscara telefone e celular
    var SPMaskBehavior = function (val) {
        return val.replace(/\D/g, '').length === 11 ? '(00) 0 0000-0000' : '(00) 0000-00009';
    },
    spOptions = {
        onKeyPress: function(val, e, field, options) {
            field.mask(SPMaskBehavior.apply({}, arguments), options);
        }
    };
    $('#tel').mask(SPMaskBehavior, spOptions);

    //máscara cpf
    $('#cpf').mask('000.000.000-00');

    //máscara cep
    $('#cep').mask('00000-000');

    $("#form-cadastro").validate({
        rules: {
            senha2: {
                equalTo: "#senha"
            }
        }
    });
}

function login(){
    $("#form-login").validate();
}

function detalhes(){
    $('.produto-slider-principal').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        fade: true,
        asNavFor: '.produto-slider-carousel'
      });
      $('.produto-slider-carousel').slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        asNavFor: '.produto-slider-principal',
        dots: false,
        focusOnSelect: true
    });

    $('.descricao-header').click(function(){
        $('.descricao-final').slideToggle();
        $('#mostrar-descricao').toggleClass('button-rotate');
    })
}


function cadastroProduto() {
    $('.cadastrar-produto-form').validate();

    $('#productPrice').mask("##0.00", {reverse: true});

    $('#productTamanho').mask("00");
}

function cadastroFornecedor() {
    $(".cadastrar-produto-form").validate();


    //telefone
    var SPMaskBehavior = function (val) {
        return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
      },
      spOptions = {
        onKeyPress: function(val, e, field, options) {
            field.mask(SPMaskBehavior.apply({}, arguments), options);
          }
      };
      $('#telefone').mask(SPMaskBehavior, spOptions);
}