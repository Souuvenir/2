var express = require('express');
var router = express.Router();
const {users} = require("../models");
var LocalStorage = require('node-localstorage').LocalStorage;
localStorage = new LocalStorage('./scratch');


router.get('/', function(req, res, next) {
  res.render('index');
});


router.post('/login', async function(req, res, next) {
  let user;
  let pas;

  user = await users.findOne({ where: { username : req.body.username } });
  pas = await users.findOne({ where: { password : req.body.password } });
  console.log(typeof user,pas);
  if (user != null && pas != null) {
    if(user.dataValues != null && pas.dataValues != null){
      localStorage.setItem("userid",user.id);
      console.log(localStorage.getItem("userid"));
      res.redirect('/products/products');
      }
  } else{
    res.jsonp({Error : "Usuario y/o contrasena incorrecta"})
  }
});


module.exports = router;
