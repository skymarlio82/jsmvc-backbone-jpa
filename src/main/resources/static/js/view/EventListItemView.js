
define([ 'jquery', 'underscore', 'backbone', 'text!template/eventListItemTemplate.htm' ], function ($, _, Backbone, eventListItemTemplate) {
	var EventListItemView = Backbone.View.extend({
		tagName : "tr",
		setRouter : function (router) {
			this.router = router;
		},
		events : {
			"click .eventClose" : "closeEvent",
			"click .eventDelete" : "deleteEvent"
		},
		render : function () {
			console.log("tracing in EventListItemView.render : ", arguments);
			this.$el.html(_.template(eventListItemTemplate, { event : this.model }));
			return this;
		},
		closeEvent : function (e) {
			e.preventDefault();
			var dm = this.model.set({ status : "Closed" }, { validate : true });
			console.log(dm);
			this.model.save();
//			this.model.save({ status : "Closed" }, {
//				success : function (model, response) {
//					console.log(model, response);
//				}, error: function (model, response) {
//					console.log(model, response);
//				}
//			});
		},
		deleteEvent : function (e) {
			e.preventDefault();
			this.model.destroy();
		}
	});
	return EventListItemView;
});
