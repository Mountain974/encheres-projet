import React, {useState} from "react";

import {Compte} from "../fragments/Compte.jsx";

export const ModifierProfil = () => {
    const [compte, setCompte] =useState([])
    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Modifier mon profil</h1>**
                    </div>
                </div>
            </div>
            <Compte compte={compte} isEdit />
        </>
    )
}