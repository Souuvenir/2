var express = require('express');
var router = express.Router();
const { usuario } = require("../models");



router.get('/', function(req, res, next) {
    res.render('registrar', {});
});

router.get('/listado', function(req, res, next) {
    usuario.findAll({}).then(function(usuarios) {
        res.render('listadoUsuarios', { usuarios });
    });
});

router.get('/editar/:id', async function(req, res, next) {
    const usuario1 = await usuario.findByPk(req.params.id);
    res.render('registrar', {usuario1});
});

router.post('/registrar', function(req, res, next) {
    console.log(req.body);
    usuario.create({
        usuario: req.body.usuario,
        contrasenia: req.body.contrasenia,
        correo: req.body.correo
        }).then(function(usuario) { res.redirect('/usuario/listado');
    });
});

router.post('/actualizar/:id', async function(req, res, next) {
    console.log(req.body);
    await usuario.update(
        {
            usuario: req.body.usuario,
            contrasenia: req.body.contrasenia,
            correo: req.body.correo
        }, 
        {
            where: {
                id: req.params.id
            }
        }
        ).then(function(usuario) { res.redirect('/usuario/listado');
    });
});

router.get('/eliminar/:id', async function(req, res, next) {
    let usu = await usuario.findOne({where: {id: req.params.id}}).catch(e => {
        console.log(e.message)
    });
    if (!usu){
        console.log("err");
    }
    usu.destroy();
    res.redirect('/usuario/listado');
});

module.exports = router;