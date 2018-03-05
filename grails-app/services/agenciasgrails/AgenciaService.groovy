package agenciasgrails

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class AgenciaService {

    def serviceMethod() {

    }

    def getAgencys(Ubicacion location, String radio, String payment_method)
    {
        def lat = location.lat
        def lng = location.lng
        def url = new URL('https://api.mercadolibre.com/sites/MLA/payment_methods/' + payment_method
                + '/agencies?near_to=' + location.lat + ',' + location.lng
                +',' + radio)
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozzilla/5.0")
        JsonSlurper json = new JsonSlurper()

        def lista = json.parse(connection.getInputStream())

        ArrayList<Agencia> agenciasList = new ArrayList<Agencia>()


        lista.results.each
                {
                    def other

                    def coord = it.address.location
                    def coordinates = coord.split(',')
                    def lat1 = coordinates[0]
                    def lng1 = coordinates[1]


                    if(it.address.other_info == null)
                    {
                        other = ""
                    }
                    else{other = it.address.other_info }

                    agenciasList.add(new Agencia(idAgencia: it.id, descripcion: it.description, distancia: it.distance,
                    direccion: it.address.address_line, ciudad: it.address.city, pais: it.address.country,
                    localizacion: it.address.location, lat: lat1, lng: lng1, estado: it.address.state, codigoPostal: it.address.zip_code,
                    otro: other))
                }


        return agenciasList
    }
}
