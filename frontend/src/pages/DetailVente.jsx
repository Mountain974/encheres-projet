import React, {useState} from "react";

import {Enchere} from "../fragments/Enchere.jsx";

export const DetailVente = () => {
    const [enchere, setEnchere] =useState([])
    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">pseudo de l'acheteur a remporté l'enchère</h1>
                    </div>
                </div>
            </div>

            <div className="container mt-5">
                <Enchere isDetailMaVente  enchere={enchere}/>
            </div>
        </>
    )
}