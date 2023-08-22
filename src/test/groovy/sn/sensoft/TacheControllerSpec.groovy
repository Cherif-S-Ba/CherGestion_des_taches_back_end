package sn.sensoft
import grails.gorm.transactions.Transactional
import grails.testing.mixin.integration.Integration
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification


@Integration
@Transactional
class TacheControllerSpec extends Specification implements ControllerUnitTest<TacheController> {

    def setup() {
        controller.tacheService = Mock(TacheService)
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

}
