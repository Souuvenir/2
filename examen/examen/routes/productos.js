var express = require('express');
var router = express.Router();
const {productos} = require("../models");

router.get('/', function(req, res, next) {
    productos.findAll({
      where:{
        usuarioId: parseInt(localStorage.getItem("iduser"))?parseInt(localStorage.getItem("iduser")):1
    }
    }).then(function(response) {
      console.log(response);  
      res.render('productos', { response});
    });
});

router.post('/new', function(req, res, next) {
    console.log(req['body']);
    productos.create({
        producto: req['body']['producto'],
        comercio: req['body']['comercio'],
        precio: req['body']['precio'],
        usuarioId: parseInt(localStorage.getItem("iduser"))?parseInt(localStorage.getItem("iduser")):1
    }).then(function(productos) {
        res.redirect('/productos');
    });
});
router.get('/delete/:id', async function(req, res, next) {
    await productos.destroy({where: {id: req.params.id}}).then(function() {
      res.redirect('/productos');
  });
});

router.post('/update/:id', async function(req, res, next) {
    const upd = await productos.update( { comercio: req.body.comercio,producto: req.body.producto, precio: req.body.precio }, 
      { where: { id: req.params.id} }
    );
    console.log(upd);
    if (upd != undefined && upd != null) {
      res.redirect('/productos');    
    }else{
      res.render('errorscreen');
    }
  });
module.exports = router;
  