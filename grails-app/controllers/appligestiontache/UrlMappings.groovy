package appligestiontache

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //Tache endpoint
        "/api/v1/getAll-taches"(controller: "Tache", action: "index")
        "/api/v1/save"(controller: "Tache", action: "save",method:'POST')
        "/api/v1/delete/$id"(controller: "Tache", action: "delete",method: 'DELETE')
        "/api/v1/update/$id"(controller: "Tache", action: "update",method: 'PUT')
        "/api/v1/get-tache/$id"(controller: "Tache", action: "show",method:'GET')
        "/api/v1/get-taches"(controller: "Api", action: "listTaches",method:'GET')

        //User endpoint
        "/api/v1/save-user"(controller: "TacheUser", action: "saveUser",method:'POST')
        "/api/v1/getAll-users"(controller: "TacheUser", action: "list",method:'GET')
        "/api/v1/get-user-infos"(controller: "TacheUser", action: "getUserInfos",method:'GET')
        "/api/v1/get-user-id"(controller: "TacheUser", action: "getUser",method:'GET')
        "/api/v1/get-user"(controller: "TacheUser", action: "showUser",method:'GET')
        "/api/v1/deleteUser/$id"(controller: "TacheUser", action: "deleteUser",method: 'DELETE')
        "/api/v1/update-user/$id"(controller: "TacheUser", action: "updateUser",method: 'PUT')

        //"/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
