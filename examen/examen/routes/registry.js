var express = require('express');
var router = express.Router();
const {usuario} = require("../models");

router.get('/', function(req, res, next) {
    res.render('registry');
  });

router.post('/save', function(req, res, next) {
    console.log(req['body'],'hola');
    usuario.create({
        usuario: req['body']['username'],
        contrasena: req['body']['password'],
        nombre: req['body']['name'],
    }).then(function(registry) {
        res.redirect('/');
    });
});
  module.exports = router;
  