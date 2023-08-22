package sn.sensoft


import grails.gorm.transactions.Transactional
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import sn.sensoft.security.TacheUser
import spock.lang.Specification


@Transactional
class TacheServiceSpec extends Specification implements ServiceUnitTest<TacheService>, DomainUnitTest<Tache> {

    TacheService tacheServices=new TacheService()
    def user =new TacheUser(username: "Yannick",password: "passer123")
    def tache = new Tache(nom: "tache1",dateCreation: new Date(),dateRealisation: new Date(),description: "c'est une tache",utilisateur: user)

    def setup() {

    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

   void "test saveService()"(){
        given:
             def tach =tacheServices.saveTache(tache)
       expect:
            tach.nom=="tache1"
   }
    void "test show()"(){
        given:

            tacheServices.saveTache(tache)
        when:
            def t =tacheServices.show(1)
        then:
            t.nom=="tache1"
    }
    def "test tacheCount()"() {
        given:
        user =new TacheUser(username: "CSB",password: "passer123")
        tache = new Tache(nom: "tache 1",dateCreation: new Date(),dateRealisation: new Date(),description: "c'est une tache",utilisateur: user)
        tacheServices.saveTache(tache)

        when:
        def count = tacheServices.tacheCount()

        then:
        count == 1
    }

    def "test list()"() {
        given:
        def user1 =new TacheUser(username: "CSB",password: "passer123")
        def tache1 = new Tache(nom: "tache 1",dateCreation: new Date(),dateRealisation: new Date(),description: "c'est une tache",utilisateur: user1)

        def user2 =new TacheUser(username: "Abdallah",password: "passer123")
        def tache2 = new Tache(nom: "tache 2",dateCreation: new Date(),dateRealisation: new Date(),description: "c'est une tache",utilisateur: user2)

        tacheServices.saveTache(tache1)
        tacheServices.saveTache(tache2)


        when:
        def taches = tacheServices.list([param: 2])
        def count = tacheServices.tacheCount()

        then:
        //count == 2
        taches.size()==2
    }

}
