/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$.validator.setDefaults({
    submitHandler: function () {
        alert("submitted!");
    }
});
$().ready(function () {
    // validate the comment form when it is submitted
    $("#commentForm").validate();
    // validate signup form on keyup and submit
    $("#signupForm").validate({
        rules: {
            idPERSONAS: {
                required: true,
                 number:true,
            },
            nombres: "required",
            apellidos: "required",
            telefonos: "required",
            password: {
                required: true,
                minlength: 5
            },
            conPassword: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            },
            correoe: {
                required: true,
                email: true
            }
        },
        messages: {
            idPERSONAS: "Es necesaria tu numero de cedula",
            nombres: "Por favor ingresa tus nombres",
            apellidos: "Por favor ingresa tus apellidos",
            telefonos: "Tu numero es necesario",
            password: {
                required: "Ingresa una contraseña",
                minlength: "Minimo 5 caracteres"
            },
            conPassword: {
                required: "Por favor valida tu contraseña",
                minlength: "Minimo 5 caracteres",
                equalTo: "Las contraseñas no son iguales"
            },
            correoe: "Correo invalido",
        }
    });
});

