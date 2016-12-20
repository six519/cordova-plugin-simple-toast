Supported Platform
==================

Android Only

Installation
============

``cordova plugin add https://github.com/six519/cordova-plugin-simple-toast.git``

or via npm

``cordova plugin add cordova-plugin-simple-toast``

Usage
=====
::

    window.simpleToastPlugin.show("hello world", 0, function(e){
        //success callback
    }, function(e){
        //error callback
    });