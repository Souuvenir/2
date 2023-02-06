var express = require('express');
var router = express.Router();
const {usuario} = require("../models");
var LocalStorage = require('node-localstorage').LocalStorage;
localStorage = new LocalStorage('./scratch');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index');
});

router.get('/login', async function(req, res, next) {
  let log;
  let user = req.query.username;
  let password = req.query.password;
  let filter;

  log = await usuario.findAll({});
  filter = log.filter(login=> login.dataValues.usuario == user && login.dataValues.contrasena == password);
  console.log(filter[0].dataValues.id, "aqui");
  let iduser = filter[0].dataValues.id;
  localStorage.setItem("iduser", iduser);

  if (filter.length > 0) {
    res.redirect('/productos/');
  }else{
    res.render('errorscreen');
  }
});


module.exports = router;
