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
	data: [{
		type: "line", //change type to bar, line, area, pie, etc
		dataPoints: ${euthanasiaRatio}
	}]
});
chart2.render();
 
}
</script>

	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	
	<div style="padding-top: 5rem"></div>
	
	<div id="chartContainer2" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
