package sn.sensoft

import grails.rest.Resource
import sn.sensoft.security.TacheUser

@Resource(formats = ['json','xml'])
class Tache {

    String nom
    Date dateCreation
    Date dateRealisation
    String description

    TacheUser utilisateur

    static belongsTo = [utilisateur : TacheUser]

    static constraints = {
        nom blank:false
        dateCreation nullable:false,blank:false
        dateRealisation nullable:false,blank:false
        description blank:false
    }

}

//curl -X POST -H "Content-Type: application/json" -d '{"nom": "Developpemnt","dateCreation": "2023-07-05","dateRealisation": "2023-07-06","description": "Mise en oeuvre d'une application de gestion des taches","utilisateur": {"id":3}}' http://localhost:8080/tache
//curl -H "accept:application/json" -H "Authorization: Bearer eyJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.dNA6UKl46uf3uheMWg6kSZW48FT8SnqshEI8SmPSP1DpvH6szZnJ8KUsR6oG9AcwiOSgW4M6BCIJ-t4GvJaelSvB5MS88pM2GEWFGYGWrsRP58wDcwRky5vsMw2Qe3oQFJ5t6aFirZ5nB5jf7Vruzpd4dKzd_9mqA3SJEwoWc0laVAm4X9BcwvPWxQVdNmr9s6b93jZXzNDfKngHQBQoVwvgGeH-zlIkxtm3BXyb6Gbo8bwilEG8O4p0qAr1l91aAQulfjC_g4pu8T-sJaPAS6ExDGl76zxRY_naxxY_J9hHdTTpKloi5pjfI04abBtEjsFn43Taqx2RcUe5s2OlpA.LwPAS4GdgwsjI79v.kT2KObwrXKtyA4el35aj6ul-7HvEBioCv1gYJFtBWeUVxBt4v8PcrU3gTKAfynC_aPmlkdWrlyhiM_me0A1M9uh8m3-sNX8FwUjphFlrn9Aitf4G-31ngJYxowDLLZHehl-IJ0Tl9JgyhNJDrjCDLMgY1KNgZhzKmJfpj2GzTHsQ3s8LIRmRiPioWDNGEU-8OJl6oPBSGkwKnWQOlybq3bg6-S6V4BQXfxVRtYjB3V4BEogGQR78oCq3U9aaVmLb7i3aJL5tOXvYpYLdk3smmkYkNmIsTGiZXUIs53am0P_druZPnP-ACrmJs78EO7YNBGpyi_RX5DmkFwt7XNma5SXHXlxT0UY56qPZ1k_8HHSDvuz8vuzGH52J603J_UW-uDTADu89pwV84bZD3H93kIfM3aXQ3vOIw9xp3gO-tqZ6LPcOAIQHh34_kxSLY8iJvkTELDp70cOfn9oqr6uUTguSuC0WOzzRj-GDs1hpK6fMCstvb2_npr80NJA6Bxb46DaEJ0XBgBRFrEvCL1K5DTK4l5FCqvt-Lpd9-Do2quuuYVaTPS0_7a_lr4cXaIODXqKo7d5AOQc0RFmbJKdnMy2MNvQR62Lc1retQWXc7xihmkagrFZQPlCXO29JNMlVjx1vi_3ady-UNClEAaGVLc1lwoLjbrry1nfEjwW14k8WsRs1DuCR_ICO_EvH2xi6P3zNA5saDYY2f1tG1n2MUzVfp1leB2-r-o2C50EzS5gafkLXCa699afzXlnoEwBW9vQPtCpXKNv2eOB0dJff3ob-9uCT14ExpXQanQPgaUvkEhv5q8SdFqd4NUFTlXvbKA_EBzxdvytB46K5QTXBNVGWS6u9y7Tz35dJVvfXVEAhy9B6hVtsLC6Q5yYxXq00kOFJTh0Aw_anKnWcY_PRrXTAz_iO2_O3oVeHoHTIL3POVK5b16ukJnN-C_klanVIOYHw3YaNI_SaWBz0bis1Tzh4j5urpMaxbtYZ2Cz2lThWOPfAbkGNpnpjEI1z.2uT0zRvdQHwehr87utxT-w" http://localhost:8080/api/tache