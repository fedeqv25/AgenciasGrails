package agenciasgrails

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import grails.converters.JSON
import groovy.json.JsonSlurper

import java.lang.reflect.Type

class SuperController {

    def medioDePagoService
    def ubicacionService
    def agenciaService

    def index() {

        ArrayList<MedioDePago> mediosDePagoList = medioDePagoService.getPaymentMethods()
        [mediosDePagoList: mediosDePagoList]
    }

    def agenciasCercanas()
    {
        def address = params.address
        def encodeAddress = java.net.URLEncoder.encode(address, "UTF-8")

        Ubicacion location = ubicacionService.getCoordinates(encodeAddress)

        if(location.lat == null)
        {
            flash.message = message(code:'agencia.error.direccion')
            redirect action: "index", method: "get"
            return
        }

        ArrayList<Agencia> agenciasList = agenciaService.getAgencys(location, params.radio, params.paymentMethod)

        //[agenciasList: agenciasList, location: location]

        respond agenciasList: agenciasList, location: location

    }
}
