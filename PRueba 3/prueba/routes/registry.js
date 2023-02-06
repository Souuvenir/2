var express = require('express');
var router = express.Router();
const {login} = require("../models");

router.get('/', function(req, res, next) {
    res.render('registry');
  });
router.post('/save', function(req, res, next) {
    
    login.create({
        username: req['body']['username'],
        password: req['body']['password'],
        email: req['body']['email'],
    }).then(function(registry) {
        res.redirect('/');
    });
});

module.exports = router;

