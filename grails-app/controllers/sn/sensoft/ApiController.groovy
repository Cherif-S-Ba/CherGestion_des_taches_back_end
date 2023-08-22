package sn.sensoft

import grails.converters.JSON
import sn.sensoft.security.TacheUser

class ApiController {

    def index() { }

    def listTaches() {
        String username = params.username
        def user = TacheUser.findByUsername(username)
        def taches=Tache.findAllByUtilisateur(user)
        if(taches){
            render taches as JSON
        }else{
            respond status: 401
        }
    }

    def lister() {
        List<String> usersRoles = []

        def users = tacheUserService.listUserAndRole()

        users.each { user ->
            def userRoles = user.getAuthorities().collect { role -> role.authority }
            def data = [
                    id: user.id,
                    username: user.username,
                    password: user.password,
                    roles: userRoles
            ]
            usersRoles.add(data)
        }

        render usersRoles as JSON
    }
}
