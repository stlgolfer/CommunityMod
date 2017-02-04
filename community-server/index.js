var express = require('express');
var bodyParser = require('body-parser');
var fs = require('fs');

var app = new express();
var port = 1600;


// CORS and body-parser
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
app.use( bodyParser.json() );       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
}));

app.get('/chat/get', function (req, res) {
	// get chat and return the data from the file
});

app.post('/chat/send', function (req, res) {
	// send params to the chat file
});

// start server
app.listen(port, function() {
	console.log("Server Online!");
});