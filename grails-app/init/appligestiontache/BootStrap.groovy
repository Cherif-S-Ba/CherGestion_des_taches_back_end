package appligestiontache


import grails.gorm.transactions.Transactional
import sn.sensoft.security.Role
import sn.sensoft.security.TacheUser
import sn.sensoft.security.TacheUserRole
import sn.sensoft.TacheService
import sn.sensoft.Tache

class BootStrap {


    def init = { servletContext ->
        createUserandTache()
    }

    @Transactional
    def createUserandTache(){
        def adminRole = new Role("ROLE_ADMIN").save()
        def userRole = new Role("ROLE_USER").save()
        def testUser= new TacheUser("csb","password").save()
        def adminUser = new TacheUser("admin", "admin").save()

        TacheUserRole.create testUser, userRole
        TacheUserRole.create adminUser, adminRole

        TacheUserRole.withSession {
            it.flush()
            it.clear()
        }

    }

    /*@Transactional
    def createUserandTache(){

        def user =new TacheUser(
                 username: 'Ibrahima',
                 password: 'passer123'
        )
         user.save(flush : true)

     if(user.id !=null){
         println("le id est ${user.id}")
     }else{
         println("rien n'a été inséré")
     }

         //def tache = new Tache()
        if(tacheService.saveService(nom: 'tache1',
                 dateCreation:new Date(),
                 dateRealisation:new Date(),
                 description:'Bonjour',
                 utilisateur: user) == null){
             println 'Tache créée avec succès'
         }else {
             println(tache.errors.toString())
         }
    }*/

    def destroy = {
    }
}
