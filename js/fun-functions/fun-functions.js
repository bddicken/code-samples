/* 
** A bunch of random and fun functions to run on webpages. These functions
** do not assume the use of any libraries such as jQuery.
**
** @author Benjamin Dicken
*/

/*
** This function replaces every image in am <img> tag to the image at the 
** passed-in URL.
**
** @param fullImgURL : The URL of the image to replace all other
**                     images with.
*/
var repl = function replaceImgTagsOnPage(fullImgURL){
    var d = document.getElementsByTagName('img');
    for(var i=0; i < d.length; i++)
        d[i].src = fullImgURL;
}

/*
** Change the color on a timer, disco style - lets boogie.
*/
var disco = function setRandomBgColorsTimer(interval){
    window.setInterval( function(){colors()}, interval );
}

/*
** Changes the background color of every element on a page to some randomly 
** generated color.
*/
var colors = function setRandomBgColors() {
    var e = document.getElementsByTagName("*");
    for(var i=0; i < e.length; i++) {
        e[i].style.backgroundColor = 
	'#'+Math.floor(Math.random()*16777215).toString(16);
    }
}

/*
** Makes all of the font on a webpage REALLY big.
**
** @param sizeInPX : The size to change the text on the page to
**                   in pixels.
*/
var big_text = function makeAllTextBig(sizeInPX) {
    var e = document.getElementsByTagName("*");
    for(var i=0; i < e.length; i++) {
        e[i].style.fontSize = sizeInPX+'px';
    }
}

/*
** White out backgrounds and text on the page.
*/
var whiteOut = function setInvertedColors() {
    var e = document.getElementsByTagName("*");
    for(var i=0; i < e.length; i++) {
        e[i].style.backgroundColor = '#'+Math.abs(16777215).toString(16);
        e[i].style.color = '#'+Math.abs(16777215).toString(16);
    }
}
