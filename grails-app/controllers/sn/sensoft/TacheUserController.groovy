package sn.sensoft

import grails.converters.JSON
import org.springframework.security.core.userdetails.UsernameNotFoundException
import sn.sensoft.security.TacheUser
class TacheUserController {

    TacheUserService tacheUserService

    def index(){}

    def list() {
        List<String> usersRoles = []

        def users = tacheUserService.listUser()

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

    def saveUser(TacheUser user) {
        def us = tacheUserService.saveUser(user,params.role)
        if(us!=null)
            render us as JSON
    }

    def showUser(){
        String id =params.id
        def user = tacheUserService.getUser(id)
        render user as JSON
    }

    def deleteUser(Long id){
        tacheUserService.deleteUser(id)
    }

    def getUserInfos() {

        String username = params.username
        def user = TacheUser.findByUsername(username)
        println(user.id)
        if(user){
            def data = [
                    id:user.id,
                    username:user.username
            ]
            render data as JSON
        }else{
            respond status:404
        }
    }

    def getUser() {
        String id = params.id
        def user = TacheUser.findById(id)
        if(user){
            def data = [
                    username:user.username,
            ]
            render data as JSON
        }else{
            respond status: 404
        }
    }

    def updateUser(TacheUser user){
        tacheUserService.updateUser(params.id,user.username,user.password,params.role)
    }

}
