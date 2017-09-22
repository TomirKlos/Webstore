<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.js"></script>
    <link rel="stylesheet" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.7.0/themes/base/jquery-ui.css">
    <script type="text/javascript">

$(document).ready(function(){
                $('#productName').autocomplete({
                    source : '${pageContext.request.contextPath}/products/search/search'

                });

        });

            </script>
</head>
<body>

Product name <input type="text" id="productName">

</body>
</html>
