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