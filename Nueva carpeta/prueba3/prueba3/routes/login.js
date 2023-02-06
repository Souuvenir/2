var express = require('express');
var router = express.Router();
const { usuario } = require("../models");

router.get('', function(req, res, next) {
    res.render('login', {});
});

router.get('/log', async function(req, res, next) {
    let usu = req.query.usuario;
    let con = req.query.contrasenia;
    let resu = [];
    if(usu && con){
        resu = await usuario.findAll({
            where: {
                usuario: usu ? usu : null,
                contrasenia: con ? con : null
            }
        });
    }
    console.log(resu[0]);
    if(resu[0] != undefined && resu[0].dataValues != undefined) {
        res.redirect('/usuario/listado');
    } else {
        res.redirect('/');
    }
});


module.exports = router;