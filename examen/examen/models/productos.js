'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class productos extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      productos.belongsTo(models.usuario);
      models.usuario.hasMany(productos);
    }
  }
  productos.init({
    comercio: DataTypes.STRING,
    producto: DataTypes.STRING,
    precio: DataTypes.INTEGER,
    usuarioId: DataTypes.INTEGER
  }, {
    sequelize,
    modelName: 'productos',
  });
  return productos;
};