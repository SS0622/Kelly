<!-- logViewer.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>ログ表示</title>
</head>
<body>
    <h1>ログ</h1>
    <pre>
        <%
            List<String> logs = (List<String>) request.getAttribute("logs");
            if (logs != null) {
                for (String log : logs) {
                    out.println(log + "<br>");
                }
            }
        %>
    </pre>
</body>
</html>