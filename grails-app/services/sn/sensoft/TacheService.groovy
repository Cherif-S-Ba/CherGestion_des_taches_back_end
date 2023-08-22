package sn.sensoft

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import org.hibernate.TransientObjectException


@Transactional
class TacheService {

    Integer tacheCount(){
        return Tache.count()
    }

    def list(Map arg){
        def taches=Tache.getAll()
        if(taches != null){
            return taches
        }
        return null
    }

    def saveTache(Tache tache) {
        try {
            if (tache != null)
                return tache.save(flush: true)
        }catch (ValidationException e) {
                println("Erreur de validation : ${e.message}")
        }
        catch (TransientObjectException e) {
            println ("L'utilisateur n'a pas été sauvegardé : ${e.message}")
        }
    }

    def show(Long id){
        def tache1=Tache.get(id)
        if(tache1){
            return tache1
        }
        return null
    }

    def delete(Long id){
        def tache =Tache.get(id)
        if(tache){
            tache.delete()
        }
    }
}

