var express = require('express');
var router = express.Router();
const {productos} = require("../models");


router.get('/products', function(req, res, next) {
    productos.findAll({
        where:{
            userid: parseInt(localStorage.getItem("userid"))
        }
    }).then(function(productos) {
    res.render('products', { productos: productos});
    });
   });

router.get('/newproduct', function(req, res, next) {
    res.render('newproduct');
   });

router.post('/guardar', function(req, res, next) {
    var comercio1 = req['body']['comercio'];
    var producto1 = req['body']['producto'];
    var precio1 = req['body']['precio'];
    productos.create({
        comercio: comercio1,
        producto: producto1,
        precio: precio1,
        userid: parseInt(localStorage.getItem("userid"))
    }).then(function(productos) {
        res.redirect('/products/products');
    });
});

router.get('/delete/:id', (req, res) => {

    const productId = req.params.id;
    productos.destroy({
        where: {
          id: productId
        }
      }).then(function(productos) {
        res.redirect('/products/products');
    });
});

router.get('/update/:id', (req, res) => {
    const id = req.params.id;
    productos.findOne({
        where : {id : id}
    }).then(function(result){
        console.log(result);
        if (!result) {
            res.render('products');
        }else{
            res.render('newproduct',{result});
        }
    });
});

   module.exports = router;