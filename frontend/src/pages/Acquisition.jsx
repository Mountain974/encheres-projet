import React, {useState} from "react";
import {Enchere} from "../fragments/Enchere.jsx";

export const Acquisition = () => {
    const [enchere, setEnchere] =useState([])
    return (
        <>
            <div class="container-fluid">
                <div class="row title d-flex justify-content-center mb-4">
                    <div class="col-auto mt-5">
                        <h1 class="text-white text-center py-3">Vous avez remporté la vente</h1>
                    </div>
                </div>
            </div>

            <div class="container mt-5">
            <Enchere isAcquerir enchere={enchere}/>
            </div>
        </>
    )
}