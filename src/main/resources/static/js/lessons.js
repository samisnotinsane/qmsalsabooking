/**
 * Controller for lessons page.
 * AUTHOR: ISLAM, Sameen
 * DATE: 07/11/2018
 */
$(document).ready(function() {

    // Init lesson times.
    $( ".lesson-time" ).each(function (index) {
        // console.log("Lesson " + index + ": " + $(this).text());
        $(this).text("NULL");

    });

    // Init lesson dates.
    $( ".lesson-date" ).each(function (index) {
        // console.log("Lesson " + index + ": " + $(this).text());
        $(this).text("NULL");
    });

    // Init lesson levels
    $( ".lesson-level" ).each(function (index) {
        $(this).text("NULL");
    });

    // Init lesson prices
    $( ".lesson-price" ).each(function(index) {
        $(this).text("NULL");
    });

    // Init lesson type
    $( ".lesson-type" ).each(function(index) {
        $(this).text("NULL");
    });

    $.get( "/api/lesson/retrieve", function ( data ) {

        var i=0;
        $( ".lesson-date" ).each(function ( index ) {
            $(this).text(data[i].date);
            i++;
        });

        var j=0;
        $( ".lesson-time" ).each(function ( index ) {
            $(this).text(data[j].startTime);
            j++;
        });

        var k=0;
        $( ".lesson-level" ).each(function (index) {
           $(this).text(data[k].level);
           k++;
        });

        var l=0;
        $( ".lesson-price" ).each(function (index) {
            $(this).text("£" + data[l].price + ".00");
            l++;
        });

        var m=0;
        $( ".lesson-type" ).each(function (index) {
            $(this).text(data[m].type);
            m++;
        });

        console.log(data);
    });

});

// Attach 'submit' handler to form.
$( "#form-add-lesson" ).submit(function (event) {

    event.preventDefault(); // stop form from submitting normally.

    /* Get the action attribute from the <form action=""> element */
    var $form = $( this ),
        url = $form.attr( "action" );

    /* Send the data using POST */
    var posting = $.post( url, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        date: $( '#date' ).val(),
        startTime: $( '#time' ).val(),
        venue: $( '#venue' ).val(),
        level: $( '#level' ).val(),
        type: "Everyone"
    });

    posting.done(function ( data ) {
        alert( 'Lesson created.' );
    });

});