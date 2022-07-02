$(document).ready(function () {
    listar();
});
function listar() {
    $.ajax({
        url: "/autor/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            x.forEach((item, index, array) => {
                $("#tablita").append(
                        "<tr><td>" + (index + 1) + "</td><td>" + item.id + "</td><td>" + item.nombres
                        + "</td><td>" + item.apellidos + "</td><td>" + item.estado + "</td><td><a href='#' onclick='editar("
                        + item.id + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + item.id + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");

            });
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/autor/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombres").val(w.nombres);
            $("#editar_apellidos").val(w.apellidos);
            $("#editar_id").val(w.id);
        }
    });
    $("#editarModal").modal('show');
}
function eliminar(id) {
    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/autor/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}
let foto= new Object();
$("#foto").change(function (e) {
    foto = e.target.files[0].name;

});

$("#guardar").click(function () {
    let nombre = $("#nombres").val();
    let apellido = $("#apellidos").val();
    let estado = false;
    $("input[type=checkbox]:checked").each(function () {
        estado = true;
    });
    //alert(foto)
     $.ajax({
     url: "/autor/add",
     type: 'POST',
     contentType: "application/json; charset=utf-8",
     data: JSON.stringify({'nombres': nombre, 'apellidos': apellido, 'estado':estado, 'foto':foto}),
     cache: false,
     success: function (w) {
     bootbox.alert({
     message: "Registro guardado correctamente...!",
     callback: function () {
     console.log('This was logged in the callback!');
     }
     });
     limpiar();
     listar();
     }
     });
    $("#exampleModal").modal('hide');
});
function limpiar() {
    $("#nombres").val("");
    $("#apellidos").val("");
}
$("#modificar").click(function () {
    var nombres = $("#editar_nombres").val();
    var apellidos = $("#editar_apellidos").val();
    var id = $("#editar_id").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/autor/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'id': id, 'nombres': nombres, 'apellidos': apellidos}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#editarModal").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});
