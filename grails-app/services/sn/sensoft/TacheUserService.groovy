package sn.sensoft

import grails.gorm.transactions.Transactional
import sn.sensoft.security.Role
import sn.sensoft.security.TacheUser
import sn.sensoft.security.TacheUserRole

@Transactional
class TacheUserService {

    def serviceMethod() {

    }

    def listUser(){
        def users = TacheUser.listOrderById()
        return users
    }

    def saveUser(TacheUser user, String roleUser) {
        if (user != null) {
            def us = TacheUser.findByUsername(user.username)
            if (us == null)  {
                def userResult = user.save(flush: true)

                def role = Role.findByAuthority(roleUser)
                role.save(flush: true)

                TacheUserRole.create(userResult, role, true)

                return userResult
            }
        } else
            return null
    }

    def getUser(String id) {
        if (id != null) {
            def user = TacheUser.findById(id)
            return user
        }
    }

    void deleteUser(Long id) {
        def user = TacheUser.get(id)
        if (user) {
            TacheUserRole.findAllByTacheUser(user).each { userRole ->
                userRole.delete()
            }
            if (Tache.findAllByUtilisateur(user)) {
                Tache.findAllByUtilisateur(user).each { tache ->
                    tache.delete()
                }
            }
            user.delete()
        }
    }

    def updateUser(String id, String username, String password, String role) {
        def user = TacheUser.findById(id)

        if (user != null  && role != null) {
            user.username = username
            user.password = password
            user.save(flush: true)

            def roleResult = Role.findByAuthority(role)
            roleResult.save(flush: true)

            TacheUserRole.create(user, roleResult, true)
            if (role == "ROLE_ADMIN") {
                def roleResult2 = Role.findByAuthority("ROLE_USER")
                TacheUserRole.remove(user, roleResult2)
            } else {
                def roleResult2 = Role.findByAuthority("ROLE_ADMIN")
                TacheUserRole.remove(user, roleResult2)
            }
        }
    }
}