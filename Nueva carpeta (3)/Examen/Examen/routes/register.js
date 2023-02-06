var express = require('express');
var router = express.Router();
const {users} = require("../models");

router.get('/register', function(req, res, next) {
    res.render('register');
});

module.exports = router;

router.post('/guardar', function(req, res, next) {
    console.log("hola guardop", req.body.mail);
    var usern = req['body']['username'];
    var pass = req['body']['password'];
    var email = req['body']['mail'];
    users.create({
        username: usern,
        password: pass,
        mail: email,
    }).then(function(register) {
        res.redirect('/');
    });
});