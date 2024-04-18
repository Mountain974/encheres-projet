import React, {useState} from "react";

import {Compte} from "../fragments/Compte.jsx";

export const ModifierProfil = () => {
    const utilisateur = {pseudo: 'john_doe', nom: 'Doe', prenom: 'John', email: 'john.doe@example.com', telephone: '0123456789', rue: 'Rue de la République', codePostal: '75001', ville: 'Paris', motDePasse: 'motdepasse123', credit: "100", administrateur: false}
    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Modifier mon profil</h1>
                    </div>
                </div>
            </div>
            <Compte utilisateur={utilisateur} isEdit />
        </>
    )
}