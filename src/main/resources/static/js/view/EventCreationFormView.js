define([ 'jquery', 'underscore', 'backbone', 'collection/EventListCollection', 'text!template/eventCreationFormTemplate.htm' ], function ($, _, Backbone, EventListCollection, eventCreationFormTemplate) {
	var EventCreationFormView = Backbone.View.extend({
		initialize : function (options) {
			this.collection = options.collection;
		},
		setRouter : function (router) {
			this.router = router;
		},
		events : {
			"click #submit-btn" : "submitEventDetail"
		},
		render : function () {
			console.log("tracing in EventCreationFormView.render : ", arguments);
			this.$el.html(eventCreationFormTemplate);
			this.$(".datePicker").datepicker({ autoclose : true });
			return this;
		},
		submitEventDetail : function (e) {
			e.preventDefault();
			this.collection.create({ title : this.$("#eventTitle").val(), description : this.$("#eventDesc").val(), start : this.$("#eventStart").val(), end : this.$("#eventEnd").val(), owner : this.$("#eventOwner").val() });
			var res = confirm("Are you sure of redirecting to home page?");
			if (res == true) {
				window.location.replace("/");
				// this.router.navigate("/", true);
			}
		}
	});
	return EventCreationFormView;
});