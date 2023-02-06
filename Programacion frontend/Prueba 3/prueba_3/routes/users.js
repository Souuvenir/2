var express = require('express');
var router = express.Router();
const {users} = require("../models");

//router.get('/users', function(req, res, next) {
//res.render('users');
//});


router.get('/users', function(req, res, next) {
    users.findAll({}).then(function(usersRespuesta) {
    res.render('users', { users: usersRespuesta });
    });
   });

router.get('/users/delete/:id', (req, res) => {

    const userId = req.params.id;
    users.destroy({
        where: {
          id: userId
        }
      }).then(function(register) {
        res.redirect('/users/users');
    });
});


router.get('/users/update/:id', (req, res) => {
    const id = req.params.id;
    users.findOne({
        where : {id : id}
    }).then(function(result){
        console.log(result);
        if (!result) {
            res.render('users');
        }else{
            res.render('register',{result});
        }
    });
});

router.get('/chat', function(req, res, next) {
    res.jsonp({Error : "Trabajo en proceso"})
  });

module.exports = router;
