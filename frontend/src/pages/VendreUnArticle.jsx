import React from "react";

import {Article} from "../fragments/Article.jsx";

export const VendreUnArticle = () => {
    //const utilisateur = {pseudo: 'john_doe', nom: 'Doe', prenom: 'John', email: 'john.doe@example.com', telephone: '0123456789', rue: 'Rue de la République', codePostal: '75001', ville: 'Paris', motDePasse: 'motdepasse123', credit: 100, administrateur: false}
    const utilisateur = {
        "nom": "Wilson",
        "rue": "Rue du Faubourg Saint-Honoré",
        "email": "emily.wilson@example.com",
        "ville": "Paris",
        "credit": 50,
        "prenom": "Emily",
        "pseudo": "emily_wilson",
        "telephone": "9870123456",
        "codePostal": "75008",
        "motDePasse": "safepass",
        "administrateur": true,
        "noUtilisateur": 4
    }
    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Nouvelle vente</h1>
                    </div>
                </div>
            </div>
            <Article vendeur={utilisateur}/>
        </>
    )
}