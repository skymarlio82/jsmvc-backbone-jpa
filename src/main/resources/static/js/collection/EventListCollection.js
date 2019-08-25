define([ 'underscore', 'backbone', 'model/EventModel' ], function (_, Backbone, EventModel) {
	var EventListCollection = Backbone.Collection.extend({
		url : "api/events",
		model : EventModel
	});
	return EventListCollection;
});