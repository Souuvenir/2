var express = require('express');
var router = express.Router();
const {login} = require("../models");


router.get('/', function(req, res, next) {
  res.render('index');
});

router.get('/login', async function(req, res, next) {
  let log;
  let email = req.query.email;
  let password = req.query.password;
  let filter;
  log = await login.findAll({});
  
  filter = log.filter(login=> login.dataValues.email == email && login.dataValues.password == password); 

  console.log(filter);

  if (filter.length > 0) {
    res.redirect('/users/userslist');
  }else{
    res.render('errorscreen');
  }
});

module.exports = router;
