<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AAPL + FB</title>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {
		$('#table').bootstrapTable({
			data : ${json}
		});
	});
</script>
</head>
<body>
	<form id="form1" runat="server">
		<table id="table">
			<thead>
				<tr>
					<th data-field="1. symbol">Symbol</th>
					<th data-field="2. price">Price</th>
					<th data-field="3. volume">Volume</th>
					<th data-field="4. timestamp">Timestamp</th>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>