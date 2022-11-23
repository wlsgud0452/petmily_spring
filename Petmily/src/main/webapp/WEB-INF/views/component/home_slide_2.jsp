<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "년도별 유기동물 수"
	},
	axisX:{      
		interval: 1,
		intervalType: "year",
		labelFontColor: "rgb(61, 61, 61)"
	},
	axisY: {
		title: "유기동물 수",
		interlacedColor: "#ffebd6",
		gridThickness: 0,
		tickColor: "azure",
		titleFontColor: "rgb(61, 61, 61)",
		interval: 2000
	},
	data: [{
		type: "column", //change type to bar, line, area, pie, etc
		dataPoints: ${dataPoints}
	}]
});
chart.render();

var chart2 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "년도별 안락사 비율"
	},
	axisX:{      
		interval: 1,
		intervalType: "year",
		labelFontColor: "rgb(61, 61, 61)"
	},
	axisY: {
		title: "안락사 비율",
		interlacedColor: "#ffebd6",
		gridThickness: 0,
		tickColor: "azure",
		titleFontColor: "rgb(61, 61, 61)",
		interval: 10,
	},
	data: [{
		type: "line", //change type to bar, line, area, pie, etc
		color: "#99582c",
		dataPoints: ${euthanasiaRatio}
	}]
});
chart2.render();
 
}
</script>

	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	
	<h6>[마리 / 연도]</h6>
	
	<div style="padding-top: 5rem"></div>
	
	<div id="chartContainer2" style="height: 370px; width: 100%;"></div>
	
	<h6>[안락사 비율 / 연도]</h6>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
