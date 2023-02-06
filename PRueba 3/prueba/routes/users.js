var express = require('express');
var router = express.Router();
const {login} = require("../models");
/* GET users listing. */

router.get('/userslist', function(req, res, next) {
  login.findAll({}).then(function(response) {
  res.render('users', { response});
  });
 });

 router.get('/modify/:id', function(req, res, next) {
  login.findAll({where: {id: req.params.id}}).then(function(login) {
  console.log(login);
  const info = login[0].dataValues;
  res.render('modify', {info});
  });
 });

router.get('/delete/:id', async function(req, res, next) {
    await login.destroy({where: {id: req.params.id}}).then(function() {
      res.redirect('/users/userslist');
  });
});

router.post('/update/:id', async function(req, res, next) {
  const upd = await login.update( { username: req.body.username,password: req.body.password, email: req.body.email }, 
    { where: { id: req.params.id} }
  );
  console.log(upd);
  if (upd != undefined && upd != null) {
    res.redirect('/users/userslist');    
  }else{
    res.render('errorscreen');
  }
});


module.exports = router;
