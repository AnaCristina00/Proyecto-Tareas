<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Inclución de la plantilla de header -->
<%@include file= "templates/header.jsp" %>
<link rel="stylesheet" type="text/css" href="styles.css">
<section class="vh-100 login-section">
<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
          class="img-fluid" alt="Phone image">
        <h3 class="custom-leter center-text">¡Bienvenido!</h3><br> 
            
          <!-- conecta con el servlet de login -->
          <form action="SvLogin" method="post">

      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
        <form>
          <!-- Email input -->
          <div class="form-outline mb-4">
              <input type="text" id="cedula" class="form-control form-control-lg" name="cedula" maxlength="10" required pattern="[0-9]+" title="Ingrese sólo números">
            <label class="form-label custom-heading for="form1Example13">Cédula</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
              <input type="password" id="contraseña" class="form-control form-control-lg" name="contraseña"required>
            <label class="form-label custom-heading" for="form1Example23">Contraseña</label>
          </div>

          <div class="d-flex justify-content-around align-items-center mb-4">
            <!-- Checkbox -->
            <!-- comment<div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
              <label class="form-check-label" for="form1Example3"> Remember me </label>
            </div> -->
            <p class="custom-heading" >No tienes una cuenta? <a href="registro.jsp">Registrate aquí</a></a></p>
          </div>

          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-lg btn-block custom-heading">Ingresar</button>

          <!-- comment <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
          </div>

          <a class="btn btn-primary btn-lg btn-block" style="background-color: #3b5998" href="#!"
            role="button">
            <i class="fab fa-facebook-f me-2"></i>Continue with Facebook
          </a>
          <a class="btn btn-primary btn-lg btn-block" style="background-color: #55acee" href="#!"
            role="button">
            <i class="fab fa-twitter me-2"></i>Continue with Twitter</a> -->

        </form>
      </div>
    </div>
  </div>
</section>
</section>

<!-- Verificamos al usuario -->
    <%
    String existente=(String)request.getAttribute("existente");
    if(existente !=null && existente.equals("verdaddero")){
    %>
    <script>
        $(document).ready(function () {
            usuarioVerificado();
        });
    </script>
    <% }
    if(existente!=null && existente.equals("falso")){
    %>
    <script>
        $(document).ready(function () {
           cedulaExistente();
        });
    </script>
    <%
        }
        String noExistente = request.getParameter("noExistente");
        if (noExistente != null && noExistente.equals("false")) {
    %>
    <script>
        $(document).ready(function () {
            usuarioSinVerificar();
        });
    </script>
    <%
        }
        // Limpiar los atributos de la solicitud
        request.removeAttribute("existente");
        request.removeAttribute("noExistente");
    %>
    
    <!-- Registro correcto-->
    <div class="modal fade" id="usuarioRegistrado" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="registradoLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body text-center align-middle">
                    <h3 align="center">Usuario registrado correctamente</h3>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
    
     <!-- Modal en caso de que la cédula ya este registrada -->
    <div class="modal fade" id="mensajeAlerta" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="mensajeAlertaLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body text-center align-middle">
                    <h2>Datos inválidos</h2>
                    <p>La cédula que intenta ingresar ya esta registrada</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
    
    



<!-- Inclución de la plantilla de footer -->
<%@include file= "templates/footer.jsp" %>

