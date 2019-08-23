// The "app" dependency is passed in as "App". Again, the other dependencies passed in are not "AMD" therefore don't pass a parameter to this function
requirejs([ "common" ], function (common) {
	requirejs([ "app" ], function (app) {
		app.initialize();
	});
});
