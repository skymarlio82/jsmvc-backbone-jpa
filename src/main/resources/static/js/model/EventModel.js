define([ "underscore", "backbone" ], function (_, Backbone) {
	var EventModel = Backbone.Model.extend({
		validate : function (attrs) {
			var error = null;
			if (typeof(attrs.title) === undefined || attrs.title == null || attrs.title == "") {
				error = "Event title required.";
			}
			if (typeof(attrs.description) === undefined || attrs.description == null || attrs.description == "") {
				error = "Event description required.";
			}
			if (typeof(attrs.owner) === undefined || attrs.owner == null || attrs.owner == "") {
				error = "Event owner required.";
			}
			if (error != null) {
				return error;
			}
		}
	});
	return EventModel;
});