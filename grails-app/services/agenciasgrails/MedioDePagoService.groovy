package agenciasgrails

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

import java.lang.reflect.Type

@Transactional
class MedioDePagoService {


    def serviceMethod() {

    }

    def getPaymentMethods()
    {
        def url = new URL('https://api.mercadolibre.com/sites/MLA/payment_methods')
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozzilla/5.0")
        JsonSlurper json = new JsonSlurper()

        def lista = json.parse(connection.getInputStream())
        ArrayList<MedioDePago> mediosDePagoList = new ArrayList<MedioDePago>()

        lista.findAll()
        {
            it.payment_type_id == "ticket"
        }.each
        {
            it -> mediosDePagoList.add(new MedioDePago(payment_id: it.id, name: it.name, payment_type_id: it.payment_type_id))
        }

        return mediosDePagoList
    }
}
