package agenciasgrails

class Direccion {

    String direccionPostal
    String medioDePago
    Integer radio

    static constraints = {

        direccionPostal blank: false
        medioDePago blank: false
        radio blank: false

    }
}
