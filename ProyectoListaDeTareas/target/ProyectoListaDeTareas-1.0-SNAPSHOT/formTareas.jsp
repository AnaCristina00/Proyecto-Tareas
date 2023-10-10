<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Inclución de la plantilla de header -->
<%@include file= "templates/header.jsp" %>


<div class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Tareas</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Aquí encontraras todas tus tareas</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-primary">Guardar</button>
      </div>
    </div>
  </div>
</div>














<!-- Inclución de la plantilla de footer -->
<%@include file= "templates/footer.jsp" %>