define([ 'jquery', 'underscore', 'backbone', 'view/EventListItemView', 'text!template/eventListTemplate.htm' ], function ($, _, Backbone, EventListItemView, eventListTemplate) {
	var EventListView = Backbone.View.extend({
		initialize : function (options) {
			this.collection = options.collection;
			_.bindAll(this, "render");
			this.collection.bind("all", this.render);
		},
		setRouter : function (router) {
			this.router = router;
		},
		render : function () {
			console.log("tracing in EventListView.render : ", arguments);
			this.$el.html(_.template(eventListTemplate, { events : this.collection.models }));
			this.collection.each(this.appendEvent);
			console.log("mapToTitles = ", this.collection.map(this.mapToTitles));
			console.log("filterByStatus = ", this.collection.filter(this.filterByStatus));
			console.log("sortByOwner = ", this.collection.sortBy(this.sortByOwner));
			return this;
		},
		appendEvent : function (model) {
			var eventListItemView = new EventListItemView({ model : model });
			eventListItemView.setRouter(this);
			this.$(".eventListContent").append(eventListItemView.render().el);
		},
		mapToTitles : function (model) {
			return model.get("title");
		},
		filterByStatus : function (model) {
			return model.get("status") === "Opening";
		},
		sortByOwner : function (model) {
			return model.get("owner").toLowerCase();
		}
	});
	return EventListView;
});