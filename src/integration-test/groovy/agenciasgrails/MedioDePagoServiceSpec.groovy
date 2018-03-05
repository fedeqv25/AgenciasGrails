package agenciasgrails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MedioDePagoServiceSpec extends Specification {

    MedioDePagoService medioDePagoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MedioDePago(...).save(flush: true, failOnError: true)
        //new MedioDePago(...).save(flush: true, failOnError: true)
        //MedioDePago medioDePago = new MedioDePago(...).save(flush: true, failOnError: true)
        //new MedioDePago(...).save(flush: true, failOnError: true)
        //new MedioDePago(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //medioDePago.id
    }

    void "test get"() {
        setupData()

        expect:
        medioDePagoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MedioDePago> medioDePagoList = medioDePagoService.list(max: 2, offset: 2)

        then:
        medioDePagoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        medioDePagoService.count() == 5
    }

    void "test delete"() {
        Long medioDePagoId = setupData()

        expect:
        medioDePagoService.count() == 5

        when:
        medioDePagoService.delete(medioDePagoId)
        sessionFactory.currentSession.flush()

        then:
        medioDePagoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MedioDePago medioDePago = new MedioDePago()
        medioDePagoService.save(medioDePago)

        then:
        medioDePago.id != null
    }
}
