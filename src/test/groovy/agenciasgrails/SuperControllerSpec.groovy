package agenciasgrails

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class SuperControllerSpec extends Specification implements ControllerUnitTest<SuperController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
