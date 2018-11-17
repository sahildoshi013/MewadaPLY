/*
 * Author: Abdullah A Almsaeed
 * Date: 4 Jan 2014
 * Description:
 *      This is a demo file used only for the main dashboard (index.html)
 **/

$(function () {

  "use strict";





  //Make the dashboard widgets sortable Using jquery UI
  $(".connectedSortable").sortable({
    placeholder: "sort-highlight",
    connectWith: ".connectedSortable",
    handle: ".box-header, .nav-tabs",
    forcePlaceholderSize: true,
    zIndex: 999999
  });
  $(".connectedSortable .box-header, .connectedSortable .nav-tabs-custom").css("cursor", "move");

  //bootstrap WYSIHTML5 - text editor
  $(".textarea").wysihtml5();

  
  /* jQueryKnob */
  $(".knob").knob();

  // //jvectormap data
  // var visitorsData = {
  //   "US": 398, //USA
  //   "SA": 400, //Saudi Arabia
  //   "CA": 1000, //Canada
  //   "DE": 500, //Germany
  //   "FR": 760, //France
  //   "CN": 300, //China
  //   "AU": 700, //Australia
  //   "BR": 600, //Brazil
  //   "IN": 800, //India
  //   "GB": 320, //Great Britain
  //   "RU": 3000 //Russia
  // };
  // //World map by jvectormap
  // $('#world-map').vectorMap({
  //   map: 'world_mill_en',
  //   backgroundColor: "transparent",
  //   regionStyle: {
  //     initial: {
  //       fill: '#e4e4e4',
  //       "fill-opacity": 1,
  //       stroke: 'none',
  //       "stroke-width": 0,
  //       "stroke-opacity": 1
  //     }
  //   },
  //   series: {
  //     regions: [{
  //       values: visitorsData,
  //       scale: ["#92c1dc", "#ebf4f9"],
  //       normalizeFunction: 'polynomial'
  //     }]
  //   },
  //   onRegionLabelShow: function (e, el, code) {
  //     if (typeof visitorsData[code] != "undefined")
  //       el.html(el.html() + ': ' + visitorsData[code] + ' new visitors');
  //   }
  // });

  /* Morris.js Charts */
  // Sales chart

  // var area = new Morris.Area({
  //   element: 'revenue-chart',
  //   resize: true,
  //   data: [
  //     {y: '2011 Q1', item1: 2666, item2: 2666, item3: 2234},
  //     {y: '2011 Q2', item1: 2778, item2: 2294},
  //     {y: '2011 Q3', item1: 4912, item2: 1969},
  //     {y: '2011 Q4', item1: 3767, item2: 3597},
  //     {y: '2012 Q1', item1: 6810, item2: 1914},
  //     {y: '2012 Q2', item1: 5670, item2: 4293},
  //     {y: '2012 Q3', item1: 4820, item2: 3795},
  //     {y: '2012 Q4', item1: 15073, item2: 5967},
  //     {y: '2013 Q1', item1: 10687, item2: 4460},
  //     {y: '2013 Q2', item1: 8432, item2: 5713}
  //   ],
  //   xkey: 'y',
  //   ykeys: ['item1', 'item2', 'item3'],
  //   labels: ['Item 1', 'Item 2', 'Item3'],
  //   lineColors: ['#a0d0e0', '#3c8dbc'],
  //   hideHover: 'auto'
  // });
  // var line = new Morris.Line({
  //   element: 'line-chart',
  //   resize: true,
  //   data: [
  //     {y: '2011 Q1', item1: 2666},
  //     {y: '2011 Q2', item1: 2778},
  //     {y: '2011 Q3', item1: 4912},
  //     {y: '2011 Q4', item1: 3767},
  //     {y: '2012 Q1', item1: 6810},
  //     {y: '2012 Q2', item1: 5670},
  //     {y: '2012 Q3', item1: 4820},
  //     {y: '2012 Q4', item1: 15073},
  //     {y: '2013 Q1', item1: 10687},
  //     {y: '2013 Q2', item1: 8432}
  //   ],
  //   xkey: 'y',
  //   ykeys: ['item1'],
  //   labels: ['Item 1'],
  //   lineColors: ['#efefef'],
  //   lineWidth: 2,
  //   hideHover: 'auto',
  //   gridTextColor: "#fff",
  //   gridStrokeWidth: 0.4,
  //   pointSize: 4,
  //   pointStrokeColors: ["#efefef"],
  //   gridLineColor: "#efefef",
  //   gridTextFamily: "Open Sans",
  //   gridTextSize: 10
  // });

  //Donut Chart
  // var donut = new Morris.Donut({
  //   element: 'sales-chart',
  //   resize: true,
  //   colors: ["#3c8dbc", "#f56954", "#00a65a"],
  //   data: [
  //     {label: "Download Sales", value: 12},
  //     {label: "In-Store Sales", value: 30},
  //     {label: "Mail-Order Sales", value: 20}
  //   ],
  //   hideHover: 'auto'
  // });


  

  //-------------
  //- PIE CHART -
  //-------------
  // Get context with jQuery - using jQuery's .get() method.
  
  // var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
  // var pieChart = new Chart(pieChartCanvas);
  // var PieData = [
  //   {
  //     value:
  //     color: "#f56954",
  //     highlight: "#f56954",
  //     label: "Chrome"
  //   },
  //   {
  //     value:<?php echo $IE; ?>,
  //     color: "#00a65a",
  //     highlight: "#00a65a",
  //     label: "IE"
  //   },
  //   {
  //     value:<?php echo $FI; ?>,
  //     color: "#f39c12",
  //     highlight: "#f39c12",
  //     label: "FireFox"
  //   },
  //   {
  //     value:<?php echo $SA; ?>,
  //     color: "#00c0ef",
  //     highlight: "#00c0ef",
  //     label: "Safari"
  //   },
  //   {
  //     value:<?php echo $OP; ?>,
  //     color: "#3c8dbc",
  //     highlight: "#3c8dbc",
  //     label: "Opera"
  //   },
  //   {
  //     value:<?php echo $NA; ?>,
  //     color: "#d2d6de",
  //     highlight: "#d2d6de",
  //     label: "Navigator"
  //   }
  // ];

  // var pieOptions = {
  //   //Boolean - Whether we should show a stroke on each segment
  //   segmentShowStroke: true,
  //   //String - The colour of each segment stroke
  //   segmentStrokeColor: "#fff",
  //   //Number - The width of each segment stroke
  //   segmentStrokeWidth: 1,
  //   //Number - The percentage of the chart that we cut out of the middle
  //   percentageInnerCutout: 50, // This is 0 for Pie charts
  //   //Number - Amount of animation steps
  //   animationSteps: 100,
  //   //String - Animation easing effect
  //   animationEasing: "easeOutBounce",
  //   //Boolean - Whether we animate the rotation of the Doughnut
  //   animateRotate: true,
  //   //Boolean - Whether we animate scaling the Doughnut from the centre
  //   animateScale: false,
  //   //Boolean - whether to make the chart responsive to window resizing
  //   responsive: true,
  //   // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
  //   maintainAspectRatio: false,
  //   //String - A legend template
  //   legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>",
  //   //String - A tooltip template
  //   tooltipTemplate: "<%=value %> <%=label%> users"
  // };

  // //Create pie or douhnut chart
  // // You can switch between pie and douhnut using the method below.
  // pieChart.Doughnut(PieData, pieOptions);
  // //-----------------
  // //- END PIE CHART -
  // //-----------------


  //Fix for charts under tabs
  $('.box ul.nav a').on('shown.bs.tab', function () {
    area.redraw();
    donut.redraw();
    line.redraw();
  });

});
