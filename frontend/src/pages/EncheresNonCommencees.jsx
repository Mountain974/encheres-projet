import React from "react";

import {Article} from "../fragments/Article.jsx";

export const EncheresNonCommencees = () => {

    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Nouvelle vente</h1>
                    </div>
                </div>
            </div>
            <Article article={article} vendeur={vendeur} isExist/>
        </>
    )
}