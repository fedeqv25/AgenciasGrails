package agenciasgrails

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class UbicacionService {

    def serviceMethod() {

    }

    def getCoordinates(String address)
    {
        def url = new URL('https://maps.googleapis.com/maps/api/geocode/json?address=' + address + '&key=AIzaSyAD_6zTNUbHKdXntfCmiSSQXd-N7Wm53Sw')
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozzilla/5.0")
        JsonSlurper json = new JsonSlurper()

        def location = json.parse(connection.getInputStream())
        def lat = location.results.geometry.location.lat[0]
        def lng = location.results.geometry.location.lng[0]
        Ubicacion ubicacion = new Ubicacion(lat: lat, lng: lng)

        return ubicacion
    }

}
