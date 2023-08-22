package sn.sensoft

import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import sn.sensoft.security.Role
import sn.sensoft.security.TacheUser
import spock.lang.Specification

import javax.transaction.Transactional

@Transactional
class TacheUserServiceSpec extends Specification implements ServiceUnitTest<TacheUserService>, DomainUnitTest<TacheUser>{



    def setup(){

    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

}
