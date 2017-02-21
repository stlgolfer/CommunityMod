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
        try {
                var contents = fs.readFileSync("chat.txt", 'utf-8').toString();
                res.end(contents);
				console.log("Request Served!");
        }
        catch (Exception) {
                console.log("Can't read chat file!");
                res.end("Server error!");
        }
});

app.post('/chat/send', function (req, res) {
	// send params to the chat file
        var player = req.body.player;
        var message = req.body.message;
        var stringReady = "\n<" + player + ">: " + message;

        fs.writeFile("chat.txt", stringReady, function (err) {
                if (!err) {
                        console.log("Written to file!");
                }
                else {
                        console.log("Error writing to file!");
                }
        });
});

// start server
app.listen(port, function() {
	console.log("Server Online!");
});
