package sn.sensoft

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_USER'])
class TacheController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    TacheService tacheService

    def index() {
        params.max = Math.min(max ?: 10, 100)
        def taches = tacheService.list(params, [sort: 'id', order: 'desc'])

        respond taches, model: [tacheCount: tacheService.tacheCount()]
    }

    def listTachesRoles() {
        List<String> tachesRoles = []

        def taches = tacheService.list()

        taches.each { user ->
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

    def show(Long id) {
        def tache = tacheService.show(id)
        if (tache != null) {
            respond tache
        }
    }

    def save(Tache tache) {
        if(tache != null){
           def tacheResults= tacheService.saveTache(tache)
            respond tacheResults
        } else {
            respond tache.errors
        }
    }

    def delete(Long id) {
        tacheService.delete(id)
    }

    def update(Long id) {

        def tache = Tache.get(id)
        if (tache) {
            tache.properties = params
            tacheService.saveTache(tache)
        }
    }

}

