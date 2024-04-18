import React from "react";

import {Article} from "../fragments/Article.jsx";

export const VendreUnArticle = () => {

    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4 shadow-lg p-3 mb-5">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Nouvelle vente</h1>
                    </div>
                </div>
            </div>
            <Article vendeur={vendeur}/>
        </>
    )
}