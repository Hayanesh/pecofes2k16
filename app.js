

var firebase = require("firebase");
var config = {
  apiKey: "AIzaSyDcy6ngK7yTX6HzYVg7QdASw-2ddsOJlyE",
  authDomain: "pecofes-50edf.firebaseapp.com",
  databaseURL: "https://pecofes-50edf.firebaseio.com",
  storageBucket: "pecofes-50edf.appspot.com",
};
firebase.initializeApp(config);
var ref = firebase.database().ref();





  /* console.log("Key"+data.key);
   console.log("Email: "+ newPlayer.Email);
   console.log("Event :"+ newPlayer.Event);
   console.log("Name :"+ newPlayer.Name);
   console.log("Phone :"+newPlayer.Phone);
   console.log("Team :"+ newPlayer.team);*/

   //console.log(rec);
   // var rec= {id:1,FBkey: data.key, event: newPlayer.Event, email: newPlayer.Email ,name:newPlayer.Name,phone:newPlayer.Phone,team: newPlayer.team };
  rec = [];
  ref.on("child_added",function(data,prevChildkey){
    //DB part
    var mysql  = require('mysql');

    var dbconn = mysql.createConnection({
      host     : 'localhost',
      user     : 'root',
      password : '',
      database : 'firebasedb'
    });

    dbconn.connect(function(err){
    });

    var newPlayer = data.val();
    var rec = {FBkey: data.key, event: newPlayer.Event, email: newPlayer.Email ,name:newPlayer.Name,phone:newPlayer.Phone,team: newPlayer.team };
    dbconn.query('INSERT INTO participants SET ?', rec, function(err,res){
      if(err) throw err;
      else {
        console.log("Inserting record:"+res.insertId);
      }
      });

    dbconn.end(function(err) {
        // Function to close database connection
    });

  });
  //console.log(global.rec);
  // var rec= {id:1,FBkey: '1234', event: 'snapshot', email: 'email@email.com' ,name:'Hayanesh',phone:'12121212',team: 'NIL' };
   //dbconn.query('INSERT INTO participants SET ?', rec, function(err,res){
  //   if(err) throw err;
  // });
