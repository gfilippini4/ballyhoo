var fs = require('fs');

var links = ['https://local.theonion.com/construction-crew-arguing-over-who-gets-to-use-the-fun-1825853784',
  'https://www.cnn.com/2018/05/14/us/border-patrol-migrant-death-count-invs/index.html',
  'https://www.cnn.com/2018/05/11/us/chicago-gun-share-program/index.html',
  'http://money.cnn.com/2018/05/13/technology/business/trump-zte-corporation-china-commerce/index.html']

var mysql = require('mysql');

var con = mysql.createConnection({
  host: "127.0.0.1",
  port: "3309",
  user: "garrett",
  password: "password"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});

var {
	extract
} = require('article-parser');
for(var i = 0; i < links.length; i++) {

  let url = links[i];

  extract(url).then((article) => {

    fs.writeFile(article.title, 'CONTENT: ' + article.content + '\n\n' + 'AUTHOR: ' +
      article.author + '\n\n' + 'URL: ' + article.url, function (err) {
      if (err) throw err;
      console.log('Saved!');
    });

  }).catch((err) => {
	 console.log(err);
  });
}
