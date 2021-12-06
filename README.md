Stock Manager Application

A REST Application which manages the product stock in an E-Shop

This project was Done with spring boot and MySql DB

[http://localhost:8080]

###

PUT http://localhost:8080/stock/buy

###

DELETE http://localhost:8080/stock/deleteProduct/{{productId}}

###

GET http://localhost:8080/stock/findAll

###

GET http://localhost:8080/stock/geProductById/{{productId}}

###

GET http://localhost:8080/stock/getStockCapacity/{{productId}}

###

PUT http://localhost:8080/stock/refill

###

POST http://localhost:8080/stock/saveProduct

###

PUT http://localhost:8080/stock/updateProduct