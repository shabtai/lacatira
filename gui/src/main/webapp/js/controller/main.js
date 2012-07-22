define(["dojo/_base/declare", "dojo/_base/lang", "dojo/_base/connect","dijit/_Widget", "dojo/hash"],
        function(declare, lang, connect,testW,hash)
{
    var main = dojo.declare('controller.main', null ,
    {

        constructor: function(view) {
            connect.subscribe("/dojo/hashchange", this, this.handleHashChange);
        },

        handleHashChange: function(hashString) {
//            eventsMenuBar.updateMenuItemSelection(hashString);

            // hashchange event!
            switch (hashString) {
                case "home":
                    this.goToHomePage();
                    break;
                case "events":
                    this.goToEventListPage();
                    break;

                default:
                    // in case we're in the events flow
                    if(hashString.indexOf("events=") === 0){
                        if (!this.roleFlowPage){
                            hash("events");
                        }
                    }
                    else {
                        hash("home");
                    }
                    break;
            }
        },

        init: function () {
            this.centralAreaContainer = dijit.byId("centralAreaStack");


            connect.connect(toolbar, "onClick", this, this.goToHomePage);


            this.handleHashChange(hash());
        },

        goToEventListPage:function (page, params) {
        },




        goToHomePage: function() {
            if (hash() !== "home") {
                hash("home");
            } else {
                if (this.homePage) {
                    this.homePage.destroyRecursive(true);
                }
//                    this.homePage = new HomePageForm();
                this.createNewPage(this.homePage);
            }
        },


        createNewPage: function(content) {
        }



    });

    return new main();
});