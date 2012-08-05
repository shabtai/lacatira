define(["dojo/_base/declare", "dojo/_base/lang", "dojo/_base/connect","dijit/_Widget", "dojo/hash","controller/multymap","dojo/_base/array"],
    function(declare, lang, connect, testW, hash, multymap, array) {
        var fb = dojo.declare('controller.fb', null,
            {

                constructor: function(view) {
                    connect.subscribe("/dojo/hashchange", this, this.handleHashChange);
                },


                init: function () {
                    var login = dojo.byId("login");
                    connect.connect(login, "onClick", this, this.fb);

                    connect.connect(toolbar, "onClick", this, this.goToHomePage);


                },



                fb: function (data) {
                    alert("this is the best location found:" + data[0].location)
                    array.forEach(data, function(entry, i) {
                        if (entry.venue != undefined && entry.venue.city != undefined) {
                            multymap.addItem(entry, entry.venue.city)
                        }
                        console.debug(entry, "at index", i);
                    });

                    for (i in multymap.items) {
                        console.debug(i, "at index", multymap.items[i].length); // shows getMethods, but not private methods
                    }



                }





            });

        return new fb();
    });