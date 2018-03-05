package agenciasgrails

class MedioDePagoController {


    MedioDePagoService medioDePagoService

    def index() { }

    def getPaymentMethods()
    {
        respond medioDePagoService.getPaymentMethods()
    }
}
