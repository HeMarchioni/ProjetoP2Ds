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
    $('.cadastrar-produto-form').validate({
        rules: {
            productName: {
                required: true,
                maxlength: 50,
               
            },
            productCategory: {
                required: true,
                maxlength: 20,
               
            },
            productDescription: {
                required: true,
                maxlength: 200,
               
            },
            productPrice: {
                required: true,
                maxlength: 20,
               
            },
        }, 
        messages: {
            productName: {
                required: 'Preencha este campo.',
                maxlength: 'Esse campo tem um limite de 50 caractéres.'
            },
            productCategory: {
                required: 'Preencha este campo.',
                maxlength: 'Esse campo tem um limite de 20 caractéres.'
            },  
            productDescription: {
                required: 'Preencha este campo.',
                maxlength: 'Esse campo tem um limite de 200 caractéres.'
            },  
            productPrice: {
                required: 'Preencha este campo.',
                maxlength: 'Esse campo tem um limite de 20 caractéres.'
            },  
        }
    });

    $('#productPrice').mask("##0.00", {reverse: true});
}

function cadastroFornecedor() {
    $('.cadastrar-produto-form').validate({
        rules: {
            fornecedor: {
                required: true,
                maxlength: 50,
            },
            fornecido: {
                required: true,
                maxlength: 50,
            },
            descricao: {
                required: true,
                maxlength: 200,
            },
            contato: {
                required: true,
                maxlength: 50,
            },
            telefone: {
                required: true,
                maxlength: 15,
                minlength: 14,
            },
            email: {
                required: true,
                maxlength: 100,
                email: true
            },

        },
        messages: {
            fornecedor: {
                required: 'Preencha esse campo.',
                maxlength: 'Esse campo aceita no máximo 50 caractéres'
            },
            fornecido: {
                required: 'Preencha esse campo.',
                maxlength: 'Esse campo aceita no máximo 50 caractéres'
            },
            descricao: {
                required: 'Preencha esse campo.',
                maxlength: 'Esse campo aceita no máximo 200 caractéres'
            },
            contato: {
                required: 'Preencha esse campo.',
                maxlength: 'Esse campo aceita no máximo 50 caractéres'
            },
            telefone: {
                required: 'Preencha esse campo.',
                maxlength: 'Insira um telefone válido.',
                minlength: 'Insira um telefone válido.',
            },
            email: {
                required: 'Preencha esse campo.',
                maxlength: 'Esse campo aceita no máximo 100 caractéres',
                email: 'Digite um email válido'
            },
        }
    })

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