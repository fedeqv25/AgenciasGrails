<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Agencias cercanas</title>
    <style>
        #map{
            height: 400px;
            width: 100%;
        }
    </style>
</head>
<body>

<table class="table">
    <tr>
        <th>Descripción</th>
        <th>Distancia (metros)</th>
        <th>Acciones</th>
    </tr>
    <g:each var="agencia" in="${agenciasList}">
        <tr>
            <td>${agencia.descripcion}</td>
            <td><g:formatNumber number="${agencia.distancia}" roundingMode="HALF_UP"/></td>
            <td>
                <button class="btn btn-primary" onclick="modal('${agencia.idAgencia}')" type="button">
                    Detalle
                </button>
            </td>
        </tr>
        <g:render template="templates/modal" model="['id':agencia.idAgencia, 'agency':agencia]"/>
    </g:each>
</table>

<div id="map"></div>


<script>

    function modal(id)
    {
        $('#' + id).modal('toggle').modal('show');
    }


</script>

<script>

    function initMap() {


        var map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: ${location.lat}, lng: ${location.lng}},
            zoom: 15
        });

        var marker = new google.maps.Marker({
            position: {lat: ${location.lat}, lng: ${location.lng}},
            icon:"http://maps.google.com/mapfiles/ms/icons/blue-dot.png",
            map: map
        });

        <g:each var="agency" in="${agenciasList}">
        var position = {lat: ${agency.lat}, lng: ${agency.lng}};
        console.log(position);
        var marker = new google.maps.Marker({

            position: {lat: ${agency.lat}, lng: ${agency.lng}},
            icon:"http://maps.google.com/mapfiles/ms/icons/red-dot.png",
            map: map
        });
        </g:each>
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAD_6zTNUbHKdXntfCmiSSQXd-N7Wm53Sw&callback=initMap">
</script>


</body>

</html>