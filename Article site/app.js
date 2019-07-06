//jshint esversion:6

const express = require("express");
const bodyParser = require("body-parser");
const ejs = require("ejs");
var lod = require('lodash');
const homeStartingContent = "Artificial intelligence (AI) is the simulation of human intelligence processes by machines, especially computer systems. These processes include learning (the acquisition of information and rules for using the information), reasoning (using rules to reach approximate or definite conclusions) and self-correction. Particular applications of AI include expert systems, speech recognition and machine vision.";
const aboutContent = "Hac habitasse platea dictumst vestibulum rhoncus est pellentesque. Dictumst vestibulum rhoncus est pellentesque elit ullamcorper. Non diam phasellus vestibulum lorem sed. Platea dictumst quisque sagittis purus sit. Egestas sed sed risus pretium quam vulputate dignissim suspendisse. Mauris in aliquam sem fringilla. Semper risus in hendrerit gravida rutrum quisque non tellus orci. Amet massa vitae tortor condimentum lacinia quis vel eros. Enim ut tellus elementum sagittis vitae. Mauris ultrices eros in cursus turpis massa tincidunt dui.";
const contactContent = "Scelerisque eleifend donec pretium vulputate sapien. Rhoncus urna neque viverra justo nec ultrices. Arcu dui vivamus arcu felis bibendum. Consectetur adipiscing elit duis tristique. Risus viverra adipiscing at in tellus integer feugiat. Sapien nec sagittis aliquam malesuada bibendum arcu vitae. Consequat interdum varius sit amet mattis. Iaculis nunc sed augue lacus. Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing elit. Pulvinar elementum integer enim neque. Ultrices gravida dictum fusce ut placerat orci nulla. Mauris in aliquam sem fringilla ut morbi tincidunt. Tortor posuere ac ut consequat semper viverra nam libero.";

var posts=[];
const app = express();

app.set('view engine', 'ejs');

app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static("public"));

app.get("/",function(req,res){
//  console.log(posts);
  res.render("home",{starting:homeStartingContent,arr:posts});
//  res.render("home")
});

app.get("/posts/:topic",function(req,res){
  const name=(req.params.topic);
//  console.log(name);
 var nname=lod.lowerCase(name);
  posts.forEach(function(post){
    const stored=lod.lowerCase(post.p_title);
  if(nname=== stored)
  res.render("post",{title:stored,posst:post.p_post});
});
});

app.get("/contact",function(req,res){
  res.render("contact",{content2:contactContent});
//  res.render("home")
});

app.get("/about",function(req,res){
  res.render("about",{content3:aboutContent});
//  res.render("home")
});

app.get("/compose",function(req,res){
  res.render("compose");
//  res.render("home")
});

app.post("/compose",function(req,res){
  let item1=req.body.title;
  let item2=req.body.post;
//  items.push(item);
//  res.redirect("/");
 let obj={p_title:item1,p_post:item2};
posts.push(obj);
res.redirect("/");
//console.log(item2);
});



app.listen(3000, function() {
  console.log("Server started on port 3000");
});
