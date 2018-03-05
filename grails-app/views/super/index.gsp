<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Buscador de Agencias</title>
</head>
<body>
<g:if test="${flash.message}">
    <div class="message" role="alert">${flash.message}</div>
</g:if>

<g:form controller="Super">
    <p>dirección:</p>
    <input type="text" name="address" required="true">
    <p>Medio de Pago:</p>
    <g:select name="paymentMethod"
              from="${mediosDePagoList}"
              value="${{it.payment_id}}"
              optionValue="${{it.name}}"
              optionKey="payment_id"/>
    <p>Radio de busqueda (metros):</p>
    <input type="number" name="radio" required="true">
    <br>
    <br>
    <g:actionSubmit value="Buscar" action="agenciasCercanas"/>
</g:form>


</body>
</html>