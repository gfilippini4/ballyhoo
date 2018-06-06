var express = require("express");
var app = express();
var path = require("path");

app.get('/', function(req,res){
  res.sendFile(path.join(__dirname+'/index.html'));
});

app.get('/defualt', function(req,res){
  res.sendFile(path.join(__dirname+'/dist/defualts.css'));
});

app.get('/ballyhoo', function(req,res){
  res.sendFile(path.join(__dirname+'/dist/ballyhooTemp.jpg'));
});

app.get('/logo', function(req,res){
  res.sendFile(path.join(__dirname+'/dist/BallyhooLogo.jpg'));
});

app.get('/banner', function(req,res){
  res.sendFile(path.join(__dirname+'/dist/Banner.png'));
});


app.listen(8000);

console.log("Running on port 8000");
