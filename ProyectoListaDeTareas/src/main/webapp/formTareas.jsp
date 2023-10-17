<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Inclución de la plantilla de header -->
<%@include file= "templates/header.jsp" %>

<h1>Mis Tareas</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Tarea</th>
                <th>Descripción</th>
                <th>Fecha de Vencimiento</th>
                <th>Completada</th>
            </tr>
        </thead>
        <tbody>
            <!-- Utiliza JSP para generar filas de la tabla con datos de tareas -->
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.name}</td>
                    <td>${task.description}</td>
                    <td>${task.dueDate}</td>
                    <td>${task.completed ? 'Sí' : 'No'}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>









<!-- Inclución de la plantilla de footer -->
<%@include file= "templates/footer.jsp" %>