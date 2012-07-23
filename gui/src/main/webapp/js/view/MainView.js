define(["dijit/_Widget", "dijit/_TemplatedMixin", "dijit/_WidgetsInTemplateMixin",
	        "dojo/_base/declare", "view/Menu", "dojo/text!view/MainView.html"],
			function(_Widget, _TemplatedMixin, _WidgetsInTemplateMixin, declare, Menu, template)
{
	 return declare("view.MainView", [_Widget, _TemplatedMixin, _WidgetsInTemplateMixin], {
		
		templateString: template,
		widgetsInTemplate: true,
		
		create: function (a, b) {
			this.inherited(arguments);
		}
		
	 });
});
