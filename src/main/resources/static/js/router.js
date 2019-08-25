define([ 'jquery', 'underscore', 'backbone', 'collection/EventListCollection', 'view/EventListView', 'view/EventView', 'view/EventCreationFormView' ], function ($, _, Backbone, EventListCollection, EventListView, EventView, EventCreationFormView) {
	var AppRouter = Backbone.Router.extend({
		initialize: function (options) {
			this.el = options.el;
			this.collection = options.collection;
			this.eventListView = options.eventListView;
			this.eventListView.setRouter(this);
			this.collection.comparator = function (event) {
				return event.get("id");
			};
		},
		routes: {
			"": "index",
			"events/:id": "showEvents",
			"event/create": "showEventCreationForm"
		},
		index: function () {
			this.collection.fetch();
			this.el.empty();
			this.el.append(this.eventListView.render().el);
		},
		showEvents: function (id) {
			switch (id) {
				case "all": case "Opening": case "Closed":
					this.collection.fetch({ url: "api/events/by?category=" + id });
					break;
				default:
					var eventView = new EventView({ collection: this.collection, model: this.collection.get(id) });
					eventView.setRouter(this);
					this.el.empty();
					this.el.append(eventView.render().el);
					break;
			}
		},
		showEventCreationForm: function () {
			var eventCreationFormView = new EventCreationFormView({ collection: this.collection });
			eventCreationFormView.setRouter(this);
			this.el.empty();
			this.el.append(eventCreationFormView.render().el);
		}
	});
	var initialize = function () {
		var eventListCollection = new EventListCollection();
		var eventListView = new EventListView({ collection: eventListCollection });
		var appRouter = new AppRouter({ el: $("#main"), collection: eventListCollection, eventListView: eventListView });
		var historyResult = Backbone.history.start();
		console.log("historyResult = " + historyResult);
	};
	return {
		initialize: initialize
	};
});