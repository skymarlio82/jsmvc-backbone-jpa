requirejs.config({
	baseUrl : "js",
	map : {
		"*" : {
			"css"  : "css",
			"text" : "text"
		}
	},
	paths : {
		"jquery"                   : "lib/jquery-1.12.4",
		"bootstrap"                : "lib/bootstrap-3.0.0/js/bootstrap.min",
		"bootstrap.datepicker"     : "lib/bootstrap.datepicker/js/bootstrap.datepicker",
		"bootstrap.datetimepicker" : "lib/bootstrap.datetimepicker/js/bootstrap.datetimepicker.min",
		"modernizr"                : "lib/modernizr-2.6.2/js/modernizr",
		"underscore"               : "lib/underscore-1.3.3/js/underscore",
		"backbone"                 : "lib/backbone-0.9.2/js/backbone",
		"app"                      : "app"
	},
	shim : {
		"jquery"                   : { exports : '$' },
		"bootstrap"                : { deps : [ "jquery", "css!lib/bootstrap-3.0.0/css/bootstrap.min" ] },
		"bootstrap.datepicker"     : { deps : [ "bootstrap", "css!lib/bootstrap.datepicker/css/bootstrap.datepicker" ] },
		"bootstrap.datetimepicker" : { deps : [ "bootstrap.datepicker", "css!lib/bootstrap.datetimepicker/css/bootstrap.datetimepicker.min" ] },
		"underscore"               : { exports : '_' },
		"backbone"                 : { deps : [ "jquery", "underscore" ], exports : "Backbone" },
		"app"                      : { deps : [ "jquery", "bootstrap", "bootstrap.datepicker", "bootstrap.datetimepicker", "modernizr", "underscore", "backbone", "css!../css/style" ] }
	},
	urlArgs : "bust=" + (new Date()).getTime()
});