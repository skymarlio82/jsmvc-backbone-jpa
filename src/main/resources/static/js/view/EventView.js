define([ 'jquery', 'underscore', 'backbone', 'text!template/eventTemplate.htm' ], function ($, _, Backbone, eventTemplate) {
	var EventView = Backbone.View.extend({
		initialize : function (options) {
			this.collection = options.collection
			this.model = options.model;
			this.model.bind('all', this.render, this);
			this.model.bind("error", function (m, error) {
				alert(error);
			});
		},
		setRouter : function (router) {
			this.router = router;
		},
		events : {
			"click #edit-btn" : "setFormEditable",
			"click #save-btn" : "saveEventDetail"
		},
		render : function () {
			console.log("tracing in EventView.render : ", arguments);
			this.$el.html(_.template(eventTemplate, { event : this.model }));
			this.$(".datePicker").datepicker({ autoclose : true });
			return this;
		},
		setFormEditable : function (e) {
			e.preventDefault();
			this.model.set({ formEditable : true });
			console.log("model.url = " + this.model.url());
			this.model.save();
		},
		saveEventDetail : function (e) {
			e.preventDefault();
			this.model.set({ title : this.$("#eventTitle").val() }, { silent : true });
			console.log("model's previous title = " + this.model.previous("title"));
			this.model.set({ description : this.$("#eventDesc").val() }, { silent : true });
			this.model.set({ start : this.$("#eventStart").val() }, { silent : true });
			this.model.set({ end : this.$("#eventEnd").val() }, { silent : true });
			this.model.set({ owner : this.$("#eventOwner").val() }, { silent : true });
			this.model.change();
			this.model.save();
			var res = confirm("Are you sure of redirecting to home page?");
			if (res == true) {
				console.log("model's previous attributes = ", this.model.previousAttributes());
				console.log("model.toJSON = ", this.model.toJSON());
				window.location.replace("/");
				// this.router.navigate("/", true);
			}
		}
	});
	return EventView;
});