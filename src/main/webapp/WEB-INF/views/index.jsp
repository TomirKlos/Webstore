<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.7.0/themes/base/jquery-ui.css">
    <!-- //code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css -->
    <script type="text/javascript">

$(document).ready(function(){
                $('#productName').autocomplete({
                    source : '${pageContext.request.contextPath}/products/search/search',
                    minChars: 3,
                    delay : 300

                });

        });

            </script>

    <style media="screen" type="text/css">
        .ui-autocomplete {
            margin:0;
            padding:0;
            list-style-type:none;
        border: solid 1px #ccc;
            background-color: #fff;
        width: 500px;
        }

        .ui-autocomplete li {
            font-family: Arial, Verdana, Sans-Serif;
            margin: 1px;
            cursor: pointer;
            display: block;
            height: 34px;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.428571429;
        }


        .ui-autocomplete .ui-state-focus { background-color: #66afe9; }
        a#ui-active-menuitem .ui-corner-all .ui-state-hover { background-color: #66afe9; }
        ui-state-hover {
            background-color: #66afe9;
        }

        .ui-helper-hidden-accessible { display:none; }

    </style>
</head>
<body>

Product name <input type="text" id="productName">

</body>
</html>
