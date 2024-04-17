import React, {useState} from "react";

import {Enchere} from "../fragments/Enchere.jsx";

export const DetailVente = () => {
    const [enchere, setEnchere] =useState([])
    return (
        <>
            <div class="container-fluid">
                <div class="row title d-flex justify-content-center mb-4">
                    <div class="col-auto mt-5">
                        <h1 class="text-white text-center py-3">pseudo de l'acheteur a remporté l'enchère</h1>
                    </div>
                </div>
            </div>

            <div class="container mt-5">
                <Enchere isDetailMaVente  enchere={enchere}/>
            </div>
        </>
    )
}